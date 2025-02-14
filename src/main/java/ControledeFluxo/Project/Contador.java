package ControledeFluxo.Project;

import java.util.Scanner;

/**
 * Desafio Dio Controle de fluxo básico.
 * Exercitando lógica e sintaxe.
 * 
 * @author Poopstoop1
 * @since 13.02.2025
 * */

public class Contador {

	/*Main para inicializar a aplicação*/
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num1;
		int num2;
		
		try {
			System.out.println("Primeiro Numero: ");
			num1 = scan.nextInt();
			System.out.println("Segundo numero");
			num2= scan.nextInt();
			imprimirNum(num1,num2);
			
			
		} catch (ParametrosInvalidoException e) {
			e.getMessage();
			System.out.println("O segundo parâmetro deve ser maior que o primeiro");
		}
		scan.close();

	}
	/**
	 * Imprimindo o numero de 1 até sub
	 * */
	static void imprimirNum(int num1, int num2) throws ParametrosInvalidoException {
		int sub = num2 - num1;
		
		if (num1 > num2)
			throw new ParametrosInvalidoException();
		else {
			for (int i = 1; i <= sub; i++) {
				System.out.println("Imprimindo o Número " + i);
			}
		}

		
	}

}
