package servicos;

import java.util.List;

public abstract class Cadastro<T> {
	
    public abstract void cadastrarEntidade(T entidade);
    public abstract List<T> listarEntidade();
    public abstract T buscarPorCPF(String cpf);
    public abstract boolean remover(String cpf);
    public abstract boolean atualizarEntidade(String cpf, T novosDados);
    public abstract void cadastrar();
    public abstract void listar();
    public abstract void atualizar();
}