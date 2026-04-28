package controller;
import entity.Transacao;
import repository.TransacaoRepository;
import java.util.List;
public class TransacaoController {
    private TransacaoRepository repository = new TransacaoRepository();
    public List<Transacao> exibirExtrato(String numero) {
        return repository.buscarPorConta(numero);
        
    }
}