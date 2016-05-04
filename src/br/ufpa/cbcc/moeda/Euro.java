package br.ufpa.cbcc.moeda;

import javax.swing.JOptionPane;

public class Euro extends Moeda{

	public Euro() {
		super();
	}
	public Euro(double valorEmEuro){
		super(valorEmEuro);
	}
	public Euro(Euro euro){
		super((Moeda)euro);
	}
	
	public void setValorEmEuro(double valorEmEuro) {
		this.valorEmEuro = valorEmEuro;		
	}
	public void ValorEmEuro() {
		JOptionPane.showMessageDialog(null, "Euro: "+valorEmEuro*proporcao);
	}
	
	protected static double valorEmEuro;
	protected static double proporcao = 0.2444151;
}
