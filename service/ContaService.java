package service;

import entity.Conta;
import repository.ContaRepository;

public class ContaService {

    private ContaRepository repository = new ContaRepository();

    public void criarConta(Conta novaConta) {
        
        if (novaConta.getNumero() == null || novaConta.getNumero().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O número da conta é obrigatório.");
        }

        if (novaConta.getSaldo() < 0) {
            throw new IllegalArgumentException("Erro: O saldo inicial da conta não pode ser negativo.");
        }

        if (novaConta.getTipo() == null) {
            throw new IllegalArgumentException("Erro: O tipo da conta (Corrente/Poupança) é obrigatório.");
        }

        if (novaConta.getAgencia() == null) {
            throw new IllegalArgumentException("Erro: A conta precisa estar vinculada a uma Agência válida.");
        }

        if (novaConta.getCliente() == null) {
            throw new IllegalArgumentException("Erro: A conta precisa estar vinculada a um Cliente cadastrado.");
        }

        repository.salvar(novaConta);
    }

    // Adicione dentro do ContaService:

    public void depositar(Conta conta, double valor) {
        // Regra 1: Não existe depósito de R$ 0,00 ou valor negativo
        if (valor <= 0) {
            throw new IllegalArgumentException("Erro: O valor do depósito deve ser maior que zero.");
        }
        
        // Pega o saldo atual, soma com o valor do depósito e salva de volta
        double novoSaldo = conta.getSaldo() + valor;
        conta.setSaldo(novoSaldo);
        
        // Aqui você manda o repositório atualizar a conta com o novo saldo!
        // repository.atualizar(conta); // (Descomente se o seu repositório tiver um método de atualizar)
        
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
    }

    public void sacar(Conta conta, double valor) {
        // Regra 1: Não existe saque de valor negativo
        if (valor <= 0) {
            throw new IllegalArgumentException("Erro: O valor do saque deve ser maior que zero.");
        }
        
        // Regra 2: O leão de chácara não deixa sacar se não tiver dinheiro!
        if (conta.getSaldo() < valor) {
            throw new IllegalArgumentException("Erro: Saldo insuficiente. Seu saldo atual é R$ " + conta.getSaldo());
        }
        
        // Subtrai o valor e atualiza a conta
        double novoSaldo = conta.getSaldo() - valor;
        conta.setSaldo(novoSaldo);
        
        // repository.atualizar(conta);
        
        System.out.println("Saque de R$ " + valor + " autorizado com sucesso!");
    }

    public Conta buscarContaPorNumero(String numeroConta) {
        if (numeroConta == null || numeroConta.trim().isEmpty()) {
            throw new IllegalArgumentException("Número da conta é obrigatório!");
        }
        Conta contaEncontrada = repository.buscarPorNumero(numeroConta);
        if (contaEncontrada == null) {
            throw new IllegalArgumentException("Conta não encontrada no sistema!");
        }
        return contaEncontrada;
    }

    public Conta buscarContaPorDocumentoDoCliente(String documento) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Documento é obrigatório para buscar a conta!");
        }
        
        Conta contaEncontrada = repository.buscarPorDocumentoDoCliente(documento);
        
        if (contaEncontrada == null) {
            throw new IllegalArgumentException("Nenhuma conta vinculada a este CPF/CNPJ foi encontrada.");
        }
        
        return contaEncontrada;
    }
}