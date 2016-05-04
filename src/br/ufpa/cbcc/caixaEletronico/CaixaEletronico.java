package br.ufpa.cbcc.caixaEletronico;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import br.ufpa.cbcc.cliente.Cliente;
import br.ufpa.cbcc.enums.Gender;
import br.ufpa.cbcc.interfaces.OperacoesFinanceiras;
import br.ufpa.cbcc.caixaEletronico.*;

public class CaixaEletronico extends Computador implements OperacoesFinanceiras{
	public CaixaEletronico(){
		super();
	}
	public CaixaEletronico(boolean ligado, boolean operacional){
		super(ligado, operacional);
	}
	public CaixaEletronico(CaixaEletronico caixaEletronico){
		super((Computador)caixaEletronico);
	}

	ArrayList<Cliente> arrayClientes = new ArrayList<Cliente>(); 
			
	public void abrirConta(){
		String cpf = JOptionPane.showInputDialog("Digite o CPF do Cliente: ");
		
		
		String nome = JOptionPane.showInputDialog("Digite o Nome do Cliente: ");
		boolean laco = false;
		Gender genero = null;
		do{
			try{
				String opcaoGenero = JOptionPane.showInputDialog("Sexo:\n(1) MASCULINO\n(2) FEMININO");
				int opcaoGenero1 = Integer.parseInt(opcaoGenero);
				if(opcaoGenero1 == 1){
					genero = Gender.MASCULINO;
					laco = false;
				}
				else if(opcaoGenero1 == 2){
					genero = Gender.FEMININO;
					laco = false;
				}
				else{
					JOptionPane.showMessageDialog(null, "Opcao Invalida.");
					laco = true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Opcao Invalida.");
				laco = true;
			}
		}while(laco);
		
		String idade1 = JOptionPane.showInputDialog("Digite a Idade do Cliente: ");
		int idade = Integer.parseInt(idade1);
		String telefone = JOptionPane.showInputDialog("Digite o Telefone do Cliente: ");
		boolean senhaForte;
		String senhaString;
		float senhaFloat;
		do{
			senhaString = JOptionPane.showInputDialog("Digite a Senha da Conta: ");
			senhaFloat = Float.parseFloat(senhaString);
			boolean testeSenhaIgualTelefone = senhaString.equals(telefone);
			boolean testeSenhaIgualCPF = senhaString.equals(cpf);
			if(testeSenhaIgualTelefone || testeSenhaIgualCPF){
				JOptionPane.showMessageDialog(null, "Senha Muito Fraca.");
				senhaForte = false;
			}
			else
				senhaForte = true;
				
		}while(!senhaForte);
			
			String deposito1 = JOptionPane.showInputDialog("Digite um Valor Para Deposito (OBRIGATORIO): ");
			float deposito = Float.parseFloat(deposito1);
			Random random  = new Random();
			float numeroConta = random.nextInt(99999); 
			JOptionPane.showMessageDialog(null, "Anote o Numero da Sua Conta: "+numeroConta);
			Cliente cliente = new Cliente(nome, genero, idade, cpf, telefone, numeroConta, deposito, senhaFloat);
			arrayClientes.add(cliente);		
	}
		
		
	
	@Override
	public void extrato(float numeroConta, float senha){			
			for(int i=0; i<arrayClientes.size(); i++){
				if((numeroConta == arrayClientes.get(i).getNumeroConta()) && (senha == arrayClientes.get(i).getSenha())){
					JOptionPane.showMessageDialog(null, "Cliente: "+arrayClientes.get(i).getNome()+"\nConta: "+arrayClientes.get(i).getNumeroConta()+"\nSaldo: "+arrayClientes.get(i).getSaldo());
					break;
				}
				else
					JOptionPane.showMessageDialog(null, "Conta Nao Encontrada ou Senha Invalida.");			
			}
	}
	
	
	@Override
	public void depositar(float numeroConta, float valor) {
		for(int i=0; i<arrayClientes.size(); i++){
			if(numeroConta == arrayClientes.get(i).getNumeroConta()){
				float valorTemp = arrayClientes.get(i).getSaldo();
				valorTemp+=valor;
				arrayClientes.get(i).setSaldo(valorTemp);	
				JOptionPane.showMessageDialog(null, "Deposito Realizado Com Sucesso!");
				break;
			}	
			else
				JOptionPane.showMessageDialog(null, "Conta Nao Encontrada.");
		}
	}
	@Override
	public void sacar(float numeroConta, float senha, float valor) {		
		for(int i=0; i<arrayClientes.size(); i++){
			if((numeroConta == arrayClientes.get(i).getNumeroConta()) && (senha == arrayClientes.get(i).getSenha())){
				if(valor <= (arrayClientes.get(i).getSaldo())){
					float valorTemp = arrayClientes.get(i).getSaldo();
					valorTemp-=valor;
					arrayClientes.get(i).setSaldo(valorTemp);
					JOptionPane.showMessageDialog(null, "Saque Realizado Com Sucesso!");
					break;
				}
				else{
					JOptionPane.showMessageDialog(null, "Saldo Insuficiente.");
				}
				break;
			}
			else
				JOptionPane.showMessageDialog(null, "Conta Nao Encontrada ou Senha Invalida.");
		}
	}
}
