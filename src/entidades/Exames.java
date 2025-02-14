package entidades;

import java.time.LocalDate;

public class Exames {
    private String tipo;
    private LocalDate dataPrescricao;
    private LocalDate dataRealizacao;
    private String resultado;
    private String especialidade;
    private double custo;

    public Exames(String tipo, LocalDate dataPrescricao, double custo, String especialidade) {
    	this.tipo = tipo;
        this.dataPrescricao = dataPrescricao;
        this.custo = custo;
        this.resultado = "PENDENTE";
        this.especialidade = especialidade;
    }

    public void registrarResultado(String resultado, LocalDate dataRealizacao) {
    	this.resultado = resultado;
        this.dataRealizacao = dataRealizacao;
    }
    
    // Getters e Setters

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		
	}

	public LocalDate getDataPrescricao() {
		return dataPrescricao;
	}

	public LocalDate getDataRealizacao() {
		return dataRealizacao;
	}

	public String getResultado() {
		return resultado;
	}
	
	public double getCusto() {
		return custo;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
}
