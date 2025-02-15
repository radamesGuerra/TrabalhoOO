package entidades;

public class Medicamento {
    private String id;
    private String nome;
    private String dosagem;
    private String instrucoes;

    public Medicamento(String nome, String dosagem, String instrucoes) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.instrucoes = instrucoes;
    }

    // Getters e Setters
    public String getId() { 
    	return id; 
    }
    
    public String getNome() { 
    	return nome; 
    }
    
    public void setNome(String nome) { 
    	this.nome = nome; 
    }
    
    public String getDosagem() { 
    	return dosagem; 
    }
    
    public void setDosagem(String dosagem) { 
    	this.dosagem = dosagem; 
    }
    
    public String getInstrucoes() { 
    	return instrucoes; 
    }
    
    public void setInstrucoes(String instrucoes) { 
    	this.instrucoes = instrucoes; 
    }
}