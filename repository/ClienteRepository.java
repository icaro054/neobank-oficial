package repository;
import entity.Cliente;
import java.util.ArrayList;
import java.util.List;
public class ClienteRepository extends GenericRepository<Cliente> {
    
    private List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

}
