package classes;

public class Produto {

    private int id;
    private String nome;
    private String status;
    private double valor;

    public Produto() {
    }

    public Produto(int id, String nome, String status, double valor) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
