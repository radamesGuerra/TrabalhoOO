package entidades;

public class Medicamento {
    private String nome;
    private String dosagem;
    private String instrucoes;

    public Medicamento(String nome, String dosagem, String instrucoes) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.instrucoes = instrucoes;
    }

    // Getters e Setters
    public String getNome() { 
        return nome; 
    }

    public String getDosagem() { 
        return dosagem; 
    }

	public String getInstrucoes() {
		return instrucoes;
	}
}