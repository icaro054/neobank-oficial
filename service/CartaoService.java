package service;

import entity.Cartao;
import repository.CartaoRepository;

public class CartaoService {

    private CartaoRepository repository = new CartaoRepository();

    public void criarCartao(Cartao novoCartao) {
        
        if (novoCartao.getNumero() == null || novoCartao.getNumero().length() != 16) {
            throw new IllegalArgumentException("Cartão inválido: O número deve conter exatamente 16 dígitos.");
        }

        if (novoCartao.getNomeTitular() == null || novoCartao.getNomeTitular().trim().isEmpty()) {
            throw new IllegalArgumentException("Cartão inválido: O nome do titular é obrigatório.");
        }

        if (novoCartao.getCvv() == null || novoCartao.getCvv().length() != 3) {
            throw new IllegalArgumentException("Cartão inválido: O CVV deve conter 3 dígitos.");
        }

        if (novoCartao.getValidade() == null || novoCartao.getValidade().trim().isEmpty()) {
            throw new IllegalArgumentException("Cartão inválido: A data de validade é obrigatória.");
        }

        if (novoCartao.getLimite() < 0) {
            throw new IllegalArgumentException("Cartão inválido: O limite do cartão não pode ser negativo.");
        }
        repository.salvar(novoCartao);
    }
}
