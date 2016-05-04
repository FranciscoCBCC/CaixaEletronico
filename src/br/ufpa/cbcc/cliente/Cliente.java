package br.ufpa.cbcc.cliente;

import br.ufpa.cbcc.enums.Gender;

public class Cliente extends Pessoa implements Comparable{

	public Cliente() {
		super();
		this.numeroConta = 0;
		this.setSaldo(0);
		this.senha = 0;
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(String nome, Gender genero, int idade, String cpf, String telefone, float numeroConta, float saldo, float senha){
		super(nome, genero, idade, cpf, telefone);
		this.numeroConta = numeroConta;
		this.setSaldo(saldo);
		this.senha = senha;
	}
	public Cliente(Cliente cliente){
		super((Cliente)cliente);
		this.numeroConta = cliente.numeroConta;
		this.setSaldo(cliente.saldo);
		this.senha = cliente.senha;
	}
	
	public String toString() {
		  return "Nome: "+this.getNome()+"\nIdade: "+this.idade+"\nCPF: "+this.cpf+"\nTelefone: "+this.telefone+"\nNumero da Conta: "+this.numeroConta+"\nSaldo: "+this.getSaldo()+"\nSenha: "+this.senha;
		}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public float getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(float numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public float getSenha() {
		return senha;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public int getIdade() {
		return idade;
	}
	
	@Override
	public int compareTo(Object o) {
		Cliente cliente = (Cliente)o;
		
		if(this.saldo > cliente.saldo){
			return 1;
		}
		if(this.saldo < cliente.saldo){
			return -1;
		}
		else
			return 0;
	}
	
	protected float numeroConta;
	private float saldo;
	protected float senha;
		
}
