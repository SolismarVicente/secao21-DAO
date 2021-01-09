package br.com.cursodejava.model.DAO;

import java.util.List;

import br.com.cursodejava.model.entities.Departamento;
import br.com.cursodejava.model.entities.Vendedor;

public interface VendedorDAO {

	public void inserir(Vendedor vendedor);
	public void alterar(Vendedor vendedor);
	public void ExcluirPorCodigo(Integer codigo);
	public Vendedor buscarPorCodigo(Integer codigo);
	public List<Vendedor> listarTodos();
	public List<Vendedor> listarPorDepartamento(Departamento departamento);
	
}
