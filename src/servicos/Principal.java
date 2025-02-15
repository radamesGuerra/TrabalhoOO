package servicos;

import entidades.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
    private static Scanner scanner = new Scanner(System.in);
    private static Cadastro<Pessoas> cadastroPaciente = new CadastroPaciente();
    private static Cadastro<Medico> cadastroMedico = new CadastroMedico();
    private static CadastroExames cadastroExame = new CadastroExames();
    private static CadastroMedicamento cadastroMedicamento = new CadastroMedicamento();
    private static ServicoPagamento pagamentoService = new ServicoPagamento();

    public static void main(String[] args) {
        int opcaoPrincipal;
        do {
            exibirMenuPrincipal();
            opcaoPrincipal = lerInteiro("");
            
            switch (opcaoPrincipal) {
                case 1 -> gerenciarPacientes();
                case 2 -> gerenciarMedicos();
                case 3 -> gerenciarConsultas();
                case 4 -> gerenciarExamesMedicamentos();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcaoPrincipal != 0);
    }
    private static void exibirMenuPrincipal() {
        System.out.println("\n=*= Sistema Clínica Médica =*=");
        System.out.println("1. Pacientes");
        System.out.println("2. Médicos");
        System.out.println("3. Consultas");
        System.out.println("4. Exames/Medicamentos");
        System.out.println("0. Sair");
    }

    // ========== SUBMENU PACIENTES ==========
    private static void gerenciarPacientes() {
        int opcao;
        do {
            System.out.println("\n-= Gerenciamento de Pacientes =-");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Atualizar Paciente");
            System.out.println("4. Remover Paciente");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1 -> cadastroPaciente.cadastrar();
                case 2 -> cadastroPaciente.listar();
                case 3 -> cadastroPaciente.atualizar();
                case 4 -> cadastroPaciente.remover();
            }
        } while (opcao != 0);
    }
    
    // ========== SUBMENU MÉDICOS ==========
    private static void gerenciarMedicos() {
        int opcao;
        do {
            System.out.println("\n-= Gerenciamento de Médicos =-");
            System.out.println("1. Cadastrar Médico");
            System.out.println("2. Listar Médicos");
            System.out.println("3. Atualizar Médico");
            System.out.println("4. Remover Médico");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1 -> cadastroMedico.cadastrar();
                case 2 -> cadastroMedico.listar();
                case 3 -> cadastroMedico.atualizar();
                case 4 -> cadastroMedico.remover();
            }
        } while (opcao != 0);
    }

    // ========== SUBMENU CONSULTAS ==========
    private static void gerenciarConsultas() {
        int opcao;
        do {
            System.out.println("\n-= Gerenciamento de Consultas =-");
            System.out.println("1. Agendar Consulta");
            System.out.println("2. Desagendar Consulta");
            System.out.println("3. Listar Consultas");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1 -> Agendamento.agendarConsultaPrompt(cadastroPaciente, cadastroMedico);
                case 2 -> Agendamento.desagendarConsultaPrompt(cadastroPaciente, cadastroMedico);
                case 3 -> Agendamento.listarConsultas(cadastroMedico);
            }
        } while (opcao != 0);
    }

    // ========== SUBMENU EXAMES/MEDICAMENTOS ==========
    private static void gerenciarExamesMedicamentos() {
        int opcao;
        do {
            System.out.println("\n-= Gerenciamento de Exames/Medicamentos =-");
            System.out.println("1. Cadastrar Exame");
            System.out.println("2. Cadastrar Medicamento");
            System.out.println("3. Listar Exames");
            System.out.println("4. Listar Medicamentos");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1 -> cadastroExame.cadastrarExame();
                //case 2 -> cadastrarMedicamento();
                //case 3 -> listarExames();
                //case 4 -> listarMedicamentos();
            }
        } while (opcao != 0);
    }
    
 // ========== MÉTODOS AUXILIARES ==========
    public static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        return Double.parseDouble(scanner.nextLine());
    }
    
    public static LocalDate lerData(String mensagem) {
        System.out.print(mensagem);
        return LocalDate.parse(scanner.nextLine());
    }

}
