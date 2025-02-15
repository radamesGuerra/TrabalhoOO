package servicos;

import entidades.*;
import excecoes.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {
    
    public static String agendarConsulta(Medico medico, Pessoas paciente, 
                                      LocalDate data, LocalTime horarioInicio, 
                                      int duracao, double valor, String especialidadeRequerida) 
            throws HorarioIndisponivelException, PagamentoPendenteException, EspecialidadeInvalidaException {
        
        // verifica pagamentos pendentes
        if (pacienteTemPagamentosPendentes(paciente)) {
            throw new PagamentoPendenteException("Paciente com pagamentos pendentes!");
        }

        // verifica especialidade
        if (!medico.getEspecialidade().equalsIgnoreCase(especialidadeRequerida)) {
            throw new EspecialidadeInvalidaException(
                "Médico não é " + especialidadeRequerida + "! Especialidade do médico: " + medico.getEspecialidade()
            );
        }

        // verifica disponibilidade
        if (!medicoDisponivel(medico, data, horarioInicio, duracao)) {
            throw new HorarioIndisponivelException("Horário indisponível!");
        }

        // cria e registra consulta
        Consulta consulta = new Consulta(data, horarioInicio, duracao, medico, paciente, valor, especialidadeRequerida);
        medico.adicionarConsulta(consulta);
        paciente.adicionarConsulta(consulta);
        
        return consulta.getId();
        }
        
    public static void desagendarConsulta(String idConsulta, Medico medico, Pessoas paciente) {
        Consulta consulta = buscarConsultaPorId(idConsulta, medico, paciente);
        if (consulta != null) {
            consulta.setStatus("CANCELADA");
            medico.getConsultas().remove(consulta);
            paciente.getConsultas().remove(consulta);
        }
    }

    // métodos auxiliares
    private static boolean medicoDisponivel(Medico medico, LocalDate data, LocalTime horarioInicio, int duracao) {
        LocalTime horarioFim = horarioInicio.plusMinutes(duracao);
        
        return medico.getConsultas().stream().noneMatch(consultaExistente -> 
            consultaExistente.getData().equals(data) &&
            horarioInicio.isBefore(consultaExistente.getHorarioTermino()) &&
            horarioFim.isAfter(consultaExistente.getHorarioInicio())
        );
    }
    private static boolean pacienteTemPagamentosPendentes(Pessoas paciente) {
        return paciente.getConsultas().stream()
                .anyMatch(c -> c.getPagamentos().stream().anyMatch(p -> p.getStatus().equals("PENDENTE")));
    }

    private static Consulta buscarConsultaPorId(String id, Medico medico, Pessoas paciente) {
        return medico.getConsultas().stream()
                .filter(c -> c.getId().equals(id) && paciente.getConsultas().contains(c))
                .findFirst()
                .orElse(null);
    }
    
    protected static void agendarConsultaPrompt(Cadastro<Pessoas> cadastroPaciente, Cadastro<Medico> cadastroMedico) {
        String cpfPaciente = Principal.lerString("CPF do paciente: ");
        Pessoas paciente = cadastroPaciente.buscarPorCPF(cpfPaciente);

        String cpfMedico = Principal.lerString("CPF do médico: ");
        Medico medico = cadastroMedico.buscarPorCPF(cpfMedico);

        LocalDate data = Principal.lerData("Data da consulta (AAAA-MM-DD): ");

        System.out.print("Horário de Início da consulta (HH:MM): ");
        LocalTime horario = LocalTime.parse(Principal.scanner.nextLine());

        int duracao = Principal.lerInteiro("Duração da consulta (minutos): ");

        double valor = Principal.lerDouble("Valor: ");

        String especialidadeRequerida = Principal.lerString("Especialidade requerida: ");
        
        try {
        	String idConsulta = agendarConsulta(medico, paciente, data, horario, duracao, valor, especialidadeRequerida);
            System.out.println("Consulta agendada!");
            System.out.println("ID da consulta: " + idConsulta);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    protected static void desagendarConsultaPrompt(Cadastro<Pessoas> cadastroPaciente, Cadastro<Medico> cadastroMedico) {
        String idConsulta = Principal.lerString("ID da consulta: ");

        String cpfPaciente = Principal.lerString("CPF do paciente: ");
        Pessoas paciente = cadastroPaciente.buscarPorCPF(cpfPaciente);

        String cpfMedico = Principal.lerString("CPF do médico: ");
        Medico medico = cadastroMedico.buscarPorCPF(cpfMedico);

        desagendarConsulta(idConsulta, medico, paciente);
        System.out.println("Consulta desagendada!");
    }
    
    protected static void listarConsultas(Cadastro<Medico> cadastroMedico) {
        System.out.println("\n=== Consultas Marcadas ===");
        cadastroMedico.listarEntidade().forEach(medico -> 
            medico.getConsultas().forEach(consulta -> 
                System.out.println(
                    "ID: " + consulta.getId() + 
                    " | Data: " + consulta.getData() + 
                    " | Médico: " + medico.getNome() + 
                    " | Paciente: " + consulta.getPaciente().getNome()
                )
            )
        );
    }
    
}