package repository;
// apenas importações
import entity.EntidadeBase;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericRepository <T extends EntidadeBase> {
    // Geric = pode ser usado para qualquer tipo de entidade
    protected List<T> dados = new ArrayList<>();

    public void salvar(T entidade) {
        dados.add(entidade);
    }
    // busca universal para qualquer tipo de entidade
    public T buscarPor(String id) {
        for (T item : dados) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}
