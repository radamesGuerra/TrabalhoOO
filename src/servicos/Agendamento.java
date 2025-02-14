package servicos;

import entidades.Consulta;
import entidades.Exames;
import entidades.Medico;
import entidades.Pessoas;
import excecoes.HorarioIndisponivelException;
import excecoes.EspecialidadeInvalidaException;
import excecoes.PagamentoPendenteException;

import java.time.LocalDateTime;
import java.util.List;

public class Agendamento {
    public static void agendarConsulta(Medico medico, Pessoas pessoa, LocalDateTime dataHora, double valor) 
            throws HorarioIndisponivelException, PagamentoPendenteException, EspecialidadeInvalidaException {

        if (pessoa.temPagamentoPendente()) {
            throw new PagamentoPendenteException("O paciente possui pagamento(s) pendente(s)!");
        }
        
        //verificar as especialidasdes disponíveis
        if (!medico.getEspecialidade().equalsIgnoreCase(especialidadeRequerida)) { 
            throw new EspecialidadeInvalidaException("O médico não tem a especialidade requerida!");
        }

        // Verificação de horário
        for (Consulta c : medico.getConsultas()) {
            if (c.getData().equals(dataHora)) {
                throw new HorarioIndisponivelException("O horário já está ocupado!");
            }
        }

        Consulta consulta = new Consulta(dataHora, medico, pessoa, valor);
        medico.adicionarConsulta(consulta);
        pessoa.adicionarConsulta(consulta);
    }
}
