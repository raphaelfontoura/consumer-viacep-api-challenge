package buscacep.usecase;

import java.io.FileWriter;
import java.io.IOException;

public class SalvarArquivoJson {

    public static void salvaArquivo(String dados, String titulo) throws IOException {
        try (var fileWriter = new FileWriter(titulo+".json")) {
            fileWriter.write(dados);
        }
    }
}
