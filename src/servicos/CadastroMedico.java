package servicos;

import entidades.Medico;
import entidades.Pessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroMedico extends Cadastro<Medico> {
    private List<Medico> medicos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
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

    public boolean remover(String cpf) {
        Medico medico = buscarPorCPF(cpf);
        return medicos.remove(medico);
    }
    
    public boolean atualizarEntidade(String cpf, Medico novosDados) {
        Medico medicoExistente = buscarPorCPF(cpf);
        if (medicoExistente != null) {
            // Atualiza campos permitidos (ex: nome, CRM e especialidade)
            medicoExistente.setNome(novosDados.getNome());
            medicoExistente.setCRM(novosDados.getCRM());
            medicoExistente.setEspecialidade(novosDados.getEspecialidade());
            return true;
        }
        return false;
    }
    
    public void cadastrar() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        if (buscarPorCPF(cpf) == null) {
            System.out.print("CRM: ");
            String crm = scanner.nextLine();
            
            System.out.print("Especialidade: ");
            String especialidade = scanner.nextLine();
            
            System.out.print("Data Nascimento (AAAA-MM-DD): ");
            LocalDate dataNasc = LocalDate.parse(scanner.nextLine());
            
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
            System.out.println(m.getNome() + " - CPF: " + m.getCPF())
        );
    }
    
    public void atualizar() {
        System.out.print("Digite o CPF do médico: ");
        String cpf = scanner.nextLine();
        
        Medico medico = buscarPorCPF(cpf);
        if (medico == null) {
            System.out.println("Médico não encontrado!");
            return;
        }

        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        
        System.out.print("Novo CRM: ");
        String novoCRM = scanner.nextLine();
        
        System.out.print("Nova especialidade: ");
        String novaEspecialidade = scanner.nextLine();

        Medico novosDados = new Medico(novoNome, cpf, medico.getDataNascimento(), novoCRM, novaEspecialidade);
        boolean sucesso = atualizarEntidade(cpf, novosDados);
        
        System.out.println(sucesso ? "Médico atualizado!" : "Falha na atualização!");
    }
}