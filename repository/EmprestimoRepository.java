package repository;

import entity.Emprestimo;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepository extends GenericRepository<Emprestimo> {
    
    // listar todos os empréstimos de um cliente específico
    public List<Emprestimo> buscarPorCpfCliente(String cpf) {
        List<Emprestimo> emprestimosDoCliente = new ArrayList<>();
        
        for (Emprestimo e : dados) {
            // Supondo que seu Emprestimo tenha o Cliente associado
            if (e.getCliente().getCpf().equals(cpf)) {
                emprestimosDoCliente.add(e);
            }
        }
        
        return emprestimosDoCliente;
    }
}