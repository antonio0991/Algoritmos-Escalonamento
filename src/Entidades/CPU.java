package Entidades;

import java.util.Random;

public class CPU {
	private static int QTD_CICLOS_INTERRUPCAO = 4;
	private static int QTD_PROCESSOS_INICIAL = 5;

	public static void main(String[] args) {

		Random rand = new Random();
		GeradorDeProcessos gerador = new GeradorDeProcessos();

		for (int i = 0; i < QTD_PROCESSOS_INICIAL; i++) {
			Escalonador.addProcesso(gerador.getNovoProcesso());
		}

		Escalonador.getProcessos();

		int ciclo = 0;

		// -------------FCFS-------------
		System.out.println("-----------------FCFS----------------");
//		 Se quiser botar pra rodar indefinidamente é só colocar while(true)
		while (Escalonador.temProcesso()) {

			if (rand.nextInt(250) == 0) { // chance de 1 em 250 de gerar um novo processo
				System.out.println("NOVO PROCESSO!");
				System.out.println(Escalonador.getProcessos());
				Escalonador.addProcesso(gerador.getNovoProcesso());
			}

			if (ciclo % QTD_CICLOS_INTERRUPCAO == 0) {
				System.out.println("PROCESSO: " + Escalonador.getProximoProcessoFCFS().toString());
			}

			ciclo++;
		}

		// ---------------SJF--------------
		// Se quiser botar pra rodar indefinidamente é só colocar while(true)
		// Mesma coisa do FCFS, mas com os processos ordenados por quantidade de
		// instruções

		for (int i = 0; i < QTD_PROCESSOS_INICIAL; i++) {
			Escalonador.addProcesso(gerador.getNovoProcesso());
		}
		Escalonador.getProcessos();

		ciclo = 0;
		System.out.println("-----------------SJF----------------");
		Escalonador.ordernarProcessos();
		while (Escalonador.temProcesso()) {

			if (rand.nextInt(250) == 0) { // chance de 1 em 250 de gerar um novo processo
				System.out.println("NOVO PROCESSO!");
				System.out.println(Escalonador.getProcessos());
				Escalonador.addProcesso(gerador.getNovoProcesso());
				// Se eu ficar adicionando processos e ordendando depois, isso não vai jogar
				// processos com menos instruções sempre pro fim da lista?
				Escalonador.ordernarProcessos();
			}

			if (ciclo % QTD_CICLOS_INTERRUPCAO == 0) {
				System.out.println("PROCESSO: " + Escalonador.getProximoProcessoSJF().toString());
			}

			ciclo++;
		}

		System.out.println("-----------------ROUND ROBIN----------------");
		for (int i = 0; i < QTD_PROCESSOS_INICIAL; i++) {
			Escalonador.addProcesso(gerador.getNovoProcesso());
		}
		Escalonador.getProcessos();
		ciclo = 0;
		while (Escalonador.temProcesso()) {

			if (rand.nextInt(50) == 0) { // chance de 1 em 50 de gerar um novo processo
				System.out.println("NOVO PROCESSO!");
				System.out.println(Escalonador.getProcessos());
				Escalonador.addProcesso(gerador.getNovoProcesso());
				// Se eu ficar adicionando processos e ordendando depois, isso não vai jogar
				// processos com menos instruções sempre pro fim da lista?
				Escalonador.ordernarProcessos();
			}

			System.out.println("PROCESSO: " + Escalonador.getProximoProcessoRoundRobin(ciclo, QTD_CICLOS_INTERRUPCAO).toString());

			ciclo++;
		}
	}

}
