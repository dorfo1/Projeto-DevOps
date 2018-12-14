package fiap.com.br.projetodevops.Model;

public class Servico {

    private String descricao;
    private String prestador;
    private double valor;

    public Servico(String descricao, String prestador, double valor) {
        this.descricao = descricao;
        this.prestador = prestador;
        this.valor = valor;
    }
}
