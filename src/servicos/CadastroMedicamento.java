package servicos;

import entidades.Medicamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CadastroMedicamento {
    private List<Medicamento> medicamentos = new ArrayList<>();

    public void cadastrar(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public List<Medicamento> listar() {
        return new ArrayList<>(medicamentos);
    }

    public Optional<Medicamento> buscarPorId(String id) {
        return medicamentos.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }

    public boolean atualizar(String id, Medicamento novosDados) {
        Optional<Medicamento> medicamentoExistente = buscarPorId(id);
        if (medicamentoExistente.isPresent()) {
            Medicamento medicamento = medicamentoExistente.get();
            medicamento.setNome(novosDados.getNome());
            medicamento.setDosagem(novosDados.getDosagem());
            medicamento.setInstrucoes(novosDados.getInstrucoes());
            return true;
        }
        return false;
    }

    public boolean remover(String id) {
        return medicamentos.removeIf(m -> m.getId().equals(id));
    }
}