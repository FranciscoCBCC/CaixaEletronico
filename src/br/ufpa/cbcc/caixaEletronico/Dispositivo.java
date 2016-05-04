package br.ufpa.cbcc.caixaEletronico;

public abstract class Dispositivo {
	
	public Dispositivo(){
		this.ligado = true;
	}
	public Dispositivo(boolean ligado){
		this.ligado = ligado;
	}
	public Dispositivo(Dispositivo dispositivo){
		this.ligado = dispositivo.ligado;
	}
	
	public static void ligar(){
		ligado = true;
	}
	
	public static void desLigar(){
		ligado = false;
	}
	
	protected static boolean ligado;
}
