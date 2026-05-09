package repository;

import entity.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    // Lista na memória simulando o banco de dados
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public void salvar(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public Usuario buscarPorLogin(String login) {
        for (Usuario u : listaUsuarios) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null; // Se não achar o login, retorna vazio
    }
}