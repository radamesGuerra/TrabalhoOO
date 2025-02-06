package servicos;

import entidades;
import excecoes;

import java.time.LocalDateTime;
import java.util.List;

public class Agendamento {
    public static void agendarConsulta(Medico medico, Pessoa pessoa, LocalDateTime dataHora, double valor) 
            throws HorarioIndisponivelException, PagamentoPendenteException, EspecialidadeInvalidaException {

        if (paciente.temPagamentoPendente()) {
            throw new PagamentoPendenteException("O paciente possui pagamento(s) pendente(s)!");
        }
        
        //verificar as especialidasdes disponíveis
        if (!medico.getEspecialidade().equals("Cardiologia")) { 
            throw new EspecialidadeInvalidaException("O médico não tem a especialidade requerida!");
        }

        // Verificação de horário
        for (Consulta c : medico.getHistoricoConsultas()) {
            if (c.getDataHora().equals(dataHora)) {
                throw new HorarioIndisponivelException("O horário já está ocupado!");
            }
        }

        Consulta consulta = new Consulta(dataHora, medico, pessoa, valor);
        medico.adicionarConsulta(consulta);
        pessoa.adicionarConsulta(consulta);
    }
}
