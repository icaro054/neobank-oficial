package repository;

import entity.Transacao;
import java.util.ArrayList;
import java.util.List;
public class TransacaoRepository extends GenericRepository<Transacao> {
    private List<Transacao> transacoes = new ArrayList<>();

    public void salvar(Transacao transacao) {
        transacoes.add(transacao);
    }

    public List<Transacao> buscarPorConta(String numeroConta) {
        List<Transacao> extrato = new ArrayList<>();
        for (Transacao t : transacoes) {
            if (t.getConta().getNumero().equals(numeroConta)) {
                extrato.add(t);
            }
        }
        return extrato;
    }
}