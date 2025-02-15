package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Pessoas {
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private List<Consulta> consultas = new ArrayList<>();
	public Pessoas (String nome, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.consultas = new ArrayList<>();
	}
	
    // Getters e Setters
	
	public String getNome() {
		return nome;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
    public List<Consulta> getConsultas() { 
    	return consultas; 
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
	
    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }
}
