package apirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Planeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@NotBlank
	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "clima")
	private String clima;

	@Column(name = "terreno")
	private String terreno;

	@Column(name = "numAparicoes")
	private Integer numAparicoes;

	// Construtor vazio
	public Planeta() {

	}

	// Construtor nome, clima, terreno
	public Planeta(String nome, String clima, String terreno) {
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}

	// Getters e Setters
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

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getNumAparicoes() {
		return numAparicoes;
	}

	public void setNumAparicoes(Integer numAparicoes) {
		this.numAparicoes = numAparicoes;
	}

	// toString
	@Override
	public String toString() {
		return "Planeta {id = " + getId() + ", nome = '" + getNome() + "'" + ", clima = '" + getClima() + "'"
				+ ", terreno = '" + getTerreno() + "'" + ", numeroAparicoes = '" + getNumAparicoes() + "'}";
	}
}
