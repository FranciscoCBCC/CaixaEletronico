package br.ufpa.cbcc.enums;

public enum Gender {
	MASCULINO, FEMININO;
	
	Gender(){
		genero = null;
	}
	
	Gender getSexo(){
		return genero;
	}
	Gender genero;
}
