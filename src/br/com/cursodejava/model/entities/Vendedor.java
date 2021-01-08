package br.com.cursodejava.model.entities;

import java.io.Serializable;
import java.util.Date;

public class Vendedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String nomeVendedor;
	private String emailVendedor;
	private Date dataNascimento;
	private Double salarioBase;
	
	private Departamento departamento;
	
	public Vendedor() {
		
	}

	public Vendedor(Integer codigo, String nomeVendedor, String emailVendedor, Date dataNascimento, Double salarioBase,
			Departamento departamento) {
		this.codigo = codigo;
		this.nomeVendedor = nomeVendedor;
		this.emailVendedor = emailVendedor;
		this.dataNascimento = dataNascimento;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public String getEmailVendedor() {
		return emailVendedor;
	}

	public void setEmailVendedor(String emailVendedor) {
		this.emailVendedor = emailVendedor;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vendedor [codigo=" + codigo + ", nomeVendedor=" + nomeVendedor + ", emailVendedor=" + emailVendedor
				+ ", dataNascimento=" + dataNascimento + ", salarioBase=" + salarioBase + ", departamento="
				+ departamento + "]";
	}
	
	
}
