package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private LocalDate data;
    private LocalTime horarioInicio;
    private int duracao;
    private String status;
    private Medico medico;
    private Pessoas paciente;
    private List<Exames> exames;
    private List<String> medicamentos;
    private double valor;

    public Consulta(LocalDate data, LocalTime horarioInicio, int duracao, String status, Medico medico, Pessoas paciente, double valor) {
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.duracao = duracao;
        this.status = status;
        this.medico = medico;
        this.paciente = paciente;
        this.exames = new ArrayList<>();
        this.medicamentos = new ArrayList<>();
        this.valor = valor;
    }

    public LocalDate getData() { 
    	return data; 
    }
    
    public void setData(LocalDate data) { 
    	this.data = data; 
    }
    
    public LocalTime getHorarioInicio() { 
    	return horarioInicio; 
    }
    
    public void setHorarioInicio(LocalTime horarioInicio) { 
    	this.horarioInicio = horarioInicio; 
    }
    
    public int getDuracao() { 
    	return duracao; 
    }
    
    public void setDuracao(int duracao) { 
    	this.duracao = duracao; 
    }
    
    public String getStatus() { 
    	return status; 
    }
    
    public void setStatus(String status) { 
    	this.status = status; 
    }
    
    public Medico getMedico() { 
    	return medico; 
    }
    
    public void setMedico(Medico medico) { 
    	this.medico = medico; 
    }
    
    public Pessoas getPaciente() { 
    	return paciente; 
    }
    
    public void setPaciente(Pessoas paciente) { 
    	this.paciente = paciente; 
    }
    
    public List<Exames> getExames() { 
    	return exames; 
    }
    
    public List<String> getMedicamentos() { 
    	return medicamentos; 
    }
    
    public double getValor() { 
    	return valor; 
    }
    
    public void setValor(double valor) { 
    	this.valor = valor; 
    }

    public void adicionarExame(Exames exame) {
        this.exames.add(exame);
    }

    public void adicionarMedicamento(String medicamento) {
        this.medicamentos.add(medicamento);
    }
}