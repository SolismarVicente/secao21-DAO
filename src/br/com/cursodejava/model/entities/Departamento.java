package br.com.cursodejava.model.entities;

import java.io.Serializable;

//o implements Serializable é necessário quando quizermos que 
//nosso objeto seja gravado em arquivo ou trafegado em rede e etc.
public class Departamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String nomeDepartamento;
	
	public Departamento() {
		
	}

	public Departamento(Integer codigo, String nomeDepartamento) {
		this.codigo = codigo;
		this.nomeDepartamento = nomeDepartamento;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
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
		Departamento other = (Departamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nomeDepartamento=" + nomeDepartamento + "]";
	}

	
}
