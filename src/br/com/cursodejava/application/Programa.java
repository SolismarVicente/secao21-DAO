package br.com.cursodejava.application;

import br.com.cursodejava.model.DAO.FabricaDAO;
import br.com.cursodejava.model.DAO.VendedorDAO;
import br.com.cursodejava.model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDAO vendedorDAO = FabricaDAO.createVendedorDAO();
		
		System.out.println("===Teste n�mero 1: BuscarVendedorPorCodigo");
		
		Vendedor vendedor = vendedorDAO.buscarPorCodigo(3);
		
		System.out.println(vendedor);
	}

}
