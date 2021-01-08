package br.com.cursodejava.application;

import java.util.Date;

import br.com.cursodejava.model.DAO.FabricaDAO;
import br.com.cursodejava.model.DAO.VendedorDAO;
import br.com.cursodejava.model.entities.Departamento;
import br.com.cursodejava.model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		Departamento departamento = new Departamento(1, "Livros");
		
		Vendedor vendedor = new Vendedor(1, "Bob", "bob@gmail.com", new Date(), 3000.00, departamento);
		
		VendedorDAO vendedorDAO = FabricaDAO.createVendedorDAO();
		
		System.out.println(departamento);
		System.out.println(vendedor);
	}

}
