package br.ufpa.cbcc.interfaces;

public interface OperacoesFinanceiras {
	public abstract void depositar(float numeroConta, float valor);
	public abstract void sacar(float numeroConta, float senha, float valor);
	public abstract void extrato(float numeroConta, float senha);
}
