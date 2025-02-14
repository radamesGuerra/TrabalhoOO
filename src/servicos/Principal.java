package servicos;

import entidades.Medico;
import entidades.Pessoas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Principal {
    private static Cadastro<Pessoas> cadastroPaciente = new CadastroPaciente();
    private static Cadastro<Medico> cadastroMedico = new CadastroMedico();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=*= Sistema Cadastro =*=");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Médico");
            System.out.println("3. Listar Pacientes");
            System.out.println("4. Listar Médicos");
            System.out.println("5. Atualizar Cadastro de Paciente");
            System.out.println("6. Atualizar Cadastro de Médico");
            System.out.println("7. Agendar Consulta");
            System.out.println("8. Desagendar Consulta");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer
            
            switch (opcao) {
                case 1 -> cadastroPaciente.cadastrar();
                case 2 -> cadastroMedico.cadastrar();
                case 3 -> cadastroPaciente.listar();
                case 4 -> cadastroMedico.listar();
                case 5 -> cadastroPaciente.atualizar();
                case 6 -> cadastroMedico.atualizar();
                case 7 -> Agendamento.agendarConsultaPrompt(cadastroPaciente, cadastroMedico);
                case 8 -> Agendamento.desagendarConsultaPrompt(cadastroPaciente, cadastroMedico);
            }
        } while (opcao != 0);
    }
    
}