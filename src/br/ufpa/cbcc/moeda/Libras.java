package br.ufpa.cbcc.moeda;

import javax.swing.JOptionPane;

public class Libras extends Moeda{

	public Libras() {
		super();
	}
	public Libras(double valorEmLibras){
		super(valorEmLibras);
	}
	public Libras(Libras libras){
		super((Moeda)libras);
	}
	public void setValorEmLibras(double valorEmLibras) {
		this.valorEmLibras = valorEmLibras;
	}
	public void ValorEmLibras() {
		JOptionPane.showMessageDialog(null, "Libras: "+valorEmLibras*proporcao);
	}
	
	protected static double valorEmLibras;
	protected static double proporcao = 0.1934086;


	
}
