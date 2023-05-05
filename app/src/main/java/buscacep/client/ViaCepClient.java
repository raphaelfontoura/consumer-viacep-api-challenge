package buscacep.client;

import buscacep.model.Endereco;
import buscacep.usecase.BuscaEndereco;
import buscacep.usecase.SalvarArquivoJson;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepClient implements BuscaEndereco {
    HttpClient client;
    HttpRequest request;
    Gson gson;

    public ViaCepClient() {
        client = HttpClient.newHttpClient();
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .create();
    }

    @Override
    public Endereco getEnderecoPeloCep(String cep) {
        var enderecoResult = requestEndereco(cep);
        return enderecoResult.getEndereco();
    }

    public EnderecoViaCep requestEndereco(String cep) {
        try {
            request = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/"+cep+"/json"))
                    .build();
            var result = client.send(request, HttpResponse.BodyHandlers.ofString());
            var enderecoResult = gson.fromJson(result.body(), EnderecoViaCep.class);
            SalvarArquivoJson.salvaArquivo(result.body(), cep);
            return enderecoResult;
        } catch (IOException | InterruptedException err) {
            throw new ViaCepClientException("Falha ao tentar recuperar o endereco do cep "+ cep);
        }
    }

}

record EnderecoViaCep(
       String cep,
       String logradouro,
       String complemento,
       String bairro,
       String localidade,
       String uf
) {
    public Endereco getEndereco() {
        return new Endereco(cep, logradouro, bairro, localidade, uf);
    }
}
