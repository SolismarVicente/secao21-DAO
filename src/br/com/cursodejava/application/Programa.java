package br.com.cursodejava.application;

import java.util.List;

import br.com.cursodejava.model.DAO.FabricaDAO;
import br.com.cursodejava.model.DAO.VendedorDAO;
import br.com.cursodejava.model.entities.Departamento;
import br.com.cursodejava.model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDAO vendedorDAO = FabricaDAO.createVendedorDAO();
		
		System.out.println("===Teste número 1: BuscarVendedorPorCodigo");
		Vendedor vendedor = vendedorDAO.buscarPorCodigo(3);
		System.out.println(vendedor);
		
		System.out.println("\n===Teste número 2: listarVendedorPorDepartamento");
		
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> lista = vendedorDAO.listarPorDepartamento(departamento);
		
		for (Vendedor vend : lista) {
			System.out.println(vend);
		}
	}

}
