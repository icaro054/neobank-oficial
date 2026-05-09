package repository;
import entity.Cartao;
import java.util.ArrayList;
import java.util.List;
public class CartaoRepository extends GenericRepository<Cartao> {
    // listar todos os cartões de um cliente específico
    public List<Cartao> buscarPorTipoCliente(String documento) {
        List<Cartao> cartoesDoCliente = new ArrayList<>();
        
        for (Cartao c : dados) {
            // Supondo que seu Cartão tenha o Cliente associado
            if (c.getCliente().getTipoCliente().equals(documento)) {
                cartoesDoCliente.add(c);
            }
        }
        
        return cartoesDoCliente;
    }
    
}
