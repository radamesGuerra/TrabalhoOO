package servicos;

import entidades.Prescricao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CadastroPrescricao {
    private List<Prescricao> prescricoes = new ArrayList<>();

    public void cadastrar(Prescricao prescricao) {
        prescricoes.add(prescricao);
    }

    public List<Prescricao> listar() {
        return new ArrayList<>(prescricoes);
    }

    public Optional<Prescricao> buscarPorId(String id) {
        return prescricoes.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public boolean atualizar(String id, Prescricao novosDados) {
        Optional<Prescricao> prescricaoExistente = buscarPorId(id);
        if (prescricaoExistente.isPresent()) {
            Prescricao prescricao = prescricaoExistente.get();
            // Atualizar campos necessários
            return true;
        }
        return false;
    }

    public boolean remover(String id) {
        return prescricoes.removeIf(p -> p.getId().equals(id));
    }

}