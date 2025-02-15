package servicos;

import entidades.Consulta;
import entidades.Pagamento;
import excecoes.PagamentoPendenteException;
import java.time.LocalDate;

public class ServicoPagamento {
    public void pagarConsulta(Consulta consulta, double valorPago) throws PagamentoPendenteException {
        if (consulta.getValor() > valorPago) {
        	consulta.setValor((consulta.getValor() - valorPago));
        	System.out.println("Valor insuficiente para pagar a consulta!");
            throw new PagamentoPendenteException("Valor faltante: R$" + valorPago);
        }
        
        Pagamento pagamento = new Pagamento(valorPago, LocalDate.now(), "PAGO");
        consulta.adicionarPagamento(pagamento);
    }

    public boolean temPagamentoPendente(Consulta consulta) {
        return consulta.getPagamentos().stream()
                .anyMatch(p -> p.getStatus().equals("PENDENTE"));
    }
}