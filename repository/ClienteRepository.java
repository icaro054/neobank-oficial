package repository;

import entity.Cliente;

public class ClienteRepository extends GenericRepository<Cliente> {
    
    public Cliente buscarPorDocumento(String documento) {
        
        for (Cliente c : dados) { 
            if (c.getDocumento().equals(documento)) {
                return c; 
            }
        }
        
        return null; 
    }
}
