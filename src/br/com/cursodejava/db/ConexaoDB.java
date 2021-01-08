package br.com.cursodejava.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//conectar com o banco de dados no jdbc é instanciar um objeto do tipo Connection
public class ConexaoDB {
	
	private static Connection conexaoDB = null;
	
	//abrirConexao: na apostila está getConnection
	public static Connection abrirConexao() {
		if (conexaoDB == null) {
			try {
				Properties props = propriedadeConexao();
				String url = props.getProperty("dburl");
				conexaoDB = DriverManager.getConnection(url, props);
			} catch (SQLException erro) {
				throw new DBException(erro.getMessage());
			}
		}
		System.out.println("Conexão aberta com sucesso.");
		
		return conexaoDB;
	}
	
	public static void fecharConexao() {
		if (conexaoDB != null) {
			try {
				conexaoDB.close();
			} catch (SQLException erro) {
				throw new DBException(erro.getMessage());
			}
			
			System.out.println("Conexão fechada com sucesso.");
		}
	}
	
	private static Properties propriedadeConexao() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties propriedade = new Properties();
			propriedade.load(fs);
			
			return propriedade;
		} catch (IOException erro) {
			throw new DBException(erro.getMessage());
		}
	}
	
	public static void fecharStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException erro) {
				throw new DBException(erro.getMessage());
			}
		}
	}
	
	public static void fecharResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException erro) {
				throw new DBException(erro.getMessage());
			}
		}
	}

}
