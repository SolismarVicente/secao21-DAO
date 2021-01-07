package br.com.cursodejava.db;

public class DBIntegridadeReferencial extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DBIntegridadeReferencial(String msg) {
		//super(msg);
		System.out.println(msg);
	}
	

}
