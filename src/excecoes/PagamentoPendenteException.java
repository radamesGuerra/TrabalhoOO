package excecoes;

public class PagamentoPendenteException extends Exception {
    public PagamentoPendenteException(String mensagem) {
        super(mensagem);
    }
}