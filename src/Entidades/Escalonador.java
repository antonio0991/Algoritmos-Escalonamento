package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Escalonador {
	
	private static Queue<Processo> processos = new LinkedList<>();	
	private static int QUANTUM = 10;
	
	public static void addProcesso(Processo processo) {
		processos.add(processo);
	}
	
	public static Processo getProximoProcessoFCFS() {
		Processo atual = processos.peek();
		//Pegar próximo elemento
		if(atual.getQtdInstrucoes() <= 1) {
			processos.poll();
		}
		atual.decQtdInstrucoes();
		return atual;
	}
	
	public static Processo getProximoProcessoSJF() {
		return getProximoProcessoFCFS();
	}
	
	public static void ordernarProcessos() {
		List<Processo> processosList = new ArrayList<Processo>(processos);
		Collections.sort(processosList); //Ordenando por quantidade de instruções
		processos = new LinkedList<Processo>(processosList);
	}
	
	public static Processo getProximoProcessoRoundRobin() {
		return null;
	}
	
	public static String getProcessos() {
		StringBuilder buffer = new StringBuilder();
		for(Processo p : processos) {
			buffer.append(p.getId());
			buffer.append(" ");
		}
		
		return buffer.toString();
	}
	
	public static Processo getProximoProcessoRoundRobin(int ciclo, int interrupcao) {
		if(ciclo % QUANTUM == 0 && ciclo % interrupcao == 0) {
			processos.add(processos.poll());
			System.out.println("ROUND ROBIN! \n" + getProcessos());
		}
		return getProximoProcessoFCFS();
	}
	
	public static boolean temProcesso() {
		return !processos.isEmpty();
	}
}
