package entity;

public class TipoConta extends EntidadeBase {
    private String nome;

    public TipoConta(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}