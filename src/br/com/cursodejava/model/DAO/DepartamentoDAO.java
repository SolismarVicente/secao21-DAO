package br.com.cursodejava.model.DAO;

import java.util.List;

import br.com.cursodejava.model.entities.Departamento;

public interface DepartamentoDAO {

	//inserir � igual ao insert da apostila
	public void inserir(Departamento departamento);
	//alterar � igual ao update da apostila
	public void alterar(Departamento departamento);
	//excluirPorCodigo � igual ao deleteById da apostila
	public void excluirPorCodigo(Integer codigo);
	//buscarPorCodigo � igual ao findById da apostila
	public Departamento buscarPorCodigo(Integer codigo);
	//listarTodos � igual ao findAll da apostila
	public List<Departamento> listarTodos();
	
	
}
