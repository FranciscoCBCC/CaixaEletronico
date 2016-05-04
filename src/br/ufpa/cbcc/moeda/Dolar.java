package br.ufpa.cbcc.moeda;

import javax.swing.JOptionPane;

public class Dolar extends Moeda{

	public Dolar() {
		super();
	}
	public Dolar(double valorEmDolar){
		super(valorEmDolar);
	}
	
	public Dolar(Dolar dolar){
		super((Moeda)dolar);
	}
	public void setValorEmDolar(double valorEmDolar) {
		this.valorEmDolar = valorEmDolar;		
	}
	public void ValorEmDolar() {
		JOptionPane.showMessageDialog(null, "Dolar: "+valorEmDolar*proporcao);
	}
	
	protected static double valorEmDolar;
	protected static double proporcao = 0.281294;
}
