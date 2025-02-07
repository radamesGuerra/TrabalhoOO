package entidades;

import java.time.LocalDate;

public class Exame {
    private String tipo;
    private LocalDate dataPrescricao;
    private LocalDate dataRealizacao;
    private String resultado;
    private double custo;

    public Exame(String tipo, LocalDate dataPrescricao, double custo) {
        this.tipo = tipo;
        this.dataPrescricao = dataPrescricao;
        this.custo = custo;
        this.resultado = "PENDENTE";
    }

    public void registrarResultado(String resultado, LocalDate dataRealizacao) {
        this.resultado = resultado;
        this.dataRealizacao = dataRealizacao;
    }

}
