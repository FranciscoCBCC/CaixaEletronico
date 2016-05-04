package br.ufpa.cbcc.cliente;

import br.ufpa.cbcc.enums.Gender;

public abstract class Pessoa {
	public Pessoa(){
		this.setNome("Nome");
		this.genero = "Nenhum";
		this.idade = 0;
		this.cpf = "000.000.000-00";
		this.telefone = "(00)00000-0000";
	}
	
	public Pessoa(String nome, Gender genero, int idade, String cpf, String telefone){
		this.setNome(nome);
		this.idade = idade;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	public Pessoa(Pessoa pessoa) {
		this.setNome(pessoa.nome);
		this.idade = pessoa.idade;
		this.cpf = pessoa.cpf;
		this.telefone = pessoa.telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private String nome;
	protected String genero;
	protected int idade;
	protected String cpf;
	protected String telefone;
}
