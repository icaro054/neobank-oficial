package controller;

import entity.Cliente;
import entity.Conta;
import entity.TipoConta;
import service.ContaService;

public class ContaController {
    private ContaService service = new ContaService();

    public Conta criarConta(Cliente cliente, TipoConta tipo) {
        return service.criarConta(cliente, tipo);
    }

    public void depositar(Conta conta, double valor) {
        service.depositar(conta, valor);
    }

    public void sacar(Conta conta, double valor) {
        service.sacar(conta, valor);
    }
}