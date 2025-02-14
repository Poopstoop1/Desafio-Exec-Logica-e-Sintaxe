package ProcessoSeletivo.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Desafio Pequeno Sistema para validação de Processo seletivo
 * 
 * @author Poopstoop1
 * @since 13.02.2025
 */
public class ProcessoSeletivo {

	static List<String> candidatosSelecionados = new ArrayList<>();

	/* Método principal que inicia a aplicação */
	public static void main(String[] args) {
		
		selecaoCandidatos();
		System.out.println("\n *********************Imprimir Selecionados***************** \n" );
		imprimirSelecionados();
		System.out.println("\n *********************Entrando em Contato***************** \n" );
		entrandoEmContato();
		
	}

	/* Imprimir apenas os nomes dos selecionados */
	static void imprimirSelecionados() {
		for (String candidatos : candidatosSelecionados) {
			System.out.println("Candidatos selecionados: " + candidatos);
		}
	}

	/**
	 * Chama todos os candidatos e atribui os selecionados a Lista
	 */
	static void selecaoCandidatos() {
		String[] candidatos = { "Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela",
				"Jorlan" };
		int candidatoSelecionados = 0;
		int candidaAtual = 0;
		double salarioBase = 2000.0;
		while (candidatoSelecionados < 5 && candidaAtual < candidatos.length) {
			String candidato = candidatos[candidaAtual];
			double salarioPretendido = valorPretendido();
			System.out.println("O Candidato" + candidato + " Solicitou este valor de salario " + salarioPretendido);
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato:" + candidato + " foi selecionado para a vaga.");
				candidatoSelecionados++;
				candidatosSelecionados.add(candidato);
			}
			candidaAtual++;
		}

	}

	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}

	/**
	 * Verifica se determinado candidato atendeu a ligação com no max 3 tentativas.
	 * Se candidato atendeu imprimir conseguimos [nomeCandid] e [numTntativas],
	 * Senão não conseguimos contato com o candidato
	 * 
	 */
	static void entrandoEmContato() {

		Map<String, Pair<Boolean, Integer>> candidatosLig = new HashMap<>();
		boolean atender = false;
		boolean continuarTentando = true;
		int tentativas = 1;

		if (!candidatosSelecionados.isEmpty()) {
			/**
			 * For para determinar se o candidato atendeu ou não e Inserir na Estrutura Map
			 */

			for (String candidato : candidatosSelecionados) {

				do {
					atender = atender();
					continuarTentando = !atender;
					if (continuarTentando) {
						tentativas++;
					}

				} while (continuarTentando && tentativas < 3);

				candidatosLig.put(candidato, new ImmutablePair<>(atender, tentativas));
			}
			/**
			 * For para imprimir o Nome e o Num de tentativas da ligação, sem a necessidade
			 * de outra Classe Aqui estou reforçando a pratica da Estrutura de dados Map.
			 */
			for (Map.Entry<String, Pair<Boolean, Integer>> entry : candidatosLig.entrySet()) {
				if (entry.getValue().getKey() == true) {
					System.out.println("O candidato: " + entry.getKey() + " Atendeu a ligação de pois da tentativa num:"
							+ entry.getValue().getValue());
				} else {
					System.out.println("Não conseguimos contato com o candidato: " + entry.getKey());
				}
			}
		} else {
			System.out.println("Não há candidatos selecionados");
		}
	}

	/**
	 * Método Auxiliar que determina se a tentativa foi bem sucedida ou não.
	 * 
	 * O método gera um número aleatorio entre 0 e 2 e retorna 'true' Se o número
	 * gerado for igual a 1. caso contrario, retorna 'false'.
	 * 
	 * @return {@code true} se o numero gerado for igual a 1, caso não {@code false}
	 */
	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}
}
