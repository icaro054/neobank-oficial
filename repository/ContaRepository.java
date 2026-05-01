package repository;
import entity.Conta;
import java.util.ArrayList;
import java.util.List;
public class ContaRepository extends GenericRepository<Conta> {
    private List<Conta> contas = new ArrayList<>();

    public void salvar(Conta conta) {
        contas.add(conta);
    }
}
