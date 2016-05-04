package br.ufpa.cbcc.caixaEletronico;

public abstract class Computador extends Dispositivo{

	public Computador() {
		super();
		this.operacional = true;
	}
	public Computador(boolean ligado, boolean operacional){
		super(ligado);
		this.operacional = operacional;
	}
	public Computador(Computador computador){
		super((Computador)computador);
		this.operacional = computador.operacional;
	}
	
	protected static boolean operacional;
}
