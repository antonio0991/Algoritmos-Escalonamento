package Entidades;

public class GeradorDeProcessos {
	
	private int idCont = 0;
	
	public Processo getNovoProcesso() {
		return new Processo(idCont++);
	}
	
}
