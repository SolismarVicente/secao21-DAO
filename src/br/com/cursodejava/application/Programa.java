package br.com.cursodejava.application;

import br.com.cursodejava.model.entities.Departamento;

public class Programa {

	public static void main(String[] args) {
		
		Departamento departamento = new Departamento(1, "Livros");
		
		System.out.println(departamento);
	}

}
