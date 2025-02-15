package entidades;

import java.time.LocalDate;

public class Exames {
    private String id;
    private String tipo;
    private LocalDate dataPrescricao;
    private LocalDate dataRealizacao;
    private String resultado;
    private double custo;

    public Exames(String tipo, LocalDate dataPrescricao, double custo) {
        this.tipo = tipo;
        this.dataPrescricao = dataPrescricao;
        this.custo = custo;
        this.resultado = "Pendente";
    }

    // Getters e Setters
    public String getId() { 
    	return id; 
    }
    
    public String getTipo() { 
    	return tipo; 
    }
    
    public void setTipo(String tipo) { 
    	this.tipo = tipo; 
    }
    
    public LocalDate getDataPrescricao() { 
    	return dataPrescricao; 
    }
    
    public void setDataPrescricao(LocalDate dataPrescricao) { 
    	this.dataPrescricao = dataPrescricao; 
    }
    
    public LocalDate getDataRealizacao() { 
    	return dataRealizacao; 
    }
    
    public void setDataRealizacao(LocalDate dataRealizacao) { 
    	this.dataRealizacao = dataRealizacao; 
    }
    
    public String getResultado() { 
    	return resultado; 
    }
    
    public void setResultado(String resultado) { 
    	this.resultado = resultado; 
    }
    
    public double getCusto() { 
    	return custo; 
    }
    
    public void setCusto(double custo) { 
    	this.custo = custo; 
    }
}