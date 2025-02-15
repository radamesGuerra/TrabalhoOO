package servicos;

import entidades.Medico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroMedico extends Cadastro<Medico> {
    private List<Medico> medicos = new ArrayList<>();
    
    public void cadastrarEntidade(Medico medico) {
        if (buscarPorCPF(medico.getCPF()) == null) {
            medicos.add(medico);
        }
    }

    public List<Medico> listarEntidade() {
        return new ArrayList<>(medicos);
    }

    public Medico buscarPorCPF(String cpf) {
        return medicos.stream()
                .filter(m -> m.getCPF().equals(cpf))
                .findFirst()
                .orElse(null);
    }
    
    public boolean removerEntidade(String cpf) {
        Medico medico = buscarPorCPF(cpf);
        return medicos.remove(medico);
    }
    
    public boolean atualizarEntidade(String cpf, Medico novosDados) {
        Medico medicoExistente = buscarPorCPF(cpf);
        if (medicoExistente != null) {
            // atualiza campos permitidos (ex: nome, CRM e especialidade)
            medicoExistente.setNome(novosDados.getNome());
            medicoExistente.setCRM(novosDados.getCRM());
            medicoExistente.setEspecialidade(novosDados.getEspecialidade());
            return true;
        }
        return false;
    }
    
    public void cadastrar() {
        String nome = Principal.lerString("Nome: ");
        
        String cpf = Principal.lerString("CPF: ");
        
        if (buscarPorCPF(cpf) == null) {
            String crm = Principal.lerString("CRM: ");
            
            String especialidade = Principal.lerString("Especialidade: ");

            LocalDate dataNasc = Principal.lerData("Data Nascimento (AAAA-MM-DD): ");
            
            Medico medico = new Medico(nome, cpf, dataNasc, crm, especialidade);
            cadastrarEntidade(medico);
            System.out.println("Médico cadastrado!");
        }
        
        else {
        	System.out.println("CPF já cadastrado!");
        }
    }
    
    public void listar() {
        System.out.println("\n=== Médicos Cadastrados ===");
        listarEntidade().forEach(m -> 
        	System.out.println("CRM: " + m.getCRM() + " | Nome: " + m.getNome() + " | Especialidade: " + m.getEspecialidade())
        );
    }
    
    public void remover() {
        String cpf = Principal.lerString("CPF do médico: ");
        boolean removido = removerEntidade(cpf);
        
        System.out.println(removido ? "Médico removido!" : "Médico não encontrado!");
    }
    
    public void atualizar() {
        String cpf = Principal.lerString("Digite o CPF do médico: ");
        
        Medico medico = buscarPorCPF(cpf);
        if (medico == null) {
            System.out.println("Médico não encontrado!");
            return;
        }

        String novoNome = Principal.lerString("Novo nome: ");
        
        String novoCRM = Principal.lerString("Novo CRM: ");
        
        String novaEspecialidade = Principal.lerString("Nova especialidade: ");

        Medico novosDados = new Medico(novoNome, cpf, medico.getDataNascimento(), novoCRM, novaEspecialidade);
        boolean sucesso = atualizarEntidade(cpf, novosDados);
        
        System.out.println(sucesso ? "Médico atualizado!" : "Falha na atualização!");
    }
}