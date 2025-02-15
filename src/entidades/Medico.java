package entidades;

import java.time.LocalDate;

public class Medico extends Pessoas{

	private String crm;
	private String especialidade;
	
	public Medico(String nome, String cpf, LocalDate dataNascimento, String crm, String especialidade) {
		super(nome, cpf, dataNascimento);
		this.crm = crm;
		this.especialidade = especialidade;
	}

    // Getters e Setters
	public String getCRM() {
		return crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setCRM(String crm) {
		this.crm = crm;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
