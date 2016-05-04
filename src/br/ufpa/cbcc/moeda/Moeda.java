package br.ufpa.cbcc.moeda;

public abstract class Moeda {
	public Moeda(){
		valor = 0;
	}
	
	public Moeda(double valor){
		this.valor = valor;
	}
	
	public Moeda(Moeda moeda){
		this.valor = moeda.valor;
	}
	
	private static double valor;
}