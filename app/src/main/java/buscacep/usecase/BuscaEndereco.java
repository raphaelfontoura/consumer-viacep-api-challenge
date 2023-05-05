package buscacep.usecase;

import buscacep.model.Endereco;

public interface BuscaEndereco {
    Endereco getEnderecoPeloCep(String cep);
}
