package br.com.cursodejava.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.cursodejava.model.DAO.FabricaDAO;
import br.com.cursodejava.model.DAO.VendedorDAO;
import br.com.cursodejava.model.entities.Departamento;
import br.com.cursodejava.model.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		VendedorDAO vendedorDAO = FabricaDAO.createVendedorDAO();
		
		System.out.println("===Teste número 1: BuscarVendedorPorCodigo");
		Vendedor vendedor1 = vendedorDAO.buscarPorCodigo(3);
		System.out.println(vendedor1);
		
		System.out.println("\n===Teste número 2: listarVendedorPorDepartamento");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> lista = vendedorDAO.listarPorDepartamento(departamento);
		for (Vendedor vendedor2 : lista) {
			System.out.println(vendedor2);
		}
		
		System.out.println("\n===Teste número 3: listarTodos");
		lista = vendedorDAO.listarTodos();
		for (Vendedor vendedor3 : lista) {
			System.out.println(vendedor3);
		}
		
		System.out.println("\n===Teste número 4: inserirVendedor"); Vendedor
		vendedor4 = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.00,
				departamento); vendedorDAO.inserir(vendedor4);
		System.out.println("Vendedor inserido! Código: " + vendedor4.getCodigo());
		
		System.out.println("\n===Teste número 5: alterarVendedor");
		Vendedor vendedor5 = vendedorDAO.buscarPorCodigo(1);
		vendedor5.setNomeVendedor("Martha Waine");
		vendedorDAO.alterar(vendedor5);
		System.out.println("Vendedor Alterado! Nome do Vendedor: " + vendedor5.getNomeVendedor());
		
		System.out.println("\n===Teste número 6: excluirVendedorPorCodigo");
		System.out.print("Digite o código do Vendedor para exclusão: "); 
		int codVendedor = sc.nextInt(); vendedorDAO.ExcluirPorCodigo(codVendedor);;
		System.out.println("Vendedor Excluído!");
		
		System.out.println();
		
		System.out.println("----listar todos os vendedores----");
		lista = vendedorDAO.listarTodos();
		for (Vendedor vendedor3 : lista) {
			System.out.println(vendedor3);
		}
		
		sc.close();
	}

}
