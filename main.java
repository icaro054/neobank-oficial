/* main desativado momentaneamente para ajustes nas classes de entidade (removendo id e ajustando construtores) 


000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000import entity.*;
import controller.*;
import exception.SaldoInsuficiente;
import java.util.*;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
 
        System.out.println("   SISTEMA BANCÁRIO NEOBANK       ");

        ClienteController clienteController = new ClienteController();
        ContaController contaController = new ContaController();
        TransacaoController transacaoController = new TransacaoController();

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = sc.nextLine();

        Cliente cliente = clienteController.registrar(nome, cpf);

        Endereco endereco = new Endereco();
        System.out.print("Rua: ");
        endereco.setRua(sc.nextLine());

        System.out.print("Número: ");
        endereco.setNumero(sc.nextInt());
        sc.nextLine(); 

        System.out.print("Bairro: ");
        endereco.setBairro(sc.nextLine());

        System.out.print("Cidade: ");
        endereco.setCidade(sc.nextLine());

        System.out.print("Estado: ");
        endereco.setEstado(sc.nextLine());

        System.out.print("CEP (Somente números): ");
        endereco.setCep(sc.nextInt());
        sc.nextLine(); 

        cliente.setEndereco(endereco);

        Conta conta = contaController.criarConta(cliente, TipoConta.CORRENTE);

        Agencia agencia = new Agencia();
        agencia.setNome("Agência Central");
        agencia.setNumero("001");
        conta.setAgencia(agencia);

        System.out.print("Digite sua chave PIX: ");
        String chavePix = sc.nextLine();

        ChavePix pix = new ChavePix();
        pix.setValorChave(chavePix);
        pix.setTipoChave("EMAIL");
        pix.setConta(conta);

        Cartao cartao = new Cartao();
        cartao.setNumero("1234 5678 0000 9999");
        cartao.setNomeTitular(cliente.getNome());
        cartao.setValidade("12/30");
        cartao.setCvv("123");
        cartao.setLimite(3000);
        cartao.setTipo("CREDITO");
        cartao.setConta(conta);

        Fatura fatura = new Fatura(
            "F001",
            350.0,
            "Compra Mercado",
            "10/05/2026", 
            cartao
        );

        Parcela parcela = new Parcela();
        parcela.setId("P001");
        parcela.setNumeroParcelas(1);
        parcela.setValorParcela(350.0);
        parcela.setDataVencimento("10/05/2026"); 
        parcela.setPaga(false);
        parcela.setFatura(fatura);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId("EMP001");
        emprestimo.setValorTotal(5000);
        emprestimo.setTaxaJuros(0.02);
        emprestimo.setNumeroParcelas(12);
        emprestimo.setDataInicio("01/04/2026"); 
        emprestimo.setDataFim("01/04/2027"); 
        emprestimo.setConta(conta);

        int opcao = -1;

        do {
            System.out.println("\n MENU DE OPERAÇÕES ");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Extrato de Transações");
            System.out.println("4 - Ver Resumo Completo da Conta (Produtos)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            
            try {
                opcao = sc.nextInt();
                sc.nextLine(); 

                switch (opcao) {
                    case 1:
                        System.out.print("Valor do depósito: R$ ");
                        double dep = sc.nextDouble();
                        sc.nextLine(); // Limpa o buffer
                        contaController.depositar(conta, dep);
                        transacaoController.registrar(conta, dep, "DEPOSITO");
                        System.out.println("Depósito realizado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Valor do saque: R$ ");
                        double saque = sc.nextDouble();
                        sc.nextLine(); // Limpa o buffer
                        
                        try {
                            contaController.sacar(conta, saque);
                            transacaoController.registrar(conta, saque, "SAQUE");
                            System.out.println("Saque realizado com sucesso!");
                        } catch (SaldoInsuficiente e) {
                            System.out.println(" OPERAÇÃO NEGADA: " + e.getMessage());
                        }
                        break;

                    case 3:
                        List<Transacao> extrato = transacaoController.exibirExtrato(conta.getNumero());
                        System.out.println("\n EXTRATO BANCÁRIO ");
                        if(extrato == null || extrato.isEmpty()){
                             System.out.println("Nenhuma transação realizada.");
                        } else {
                            for (Transacao t : extrato) {
                                System.out.println("[ " + t.getTipo() + " ] - R$ " + t.getValor());
                            }
                        }
                        break;

                    case 4:
                        System.out.println("\n RESUMO DE PRODUTOS NEOBANK ");
                        System.out.println("Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")");
                        System.out.println("Conta: " + conta.getNumero() + " | Agência: " + conta.getAgencia().getNumero());
                        System.out.println("Saldo Atual: R$ " + conta.getSaldo());
                        System.out.println("Chave PIX Ativa: " + pix.getValorChave());
                        System.out.println("Cartão de Crédito final " + cartao.getNumero().substring(15) + " | Limite: R$ " + cartao.getLimite());
                        System.out.println("Fatura Atual: R$ " + fatura.getValor() + " (Venc: " + fatura.getDataVencimento() + ")");
                        System.out.println("Empréstimo Ativo: R$ " + emprestimo.getValorTotal() + " (12 parcelas)");
                        break;

                    case 0:
                        System.out.println("\nEncerrando sistema... Obrigado por usar o NeoBank!");
                        break;
                        
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();

    }
}
*/