package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prescricao {
    private String id;
    private Consulta consultaAssociada;
    private List<Exames> examesPrescritos;
    private List<Medicamento> medicamentos;
    private LocalDate dataValidade;

    public Prescricao(Consulta consulta, LocalDate dataValidade) {
        this.consultaAssociada = consulta;
        this.dataValidade = dataValidade;
        this.examesPrescritos = new ArrayList<>();
        this.medicamentos = new ArrayList<>();
    }

    // Getters e Setters
    public String getId() { return id; }
    public Consulta getConsultaAssociada() { return consultaAssociada; }
    public List<Exames> getExamesPrescritos() { return examesPrescritos; }
    public List<Medicamento> getMedicamentos() { return medicamentos; }
    public LocalDate getDataValidade() { return dataValidade; }
    
    public void adicionarExame(Exames exame) {
        examesPrescritos.add(exame);
    }
    
    public void adicionarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }
}