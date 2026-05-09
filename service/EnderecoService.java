package service;
import entity.Endereco;
import repository.EnderecoRepository;
public class EnderecoService {
    private EnderecoRepository repository = new EnderecoRepository();
    public void criarEndereco(Endereco novoEndereco) {
        if (novoEndereco.getCep() == null || novoEndereco.getCep().length() !=8) {
            throw new IllegalArgumentException("Endereço inválido: O CEP é obrigatório.");
        }
        if (novoEndereco.getRua() == null || novoEndereco.getRua().trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço inválido: A rua é obrigatória.");
        }
        if (novoEndereco.getNumero() == null || novoEndereco.getNumero().trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço inválido: O numero é obrigatório.");
        }
        if (novoEndereco.getCidade() == null || novoEndereco.getCidade().trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço inválido: A cidade é obrigatória.");
        }
        if (novoEndereco.getBairro() == null || novoEndereco.getBairro().trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço inválido: O bairro é obrigatório.");
        }
        if (novoEndereco.getEstado() == null || novoEndereco.getEstado().trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço inválido: O estado é obrigatório.");
        }
        repository.salvar(novoEndereco);
    }
}
