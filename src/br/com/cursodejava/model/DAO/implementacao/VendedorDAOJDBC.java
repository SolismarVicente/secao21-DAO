package br.com.cursodejava.model.DAO.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;

import br.com.cursodejava.db.ConexaoDB;
import br.com.cursodejava.db.DBException;
import br.com.cursodejava.model.DAO.VendedorDAO;
import br.com.cursodejava.model.entities.Departamento;
import br.com.cursodejava.model.entities.Vendedor;

public class VendedorDAOJDBC implements VendedorDAO {

	private Connection conexao;
	
	public VendedorDAOJDBC(Connection conexao) {
		this.conexao = conexao;
	}
	
	private Vendedor instanciarVendedor(ResultSet rs, Departamento departamento) throws SQLException {
		Vendedor vendedor = new Vendedor();
		vendedor.setCodigo(rs.getInt("a.codigo"));
		vendedor.setNomeVendedor(rs.getString("a.nomeVendedor"));
		vendedor.setEmailVendedor(rs.getString("a.email"));
		vendedor.setDataNascimento(rs.getDate("a.dataNascimento"));
		vendedor.setSalarioBase(rs.getDouble("a.salarioBase"));
		vendedor.setDepartamento(departamento);
		
		return vendedor;
	}

	private Departamento instanciarDepartamento(ResultSet rs) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setCodigo(rs.getInt("b.Codigo"));
		departamento.setNomeDepartamento(rs.getString("b.nomeDepartamento"));
		
		return departamento;
	}
	
	@Override
	//Na apostila o método é findAll
	public List<Vendedor> listarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conexao.prepareStatement("Select a.codigo, a.nomeVendedor, a.email, "
					+ "a.dataNascimento, a.salarioBase, a.tbDepartamentoCodigo, "
					+ "b.codigo, b.nomeDepartamento from tbVendedor a, tbDepartamento b "
					+ "WHERE (a.tbDepartamentoCodigo = b.codigo) "
					+ "Order by a.nomeVendedor");
			
			//O ResultSet tráz o resultado em forma de tabela
			rs = st.executeQuery();
			
			//testar se a consulta teve resultado
			//o resultado da consulta acima pode dar 0, 1 ou mais valores
			//por isto tenho que usar o while
			
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (rs.next()) {
				Departamento dep = map.get(rs.getInt("a.tbDepartamentoCodigo"));
				
				if (dep == null) {
					dep = instanciarDepartamento(rs);
					map.put(rs.getInt("a.tbDepartamentoCodigo"), dep);
				}
								
				Vendedor vendedor = instanciarVendedor(rs, dep);
				
				lista.add(vendedor);
			}
			return lista;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage()); 
		} finally {
			ConexaoDB.fecharStatement(st);
			ConexaoDB.fecharResultSet(rs);
		}
	}
	
	@Override
	//Na apostila está findByDepartamento
	public List<Vendedor> listarPorDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conexao.prepareStatement("Select a.codigo, a.nomeVendedor, a.email, "
					+ "a.dataNascimento, a.salarioBase, a.tbDepartamentoCodigo, "
					+ "b.codigo, b.nomeDepartamento from tbVendedor a, tbDepartamento b "
					+ "WHERE (a.tbDepartamentoCodigo = b.codigo) and "
					+ "(a.tbDepartamentoCodigo = ?) "
					+ "Order by b.nomeDepartamento");
			st.setInt(1, departamento.getCodigo());
			//O ResultSet tráz o resultado em forma de tabela
			rs = st.executeQuery();
			
			//testar se a consulta teve resultado
			//o resultado da consulta acima pode dar 0, 1 ou mais valores
			//por isto tenho que usar o while
			
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			
			while (rs.next()) {
				Departamento dep = map.get(rs.getInt("a.tbDepartamentoCodigo"));
				
				if (dep == null) {
					dep = instanciarDepartamento(rs);
					map.put(rs.getInt("a.tbDepartamentoCodigo"), dep);
				}
								
				Vendedor vendedor = instanciarVendedor(rs, dep);
				
				lista.add(vendedor);
			}
			return lista;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage()); 
		} finally {
			ConexaoDB.fecharStatement(st);
			ConexaoDB.fecharResultSet(rs);
		}
	}
	
	@Override
	public Vendedor buscarPorCodigo(Integer codigo) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conexao.prepareStatement("Select a.codigo, a.nomeVendedor, a.email, "
					+ "a.dataNascimento, a.salarioBase, a.tbDepartamentoCodigo, "
					+ "b.codigo, b.nomeDepartamento from tbVendedor a, tbDepartamento b "
					+ "WHERE (a.tbDepartamentoCodigo = b.codigo) and "
					+ "(a.codigo = ?)");
			st.setInt(1, codigo);
			//O ResultSet tráz o resultado em forma de tabela
			rs = st.executeQuery();
			
			//testar se a consulta teve resultado
			if (rs.next()) {
				Departamento departamento = instanciarDepartamento(rs);
				
				Vendedor vendedor = instanciarVendedor(rs, departamento);
				
				return vendedor;
			}
			return null;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage()); 
		} finally {
			ConexaoDB.fecharStatement(st);
			ConexaoDB.fecharResultSet(rs);
		}
	}
	
	
	@Override
	public void inserir(Vendedor vendedor) {

		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement(
					"INSERT INTO tbvendedor "
					+ "(nomeVendedor, email, dataNascimento, salarioBase, tbDepartamentoCodigo) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, vendedor.getNomeVendedor());
			st.setString(2, vendedor.getEmailVendedor());
			st.setDate(3, new java.sql.Date(vendedor.getDataNascimento().getTime()));
			st.setDouble(4, vendedor.getSalarioBase());
			st.setInt(5, vendedor.getDepartamento().getCodigo());
			
			int qtdeLinhas = st.executeUpdate();
			
			if (qtdeLinhas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					int codigoVendedor = rs.getInt(1);
					vendedor.setCodigo(codigoVendedor);
				}
				
				ConexaoDB.fecharResultSet(rs);
			} else { //caso não tem feito a inserção
				throw new DBException("Inserção não realizada.");
			}
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		} finally {
			ConexaoDB.fecharStatement(st);
		}
		
	}

	@Override
	public void alterar(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ExcluirPorCodigo(Integer codigo) {
		// TODO Auto-generated method stub
		
	}



}
