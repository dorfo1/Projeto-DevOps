package fiap.com.br.projetodevops.Model;

public class Servico {

    private String nome;
    private String categoria;
    private double valor;

    public Servico(String descricao, String categoria, double valor) {
        this.nome = descricao;
        this.categoria = categoria;
        this.valor = valor;
    }

    public Servico() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
