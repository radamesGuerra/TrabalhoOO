package servicos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Consulta {
		
	//atribitos da classe Consulta
	private LocalDate dataConsulta;
	private LocalTime horarioConsulta;
	private int duracaoMinutos;
	private String status;
	private Paciente paciente;
	private Medico medico;
	private List<Exame> examesPrescritos;
	private List<Medicamento> medicamentosPrescritos;
	private double valorConsulta;
	
	//Método construtor da classe Consulta
	//Não passei os atributos List<Exame> e List<Medicamento> porque inicializei como uma lista vazia
	public Consulta(LocalDate dataConsulta, LocalTime horarioConsulta, int duracaoMinutos, Paciente paciente, Medico medico, double valorConsulta) {
		
		this.dataConsulta = dataConsulta;
		this.horarioConsulta = horarioConsulta;
		this.duracaoMinutos = duracaoMinutos;
		this.status = "AGENDADA";
		this.paciente = paciente;
		this.medico = medico;
		this.examesPrescritos = examesPrescritos;
		this.medicamentosPrescritos = medicamentosPrescritos;
		this.valorConsulta = valorConsulta;
		
	}
	
	//Métodos Getters
	public LocalDate getdataConsulta() {
		return dataConsulta;
	}	
	public LocalTime gethorarioConsulta() {
		return horarioConsulta;
	}	
	public int getduracaoMinutos() {
		return duracaoMinutos;
	}	
	public String getstatus() {
		return status;
	}	
	public double getvalorConsulta() {
		return valorConsulta;
	}
	
	//Métodos Setters
	public void setdataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}	
	public void sethorarioConsulta(LocalTime horarioConsulta) {
		this.horarioConsulta = horarioConsulta;		
	}	
	public void setduracaoMinutos(int duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}	
	public void setstatus(String status) {
		this.status = status;
	}	
	public void setvalorConsulta(float valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	
	//implementar metodo que verifica disponibilidade do medico
	
	//implementar metodo que verifica se a especialidade do medico eh compativel
	
	//implementar metodo que verifica se existe conflito de paciente
	
	//implementar CRUD completo para consultas
}
