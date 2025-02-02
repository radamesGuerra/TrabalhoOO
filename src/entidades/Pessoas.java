package entidades;

import java.time.LocalDate;

public class Pessoas {
	protected String nome;
	protected String cpf;
	protected LocalDate dataNascimento;
	
	public Pessoas (String nome, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	public String getCPF() {
		return cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
