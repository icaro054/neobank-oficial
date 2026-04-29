package service;

import entity.Transacao;
import entity.Conta;
import repository.TransacaoRepository;
import java.util.List;

public class TransacaoService {
    private TransacaoRepository repository = new TransacaoRepository();

    public void registrarTransacao(Conta conta, double valor, String tipo) {
        Transacao transacao = new Transacao();

        transacao.setValor(valor);
        transacao.setTipo(tipo);
        transacao.setConta(conta);

        repository.salvar(transacao);
    }

    public List<Transacao> buscarPorConta(String numeroConta) {
        return repository.buscarPorConta(numeroConta);
    }
}