package br.com.cursodejava.model.DAO;

import java.util.List;

import br.com.cursodejava.model.entities.Departamento;

public interface DepartamentoDAO {

	public void inserir(Departamento departamento);
	public void alterar(Departamento departamento);
	public void ExcluirPorCodigo(Integer codigo);
	public Departamento buscarPorCodigo(Integer codigo);
	public List<Departamento> listarTodos();
	
	
}
