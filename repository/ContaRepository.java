package repository;

import entity.Conta;
import java.util.ArrayList;
import java.util.List;

public class ContaRepository {
    
    // 1. Aqui criamos a lista na memória. O nome dela oficial agora é "contas"
    private List<Conta> contas = new ArrayList<>();

    // Método para salvar uma nova conta na lista
    public void salvar(Conta conta) {
        contas.add(conta);
    }

    // Método antigo que já tínhamos para buscar pelo número da conta (Ex: 1001-X)
    public Conta buscarPorNumero(String numero) {
        for (Conta c : contas) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    // 2. O NOVO MÉTODO que o VS Code estava pedindo! 
    // Agora ele usa a variável "contas" que declaramos ali em cima.
    public Conta buscarPorDocumentoDoCliente(String documento) {
        for (Conta c : contas) {
            
            if (c.getCliente().getDocumento().equals(documento)) {
                return c; 
            }
        }
        return null; 
    }
}