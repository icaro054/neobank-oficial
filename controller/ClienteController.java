package controller;

import entity.Cliente;
import service.ClienteService;

public class ClienteController {
    private ClienteService service = new ClienteService();

    public Cliente registrar(String nome, String cpf) {
        return service.criarCliente(nome, cpf);
    }
}