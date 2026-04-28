package entity;

public class Fatura {
    private String id;
    private double valor;
    private String descricao;
    private String dataVencimento;
    private boolean paga;
    private Cartao cartao;

    public String getId() {
        return id;
    }
    public double getValor() {
        return valor;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getDataVencimento() {
        return dataVencimento;
    }
    public boolean isPaga() {
        return paga;
    }
    public Cartao getCartao() {
        return cartao;
    }
    public Fatura(String id, double valor, String descricao, String dataVencimento, Cartao cartao) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.cartao = cartao;
        this.paga = false;
    }
}
