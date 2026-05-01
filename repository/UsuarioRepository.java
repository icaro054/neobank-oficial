package repository;

import entity.Usuario;

public class UsuarioRepository extends GenericRepository<Usuario> {

    // Adicione este método aqui dentro!
    public Usuario buscarPorLoginESenha(String loginDigitado, String senhaDigitada) {
        
        for (Usuario u : dados) {
            if (u.getLogin().equals(loginDigitado) && u.getSenha().equals(senhaDigitada)) {
                return u; // Achou a combinação perfeita!
            }
        }
        
        return null; // Não achou ninguém com esse login e senha
    }
}