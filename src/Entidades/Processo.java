package Entidades;

public class Processo implements Comparable<Processo>{
	
	private static int MIN_INSTRUCOES = 10;
	private static int MAX_INSTRUCOES = 50;

	
	public Processo(int id) {
		this.id = id;
		this.qtdInstrucoes = (int) ((Math.random() * (MAX_INSTRUCOES - MIN_INSTRUCOES)) + MIN_INSTRUCOES);//Número aleatório entre 10 e 50
	}
	

	private int id;
	private int qtdInstrucoes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQtdInstrucoes() {
		return qtdInstrucoes;
	}
	public void setQtdInstrucoes(int qtdInstrucoes) {
		this.qtdInstrucoes = qtdInstrucoes;
	}
	
	public void decQtdInstrucoes() {
		this.qtdInstrucoes--;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + " Instruções restantes: " + this.qtdInstrucoes;
	}
	
	@Override
	public int compareTo(Processo outro) {
		return Integer.compare(qtdInstrucoes, outro.getQtdInstrucoes());
	}
}
