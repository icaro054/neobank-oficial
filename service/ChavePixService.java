package service;

import entity.ChavePix;
import repository.ChavePixRepository;

public class ChavePixService {

    private ChavePixRepository repository = new ChavePixRepository();

    public void criarChavePix(ChavePix novaChave) {
        
        
        if (novaChave.getTipoChave() == null || novaChave.getTipoChave().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O tipo da chave Pix é obrigatório.");
        }

        if (novaChave.getValorChave() == null || novaChave.getValorChave().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O valor da chave Pix não pode estar vazio.");
        }

        if (novaChave.getValorChave().contains(" ")) {
            throw new IllegalArgumentException("Erro: O valor da chave Pix não pode conter espaços.");
        }

        if (novaChave.getConta() == null) {
            throw new IllegalArgumentException("Erro: A chave Pix precisa estar vinculada a uma Conta válida.");
        }

        if (novaChave.getCliente() == null) {
            throw new IllegalArgumentException("Erro: A chave Pix precisa estar vinculada a um Cliente.");
        }

        repository.salvar(novaChave);
    }
}