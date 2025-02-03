package servicos;

import java.util.ArrayList;
import java.util.List;

import entidades.Pessoas;

public class CadastroPaciente extends Cadastro {
	int numPessoas; 
	private List<Pessoas> pessoa;
	
	public CadastroPaciente() {
		numPessoas = 0;
		pessoa = new ArrayList<Pessoas>();
	}
	
}