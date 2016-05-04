package br.ufpa.cbcc.main;

import javax.swing.JOptionPane;
import br.ufpa.cbcc.caixaEletronico.CaixaEletronico;
import br.ufpa.cbcc.moeda.Dolar;
import br.ufpa.cbcc.moeda.Euro;
import br.ufpa.cbcc.moeda.Moeda;
import br.ufpa.cbcc.moeda.Libras;

public class Main {

	public static void main(String[] args) {
		int opcao;
		
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		
		do{
			try{
			String entrada = JOptionPane.showInputDialog("Caixa Eletronico\n1) Abrir Conta\n2) Extrato\n3) Depositar\n4) Sacar\n5) Conversor de Moedas\n6) Sair");
			opcao = Integer.parseInt(entrada);
			
			switch(opcao){
				case 1:
					caixaEletronico.abrirConta();
					break;
				case 2:
					String numeroContaExtrato = JOptionPane.showInputDialog("Digite o Numero da Conta: ");
					float numeroContaExtrato1 = Float.parseFloat(numeroContaExtrato);
					String senhaExtrato = JOptionPane.showInputDialog("Digite a Senha da Conta: ");
					float senhaExtrato1 = Float.parseFloat(senhaExtrato);
					caixaEletronico.extrato(numeroContaExtrato1, senhaExtrato1);
					break;
				case 3:
					String numeroContaDeposito = JOptionPane.showInputDialog("Digite o Numero da Conta: ");
					float numeroContaDeposito1 = Float.parseFloat(numeroContaDeposito);
					String valorDeposito1 = JOptionPane.showInputDialog("Digite o Valor Para Deposito: ");
					float valorDeposito = Float.parseFloat(valorDeposito1);
					caixaEletronico.depositar(numeroContaDeposito1, valorDeposito);
					break;
				case 4:
					String numeroContaSaque = JOptionPane.showInputDialog("Digite o Numero da Conta: ");
					float numeroContaSaque1 = Float.parseFloat(numeroContaSaque);
					String senhaSaque = JOptionPane.showInputDialog("Digite a Senha da Conta: ");
					float senhaSaque1 = Float.parseFloat(senhaSaque);
					String valorSaque = JOptionPane.showInputDialog("Digite o Valor Para Saque: ");
					float valorSaque1 = Float.parseFloat(valorSaque);
					caixaEletronico.sacar(numeroContaSaque1, senhaSaque1, valorSaque1);
					break;
				case 5:
					try{
						String valor = JOptionPane.showInputDialog("Digite Um Valor (Em Reais) Para Conversao: ");
						double valor1 = Integer.parseInt(valor);	
						Libras libras = new Libras();
						Dolar dolar = new Dolar();
						Euro euro = new Euro();
						libras.setValorEmLibras(valor1);
						euro.setValorEmEuro(valor1);
						dolar.setValorEmDolar(valor1);
						Moeda listaDeMoedas[] = {libras, dolar, euro};
						
						for(int i=0; i<listaDeMoedas.length; i++){						
							if(listaDeMoedas[i] instanceof Libras){
								((Libras) listaDeMoedas[i]).ValorEmLibras();
							}
							if(listaDeMoedas[i] instanceof Dolar){
								((Dolar) listaDeMoedas[i]).ValorEmDolar();
							}
							if(listaDeMoedas[i] instanceof Euro){
								((Euro) listaDeMoedas[i]).ValorEmEuro();
							}
						}
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, "Digite Somente Numeros.");
					}
					break;
				case 6:
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcao Invalida.");
				}
			}catch(Exception NumberFormatException){
				JOptionPane.showMessageDialog(null, "Opcao Invalida.");
			}
		}while(true); 
	}
}