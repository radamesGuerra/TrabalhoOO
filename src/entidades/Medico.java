package entidades;

import java.time.LocalDate;

public class Medico extends Pessoas{

	protected String crm;
	protected String especialidade;
	
	public Medico(String nome, String cpf, LocalDate dataNascimento, String crm, String especialidade) {
		super(nome, cpf, dataNascimento);
		this.crm = crm;
		this.especialidade = especialidade;
	}
	
	public String getCRM() {
		return crm;
	}
	public String getEspecialidade() {
		return cpf;
	}
	public void setCRM(String crm) {
		this.crm = crm;
	}
	public void setCPF(String especialidade) {
		this.especialidade = especialidade;
	}

}
