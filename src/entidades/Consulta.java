package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private static int contadorId = 1;
    private final String id;
    private LocalDate data;
    private LocalTime horarioInicio;
    private int duracao;
    private String status; // AGENDADA, CANCELADA, REALIZADA
    private Medico medico;
    private Pessoas paciente;
    private String especialidadeRequerida;
    private List<Pagamento> pagamentos;
    private double valor;
    
    public Consulta(LocalDate data, LocalTime horarioInicio, int duracao, 
                   Medico medico, Pessoas paciente, double valor, String especialidadeRequerida) {
        this.id = "CONS-" + contadorId++;
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.duracao = duracao;
        this.status = "AGENDADA";
        this.medico = medico;
        this.paciente = paciente;
        this.pagamentos = new ArrayList<>();
        this.valor = valor;
        this.especialidadeRequerida = especialidadeRequerida;
    }

    public String getId() {
        return id;
    }

    public LocalTime getHorarioTermino() {
        return horarioInicio.plusMinutes(duracao);
    }

    public void cancelar() {
        this.status = "CANCELADA";
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
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
    
    public double getValor() { 
        return valor; 
    }
    
    public void setValor(double valor) { 
        this.valor = valor; 
    }
    
    public double getTotalPago() {
        return pagamentos.stream()
            .filter(p -> p.getStatus().equals("PAGO"))
            .mapToDouble(Pagamento::getValor)
            .sum();
    }

    public String getEspecialidadeRequerida() {
        return especialidadeRequerida;
    }

    public void adicionarPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
    }
}