package controller;

import entity.Transacao;
import entity.Conta;
import service.TransacaoService;
import java.util.List;

public class TransacaoController {
    private TransacaoService service = new TransacaoService();

    public void registrar(Conta conta, double valor, String tipo) {
        service.registrarTransacao(conta, valor, tipo);
    }

    public List<Transacao> exibirExtrato(String numeroConta) {
        return service.buscarPorConta(numeroConta);
    }
}