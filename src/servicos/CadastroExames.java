package servicos;

import entidades.Exames;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CadastroExames {
    private List<Exames> exames = new ArrayList<>();

    public void cadastrar(Exames exame) {
        exames.add(exame);
    }

    public List<Exames> listar() {
        return new ArrayList<>(exames);
    }

    public Optional<Exames> buscarPorId(String id) {
        return exames.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public boolean atualizar(String id, Exames novosDados) {
        Optional<Exames> exameExistente = buscarPorId(id);
        if (exameExistente.isPresent()) {
            Exames exame = exameExistente.get();
            exame.setTipo(novosDados.getTipo());
            exame.setDataPrescricao(novosDados.getDataPrescricao());
            exame.setCusto(novosDados.getCusto());
            return true;
        }
        return false;
    }

    public boolean remover(String id) {
        return exames.removeIf(e -> e.getId().equals(id));
    }
    
}