package servicos;

import entidades.Pessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroPaciente extends Cadastro<Pessoas> {
    private List<Pessoas> pacientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
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

    public boolean remover(String cpf) {
        Pessoas paciente = buscarPorCPF(cpf);
        return pacientes.remove(paciente);
    }
    
    public boolean atualizarEntidade(String cpf, Pessoas novosDados) {
        Pessoas pacienteExistente = buscarPorCPF(cpf);
        if (pacienteExistente != null) {
            // Atualiza apenas campos permitidos (ex: nome e data de nascimento)
            pacienteExistente.setNome(novosDados.getNome());
            pacienteExistente.setDataNascimento(novosDados.getDataNascimento());
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
        	System.out.print("Data Nascimento (AAAA-MM-DD): ");
            LocalDate dataNasc = LocalDate.parse(scanner.nextLine());
             
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
            System.out.println(p.getNome() + " - CPF: " + p.getCPF())
        );
    }
    
    public void atualizar() {
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        
        Pessoas paciente = buscarPorCPF(cpf);
        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        
        System.out.print("Nova data de nascimento (AAAA-MM-DD): ");
        LocalDate novaDataNasc = LocalDate.parse(scanner.nextLine());

        Pessoas novosDados = new Pessoas(novoNome, cpf, novaDataNasc); // CPF não muda
        boolean sucesso = atualizarEntidade(cpf, novosDados);
        
        System.out.println(sucesso ? "Paciente atualizado!" : "Falha na atualização!");
    }
}