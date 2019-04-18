package br.com.calcard.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="propostas")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1310435204852644652L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@Column(name="CPF", nullable=false)
	private String cpf;

	@Column(name="IDADE", nullable=false)
	private Integer idade;
	
	@Column(name="SEXO", nullable=false)
	private char sexo;
	
	@Column(name="ESTADOCIVIL", nullable=false)
	private String estadoCivil;
	
	@Column(name="ESTADO", nullable=false)
	private String estado;
	
	@Column(name="DEPENDENTES", nullable=false)
	private Integer dependentes;

	@Column(name="RENDA", nullable=false)
	private double renda;
	
	@Column(name="RESULTADOANALISE")
	private String resultadoAnalise;
	
	@Column(name="LIMITE")
	private String limite;
	
	@Column(name="MOTIVO")
	private String motivo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getDependentes() {
		return dependentes;
	}

	public void setDependentes(Integer dependentes) {
		this.dependentes = dependentes;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public String getResultadoAnalise() {
		return resultadoAnalise;
	}

	public void setResultadoAnalise(String resultadoAnalise) {
		this.resultadoAnalise = resultadoAnalise;
	}

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dependentes == null) ? 0 : dependentes.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((limite == null) ? 0 : limite.hashCode());
		result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(renda);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((resultadoAnalise == null) ? 0 : resultadoAnalise.hashCode());
		result = prime * result + sexo;
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
		User other = (User) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dependentes == null) {
			if (other.dependentes != null)
				return false;
		} else if (!dependentes.equals(other.dependentes))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (estadoCivil == null) {
			if (other.estadoCivil != null)
				return false;
		} else if (!estadoCivil.equals(other.estadoCivil))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (limite == null) {
			if (other.limite != null)
				return false;
		} else if (!limite.equals(other.limite))
			return false;
		if (motivo == null) {
			if (other.motivo != null)
				return false;
		} else if (!motivo.equals(other.motivo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(renda) != Double.doubleToLongBits(other.renda))
			return false;
		if (resultadoAnalise == null) {
			if (other.resultadoAnalise != null)
				return false;
		} else if (!resultadoAnalise.equals(other.resultadoAnalise))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", sexo=" + sexo
				+ ", estadoCivil=" + estadoCivil + ", estado=" + estado + ", dependentes=" + dependentes + ", renda="
				+ renda + ", resultadoAnalise=" + resultadoAnalise + ", limite=" + limite + ", motivo=" + motivo + "]";
	}

	
	

}
