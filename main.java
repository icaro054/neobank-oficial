import entity.*;
import controller.*;
import exception.SaldoInsuficiente;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("=== SISTEMA BANCÁRIO NEOBANK ===\n");

            // CONTROLLERS
            ClienteController clienteController = new ClienteController();
            ContaController contaController = new ContaController();
            TransacaoController transacaoController = new TransacaoController();

            // DADOS DO CLIENTE
            System.out.print("Digite seu nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite seu CPF: ");
            String cpf = sc.nextLine();

            Cliente cliente = clienteController.registrar(nome, cpf);

            // ENDERECO
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

            System.out.print("CEP: ");
            endereco.setCep(sc.nextInt());
            sc.nextLine();

            cliente.setEndereco(endereco);

            // CONTA
            Conta conta = contaController.criarConta(cliente, TipoConta.CORRENTE);

            // AGENCIA
            Agencia agencia = new Agencia();
            agencia.setNome("Agência Central");
            agencia.setNumero("001");
            conta.setAgencia(agencia);

            // PIX
            System.out.print("Digite sua chave PIX: ");
            String chavePix = sc.nextLine();

            ChavePix pix = new ChavePix();
            pix.setValorChave(chavePix);
            pix.setTipoChave("EMAIL");
            pix.setConta(conta);

            // MENU DE OPERACOES
            int opcao;

            do {
                System.out.println("\n1 - Depositar");
                System.out.println("2 - Sacar");
                System.out.println("3 - Ver Extrato");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Valor depósito: ");
                        double dep = sc.nextDouble();
                        contaController.depositar(conta, dep);
                        transacaoController.registrar(conta, dep, "DEPOSITO");
                        break;

                    case 2:
                        System.out.print("Valor saque: ");
                        double saque = sc.nextDouble();
                        contaController.sacar(conta, saque);
                        transacaoController.registrar(conta, saque, "SAQUE");
                        break;

                    case 3:
                        List<Transacao> extrato = transacaoController.exibirExtrato(conta.getNumero());
                        System.out.println("\n=== EXTRATO ===");
                        for (Transacao t : extrato) {
                            System.out.println(t.getTipo() + " - R$" + t.getValor());
                        }
                        break;
                }

            } while (opcao != 0);

            // CARTAO
            Cartao cartao = new Cartao();
            cartao.setNumero("1234 5678 0000 9999");
            cartao.setNomeTitular(cliente.getNome());
            cartao.setValidade("12/30");
            cartao.setCvv("123");
            cartao.setLimite(3000);
            cartao.setTipo("CREDITO");
            cartao.setConta(conta);

            // FATURA
            Fatura fatura = new Fatura(
                "F001",
                350.0,
                "Compra Mercado",
                "10/05/2026",
                cartao
            );

            // PARCELA
            Parcela parcela = new Parcela();
            parcela.setId("P001");
            parcela.setNumeroParcelas(1);
            parcela.setValorParcela(350.0);
            parcela.setDataVencimento("10/05/2026");
            parcela.setPaga(false);
            parcela.setFatura(fatura);

            // EMPRESTIMO
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setId("EMP001");
            emprestimo.setValorTotal(5000);
            emprestimo.setTaxaJuros(0.02);
            emprestimo.setNumeroParcelas(12);
            emprestimo.setDataInicio("01/04/2026");
            emprestimo.setDataFim("01/04/2027");
            emprestimo.setConta(conta);

            // RESUMO FINAL
            System.out.println("\n=== RESUMO FINAL ===");
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Conta: " + conta.getNumero());
            System.out.println("Agência: " + conta.getAgencia().getNumero());
            System.out.println("Saldo final: R$" + conta.getSaldo());
            System.out.println("PIX: " + pix.getValorChave());
            System.out.println("Cartão: " + cartao.getNumero());
            System.out.println("Fatura: R$" + fatura.getValor());
            System.out.println("Empréstimo: R$" + emprestimo.getValorTotal());

        } catch (SaldoInsuficiente e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}