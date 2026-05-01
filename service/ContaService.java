package service;

import entity.Cliente;
import entity.Conta;
import entity.TipoConta;
import exception.SaldoInsuficiente;
import repository.ContaRepository;
import util.GeradorConta;

public class ContaService {
    private ContaRepository repository = new ContaRepository();

    public Conta criarConta(Cliente cliente, TipoConta tipo) {
        Conta conta = new Conta();
        conta.setNumero(GeradorConta.gerarNumero());
        conta.setCliente(cliente);
        conta.setTipo(tipo);
        conta.setSaldo(0.0); 
        
        repository.salvar(conta);
        return conta;
    }

    public void depositar(Conta conta, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido! O depósito deve ser maior que zero.");
        }
        conta.setSaldo(conta.getSaldo() + valor);
    }

    public void sacar(Conta conta, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido! O saque deve ser maior que zero.");
        }
        
        if (conta.getSaldo() < valor) {
            throw new SaldoInsuficiente("Saldo insuficiente para o saque!");
        }
        
        conta.setSaldo(conta.getSaldo() - valor);
    }
}