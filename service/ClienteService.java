package service;

import entity.Cliente;
import repository.ClienteRepository;

public class ClienteService {
    private ClienteRepository repository = new ClienteRepository();

    public void cadastrarCliente(Cliente novoCliente) {
        if (novoCliente.getNome() == null || novoCliente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Nome do cliente é obrigatório!");
        }
        if (novoCliente.getDocumento() == null || novoCliente.getDocumento().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: CPF ou CNPJ do cliente é obrigatório!");
        }
        Cliente clienteExistente = repository.buscarPorDocumento(novoCliente.getDocumento());
        if (clienteExistente != null) {
            throw new IllegalArgumentException("Erro: Cliente com este CPF ou CNPJ já está cadastrado!");
        }
        repository.salvar(novoCliente);
    }
    public Cliente buscarClientePorDocumento(String documento) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: CPF ou CNPJ é obrigatório para busca!");
        }
        Cliente clienteEncontrado = repository.buscarPorDocumento(documento);
        if (clienteEncontrado == null) {
            throw new IllegalArgumentException("Nenhum cliente encontrado com esse CPF ou CNPJ: " + documento);
        }
        return clienteEncontrado;
    }
}