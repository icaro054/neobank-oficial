/* 
package service;
import repository.UsuarioRepository;
import entity.Usuario;
public class UsuarioService {
        
    private UsuarioRepository usuarioRepository = new UsuarioRepository();
        public void cadastrarUsuario(Usuario novoUsuario) {
        if (novoUsuario.getLogin() == null || novoUsuario.getLogin().trim().isEmpty()) {
            throw new IllegalArgumentException("Login é obrigatório.");
        }
        if (novoUsuario.getSenha() == null || novoUsuario.getSenha().trim().length() < 4) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 4 caracteres.");
        }
        usuarioRepository.salvar(novoUsuario);

    public Usuario fazerLogin(String login, String senha) {
        // Pede para o repositório procurar
        Usuario usuarioEncontrado = usuarioRepository.buscarPorLoginESenha(login, senha);
        
        // O Service avalia o resultado e decide o que fazer
        if (usuarioEncontrado == null) {
            throw new IllegalArgumentException("❌ Acesso negado: Login ou senha incorretos!");
        }
        
        return usuarioEncontrado; // Sucesso!
    }
}
    
    
*/