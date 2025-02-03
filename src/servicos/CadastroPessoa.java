package servicos;

import java.util.ArrayList;
import java.util.List;

import entidades.Pessoas;

public class CadastroPessoa {
	int numPessoas; 
	private List<Pessoas> pessoa;
	
	public CadastroPessoa() {
		numPessoas = 0;
		pessoa = new ArrayList<Pessoas>();
	}
	
}