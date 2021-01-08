package br.com.cursodejava.model.DAO;

import br.com.cursodejava.model.DAO.implementacao.VendedorDAOJDBC;

public class FabricaDAO {
	
	public static VendedorDAO createVendedorDAO() {
		return new VendedorDAOJDBC();
	}
}
