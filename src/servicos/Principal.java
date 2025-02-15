package servicos;

import entidades.*;
import excecoes.PagamentoPendenteException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    public static Scanner scanner = new Scanner(System.in);
    private static Cadastro<Pessoas> cadastroPaciente = new CadastroPaciente();
    private static Cadastro<Medico> cadastroMedico = new CadastroMedico();
    private static CadastroPrescricao cadastroPrescricao = new CadastroPrescricao();
    private static CadastroExames cadastroExame = new CadastroExames();
    private static CadastroMedicamento cadastroMedicamento = new CadastroMedicamento();
    private static ServicoPagamento servicoPagamento = new ServicoPagamento();

    public static void main(String[] args) {
        int opcaoPrincipal;
        do {
            exibirMenuPrincipal();
            opcaoPrincipal = lerInteiro("Escolha: ");
            
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
            System.out.println("4. Realizar Pagamento");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1 -> Agendamento.agendarConsultaPrompt(cadastroPaciente, cadastroMedico);
                case 2 -> Agendamento.desagendarConsultaPrompt(cadastroPaciente, cadastroMedico);
                case 3 -> Agendamento.listarConsultas(cadastroMedico);
                case 4 -> processarPagamento();
            }
        } while (opcao != 0);
    }
    private static void processarPagamento() {
        String idConsulta = lerString("ID da consulta: ");
        
        Consulta consulta = null;
        for(Medico medico : cadastroMedico.listarEntidade()) {
            consulta = medico.getConsultas().stream()
                .filter(c -> c.getId().equals(idConsulta))
                .findFirst()
                .orElse(null);
            if(consulta != null) break;
        }
        
        if(consulta != null) {
            try {
                System.out.println("Valor total da consulta: R$" + consulta.getValor());
                double valorPagamento = lerDouble("Valor a pagar: R$ ");
                
                servicoPagamento.pagarConsulta(consulta, valorPagamento);
                System.out.println("Pagamento registrado com sucesso!");
                
                if(ServicoPagamento.temPagamentoPendente(consulta)) {
                    System.out.println("Atenção: Pagamento parcial realizado!");
                }
            } catch (PagamentoPendenteException e) {
                System.out.println("Erro no pagamento: " + e.getMessage());
            }
        } else {
            System.out.println("Consulta não encontrada!");
        }
    }

    // ========== SUBMENU EXAMES/MEDICAMENTOS ==========
    private static void gerenciarExamesMedicamentos() {
        int opcao;
        do {
            System.out.println("\n-= Gerenciamento de Exames/Medicamentos/Prescrições =-");
            System.out.println("1. Gerenciar Exames");
            System.out.println("2. Gerenciar Medicamentos");
            System.out.println("3. Gerenciar Prescrições");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1 -> gerenciarExames();
                case 2 -> gerenciarMedicamentos();
                case 3 -> gerenciarPrescricoes();
            }
        } while (opcao != 0);
    }
    private static void gerenciarExames() {
        int opcao;
        do {
            System.out.println("\n-= Gerenciamento de Exames =-");
            System.out.println("1. Cadastrar Exame");
            System.out.println("2. Listar Exames");
            System.out.println("3. Atualizar Exame");
            System.out.println("4. Remover Exame");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1 -> cadastrarExame();
                case 2 -> listarExames();
                case 3 -> atualizarExame();
                case 4 -> removerExame();
            }
        } while (opcao != 0);
    }
    private static void cadastrarExame() {
        System.out.println("\n--- Novo Exame ---");
        String tipo = lerString("Tipo do exame: ");
        double custo = lerDouble("Custo: R$ ");
        
        Exames exame = new Exames(tipo, LocalDate.now(), custo);
        cadastroExame.cadastrar(exame);
        System.out.println("Exame cadastrado com sucesso! ID: " + exame.getId());
    }

    private static void listarExames() {
        System.out.println("\n=== Exames Cadastrados ===");
        cadastroExame.listar().forEach(e -> 
            System.out.println("ID: " + e.getId() + " | Tipo: " + e.getTipo() + 
                             " | Custo: R$" + e.getCusto())
        );
    }

    private static void atualizarExame() {
        String id = lerString("ID do exame: ");
        Optional<Exames> exameOpt = cadastroExame.buscarPorId(id);
        
        if(exameOpt.isPresent()) {
            Exames exame = exameOpt.get();
            String novoTipo = lerString("Novo tipo (" + exame.getTipo() + "): ");
            double novoCusto = lerDouble("Novo custo (R$" + exame.getCusto() + "): ");
            
            exame.setTipo(novoTipo);
            exame.setCusto(novoCusto);
            System.out.println("Exame atualizado!");
        } else {
            System.out.println("Exame não encontrado!");
        }
    }

    private static void removerExame() {
        String id = lerString("ID do exame: ");
        boolean removido = cadastroExame.remover(id);
        System.out.println(removido ? "Exame removido!" : "Exame não encontrado!");
    }
    private static void gerenciarMedicamentos() {
        int opcao;
        do {
            System.out.println("\n-= Gerenciamento de Medicamentos =-");
            System.out.println("1. Cadastrar Medicamento");
            System.out.println("2. Listar Medicamentos");
            System.out.println("3. Atualizar Medicamento");
            System.out.println("4. Remover Medicamento");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1 -> cadastrarMedicamento();
                case 2 -> listarMedicamentos();
                case 3 -> atualizarMedicamento();
                case 4 -> removerMedicamento();
            }
        } while (opcao != 0);
    }
    private static void cadastrarMedicamento() {
        System.out.println("\n--- Novo Medicamento ---");
        String nome = lerString("Nome: ");
        String dosagem = lerString("Dosagem: ");
        String instrucoes = lerString("Instruções: ");
        
        Medicamento medicamento = new Medicamento(nome, dosagem, instrucoes);
        cadastroMedicamento.cadastrar(medicamento);
        System.out.println("Medicamento cadastrado! ID: " + medicamento.getId());
    }

    private static void listarMedicamentos() {
        System.out.println("\n=== Medicamentos Cadastrados ===");
        cadastroMedicamento.listar().forEach(m -> 
            System.out.println("ID: " + m.getId() + " | Nome: " + m.getNome() + 
                             " | Dosagem: " + m.getDosagem())
        );
    }

    private static void atualizarMedicamento() {
        String id = lerString("ID do medicamento: ");
        Optional<Medicamento> medOpt = cadastroMedicamento.buscarPorId(id);
        
        if(medOpt.isPresent()) {
            Medicamento med = medOpt.get();
            med.setNome(lerString("Novo nome (" + med.getNome() + "): "));
            med.setDosagem(lerString("Nova dosagem (" + med.getDosagem() + "): "));
            med.setInstrucoes(lerString("Novas instruções: "));
            System.out.println("Medicamento atualizado!");
        } else {
            System.out.println("Medicamento não encontrado!");
        }
    }

    private static void removerMedicamento() {
        String id = lerString("ID do medicamento: ");
        boolean removido = cadastroMedicamento.remover(id);
        System.out.println(removido ? "Medicamento removido!" : "Medicamento não encontrado!");
    }

    private static void gerenciarPrescricoes() {
        int opcao;
        do {
            System.out.println("\n-= Gerenciamento de Prescrições =-");
            System.out.println("1. Criar Prescrição");
            System.out.println("2. Listar Prescrições");
            System.out.println("3. Adicionar Exame à Prescrição");
            System.out.println("4. Adicionar Medicamento à Prescrição");
            System.out.println("0. Voltar");
            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1 -> criarPrescricao();
                case 2 -> listarPrescricoes();
                case 3 -> adicionarExamePrescricao();
                case 4 -> adicionarMedicamentoPrescricao();
            }
        } while (opcao != 0);
    }
    public static void criarPrescricao() {
        System.out.println("CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();
        Pessoas paciente = cadastroPaciente.buscarPorCPF(cpfPaciente);
        
        System.out.println("ID da consulta: ");
        String idConsulta = scanner.nextLine();
        
        Consulta consulta = buscarConsultaPaciente(paciente, idConsulta);
        
        if(consulta != null) {
            Prescricao prescricao = new Prescricao(consulta, LocalDate.now().plusDays(30));
            cadastroPrescricao.cadastrar(prescricao);
            System.out.println("Prescrição criada com sucesso!");
        }
    }
    
    private static Consulta buscarConsultaPaciente(Pessoas paciente, String idConsulta) {
        if(paciente == null) {
            System.out.println("Paciente não encontrado!");
            return null;
        }
        
        return paciente.getConsultas().stream()
            .filter(c -> c.getId().equals(idConsulta))
            .findFirst()
            .orElseGet(() -> {
                System.out.println("Consulta não encontrada para este paciente!");
                return null;
            });
    }

    public static void listarPrescricoes() {
        cadastroPrescricao.listar().forEach(p -> 
            System.out.println("Prescrição ID: " + p.getId() + 
                             " - Consulta: " + p.getConsultaAssociada().getId()));
    }
    private static void adicionarExamePrescricao() {
        String idPrescricao = lerString("ID da prescrição: ");
        Optional<Prescricao> prescricaoOpt = cadastroPrescricao.buscarPorId(idPrescricao);
        
        if(prescricaoOpt.isPresent()) {
            String idExame = lerString("ID do exame: ");
            Optional<Exames> exameOpt = cadastroExame.buscarPorId(idExame);
            
            if(exameOpt.isPresent()) {
                prescricaoOpt.get().adicionarExame(exameOpt.get());
                System.out.println("Exame adicionado à prescrição!");
            } else {
                System.out.println("Exame não encontrado!");
            }
        } else {
            System.out.println("Prescrição não encontrada!");
        }
    }

    private static void adicionarMedicamentoPrescricao() {
        String idPrescricao = lerString("ID da prescrição: ");
        Optional<Prescricao> prescricaoOpt = cadastroPrescricao.buscarPorId(idPrescricao);
        
        if(prescricaoOpt.isPresent()) {
            String idMedicamento = lerString("ID do medicamento: ");
            Optional<Medicamento> medOpt = cadastroMedicamento.buscarPorId(idMedicamento);
            
            if(medOpt.isPresent()) {
                prescricaoOpt.get().adicionarMedicamento(medOpt.get());
                System.out.println("Medicamento adicionado à prescrição!");
            } else {
                System.out.println("Medicamento não encontrado!");
            }
        } else {
            System.out.println("Prescrição não encontrada!");
        }
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
