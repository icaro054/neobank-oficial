package controller;

import entity.Cliente;
import service.ClienteService;

public class ClienteController {
    private ClienteService service = new ClienteService();

    // recebe os dados da tela
    public Cliente registrar(String nome, String documento, String tipoCliente) {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(nome);
        novoCliente.setDocumento(documento);
        novoCliente.setTipoCliente(tipoCliente);
        
        service.cadastrarCliente(novoCliente);
        return novoCliente; // Adicione este retorno!
    }

    
    public Cliente buscarCliente(String documento) {
        return service.buscarClientePorDocumento(documento);
    }
}