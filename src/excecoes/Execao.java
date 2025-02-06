package excecoes;

public class HorarioIndisponivelException extends Exception {
    public HorarioIndisponivelException(String mensagem) {
        super(mensagem);
    }
}

public class PagamentoPendenteException extends Exception {
    public PagamentoPendenteException(String mensagem) {
        super(mensagem);
    }
}

public class EspecialidadeInvalidaException extends Exception {
    public EspecialidadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}