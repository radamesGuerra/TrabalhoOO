package servicos;
import entidades.Medico;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroMedico extends Cadastro {
    private List<Medico> medicos = new ArrayList<>();

    public void cadastrarMedico(Medico medico) {
        medicos.add(medico);
    }

    public List<Medico> listarMedicos() {
        return medicos;
    }

    public Medico buscarMedicoPorCrm(String crm) {
        return medicos.stream()
                .filter(m -> m.getCRM().equals(crm))
                .findFirst()
                .orElse(null);
    }
}
