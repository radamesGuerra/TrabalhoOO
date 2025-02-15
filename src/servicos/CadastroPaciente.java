package servicos;

import entidades.Pessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroPaciente extends Cadastro<Pessoas> {
    private List<Pessoas> pacientes = new ArrayList<>();
    
    public void cadastrarEntidade(Pessoas paciente) {
        if (buscarPorCPF(paciente.getCPF()) == null) {
            pacientes.add(paciente);
        }
    }

    public List<Pessoas> listarEntidade() {
        return new ArrayList<>(pacientes);
    }

    public Pessoas buscarPorCPF(String cpf) {
        return pacientes.stream()
                .filter(p -> p.getCPF().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public boolean removerEntidade(String cpf) {
        Pessoas paciente = buscarPorCPF(cpf);
        return pacientes.remove(paciente);
    }
    
    public boolean atualizarEntidade(String cpf, Pessoas novosDados) {
        Pessoas pacienteExistente = buscarPorCPF(cpf);
        if (pacienteExistente != null) {
            // atualiza apenas campos permitidos (ex: nome e data de nascimento)
            pacienteExistente.setNome(novosDados.getNome());
            pacienteExistente.setDataNascimento(novosDados.getDataNascimento());
            return true;
        }
        return false;
    }

    public void cadastrar() {
        String nome = Principal.lerString("Nome: ");
        
        String cpf = Principal.lerString("CPF: ");
        
        if (buscarPorCPF(cpf) == null) {
            LocalDate dataNasc = Principal.lerData("Data Nascimento (AAAA-MM-DD): ");
             
            Pessoas paciente = new Pessoas(nome, cpf, dataNasc);
            cadastrarEntidade(paciente);
            
        	System.out.println("Paciente cadastrado!");
        }
        
        else {
        	System.out.println("CPF já cadastrado!");
        }
        
    }
    
    public void listar() {
        System.out.println("\n=== Pacientes Cadastrados ===");
        listarEntidade().forEach(p -> 
        	System.out.println("CPF: " + p.getCPF() + " | Nome: " + p.getNome())
        );
    }
    
    public void remover() {
        String cpf = Principal.lerString("CPF do paciente: ");
        boolean removido = removerEntidade(cpf);
        
        System.out.println(removido ? "Paciente removido!" : "Paciente não encontrado!");
    }

    
    public void atualizar() {
        String cpf = Principal.lerString("Digite o CPF do paciente: ");
        
        Pessoas paciente = buscarPorCPF(cpf);
        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        String novoNome = Principal.lerString("Novo nome: ");
        
        LocalDate novaDataNasc = Principal.lerData("Nova data de nascimento (AAAA-MM-DD): ");

        Pessoas novosDados = new Pessoas(novoNome, cpf, novaDataNasc); // CPF não muda
        boolean sucesso = atualizarEntidade(cpf, novosDados);
        
        System.out.println(sucesso ? "Paciente atualizado!" : "Falha na atualização!");
    }
}