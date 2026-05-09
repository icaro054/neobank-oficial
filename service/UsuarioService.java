package service;

import entity.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository repository = new UsuarioRepository();

    public void criarUsuario(Usuario novoUsuario) {
        if (novoUsuario.getLogin() == null || novoUsuario.getLogin().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Login é obrigatório.");
        }
        if (novoUsuario.getEmail() == null || !novoUsuario.getEmail().contains("@")) {
            throw new IllegalArgumentException("Erro: Email inválido.");
        }
        if (novoUsuario.getSenha() == null || novoUsuario.getSenha().length() < 6) {
            throw new IllegalArgumentException("Erro: A senha deve ter no mínimo 6 caracteres.");
        }
        
        // Verifica se alguém já pegou esse login antes
        Usuario usuarioExistente = repository.buscarPorLogin(novoUsuario.getLogin());
        if (usuarioExistente != null) {
            throw new IllegalArgumentException("Erro: Este login já está em uso.");
        }

        repository.salvar(novoUsuario);
    }

    public Usuario fazerLogin(String login, String senha) {
        Usuario usuarioEncontrado = repository.buscarPorLogin(login);
        
        // Se o login não existir ou a senha estiver diferente da que foi salva
        if (usuarioEncontrado == null || !usuarioEncontrado.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Login ou senha incorretos!");
        }
        
        return usuarioEncontrado;
    }
}