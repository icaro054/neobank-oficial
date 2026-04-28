package service;
import entity.Cliente;
import repository.ClienteRepository;

public class ClienteService {
    private ClienteRepository repository = new ClienteRepository();

    public Cliente criarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        
        repository.salvar(cliente);
        return cliente;
    }
}