package servicos;

import java.util.ArrayList;
import java.util.List;

import entidades.Pessoas;

public class CadastroPaciente extends Cadastro {
	int numAlunos; 
	private List<> alunos;
	
	public void CadastroAluno() {
		numAlunos = 0;
		alunos = new ArrayList<Aluno>();
	}
	
	public int cadastrarAluno(Aluno a) {
		boolean cadastrou = alunos.add(a);
		if (cadastrou) {
			numAlunos = alunos.size();
		}
		return numAlunos;
	}
	
	public Aluno pesquisarAluno(String matriculaAluno) {
		for (Aluno a: alunos) {
			if (a.getMatricula().equalsIgnoreCase(matriculaAluno)) {
				return a;
			}
		}
		return null;
	}
	
	public boolean removerAluno(Aluno a) {
		boolean removeu = false; 
		if (alunos.contains(a)) {
			removeu = alunos.remove(a);
		}
		return removeu;
	}
	
	public boolean atualizarAluno(String matricula, Aluno a) {
		boolean resposta = false;
		Aluno remover = pesquisarAluno(matricula);
		if (remover != null) {
			alunos.remove(remover);
			resposta = alunos.add(a);
		}
		return resposta;
	}
}