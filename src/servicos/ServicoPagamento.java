package servicos;

import entidades.Consulta;
import entidades.Pagamento;
import excecoes.PagamentoPendenteException;
import java.time.LocalDate;

public class ServicoPagamento {
    public static boolean temPagamentoPendente(Consulta consulta) {
        double totalPago = consulta.getPagamentos().stream()
            .filter(p -> p.getStatus().equals("PAGO"))
            .mapToDouble(Pagamento::getValor)
            .sum();
        
        return totalPago < consulta.getValor();
    }

    public void pagarConsulta(Consulta consulta, double valor) throws PagamentoPendenteException {
        if(valor <= 0) {
            throw new PagamentoPendenteException("Valor inválido para pagamento!");
        }
        
        Pagamento pagamento = new Pagamento(valor, LocalDate.now(), "PAGO");
        consulta.adicionarPagamento(pagamento);
        
        if(temPagamentoPendente(consulta)) {
            throw new PagamentoPendenteException("Pagamento parcial realizado!");
        }
    }
}