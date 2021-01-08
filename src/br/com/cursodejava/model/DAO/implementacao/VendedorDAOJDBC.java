package br.com.cursodejava.model.DAO.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
	
	@Override
	public void inserir(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ExcluirPorCodigo(Integer codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor buscarPorCodigo(Integer codigo) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conexao.prepareStatement("Select a.codigo, a.NomeVendedor, a.Email, "
					+ "a.DataNascimento, a.SalarioBase, a.DepartamentoCodigo, "
					+ "b.codigo, b.NomeDepartamento from vendedor a, departamento b "
					+ "WHERE (a.DepartamentoCodigo = b.codigo) and "
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

	private Vendedor instanciarVendedor(ResultSet rs, Departamento departamento) throws SQLException {
		Vendedor vendedor = new Vendedor();
		vendedor.setCodigo(rs.getInt("a.Codigo"));
		vendedor.setNomeVendedor(rs.getString("a.NomeVendedor"));
		vendedor.setEmailVendedor(rs.getString("a.Email"));
		vendedor.setDataNascimento(rs.getDate("a.DataNascimento"));
		vendedor.setSalarioBase(rs.getDouble("a.SalarioBase"));
		vendedor.setDepartamento(departamento);
		
		return vendedor;
	}

	private Departamento instanciarDepartamento(ResultSet rs) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setCodigo(rs.getInt("b.Codigo"));
		departamento.setNomeDepartamento(rs.getString("b.NomeDepartamento"));
		
		return departamento;
	}

	@Override
	public List<Vendedor> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
