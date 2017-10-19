package exercicio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "prestador")
public class Prestador implements Serializable {

	private static final long serialVersionUID = -8042004982985594790L;

	@Id
	@GeneratedValue
	@Column(name = "id_prestador")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "crm")
	private String crm;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "prestador_especialidade", 
			   joinColumns = { @JoinColumn(name = "id_prestador") }, 
			   inverseJoinColumns = { @JoinColumn(name = "id_especialidade") })
	private List<Especialidade> especialidades = new ArrayList<Especialidade>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "prestador_convenio", 
			   joinColumns = { @JoinColumn(name = "id_prestador") }, 
			   inverseJoinColumns = { @JoinColumn(name = "id_convenio") })
	private List<Convenio> convenios = new ArrayList<Convenio>();

	public Prestador() {

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the crm
	 */
	public String getCrm() {
		return crm;
	}

	/**
	 * @param crm
	 *            the crm to set
	 */
	public void setCrm(String crm) {
		this.crm = crm;
	}

	/**
	 * @return the especialidades
	 */
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	/**
	 * @param especialidades
	 *            the especialidades to set
	 */
	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	/**
	 * @return the convenios
	 */
	public List<Convenio> getConvenios() {
		return convenios;
	}

	/**
	 * @param convenios
	 *            the convenios to set
	 */
	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}

}
