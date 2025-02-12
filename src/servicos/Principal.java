package servicos;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String entradaScanner;
		do {
			System.out.println("=* Menu *=");
			System.out.println("0. Sair");
			System.out.println("1. Cadastros");
			System.out.println("2. ");
			System.out.println("3.");
			System.out.println("4.");
			System.out.print("Escolha uma opção: ");

			entradaScanner = scanner.nextLine();
			switch(Integer.parseInt(entradaScanner)) {
			case 1:
				System.out.println("=* Cadastro de Pessoas *=");
				System.out.println("0. Voltar");
				System.out.println("1. Cadastro de Pacientes");
				System.out.println("2. Cadastro de Médicos");
				System.out.print("Escolha uma opção: ");
				entradaScanner = scanner.nextLine();
				break;
			case 2:
			}
			entradaScanner = "100000";
		} while(Integer.parseInt(entradaScanner) != 0);
		scanner.close();
	}
}

