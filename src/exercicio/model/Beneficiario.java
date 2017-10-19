package exercicio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="beneficiario")
public class Beneficiario implements Serializable {

	private static final long serialVersionUID = -6566314096448555363L;

	@Id
	@GeneratedValue
	@Column(name="id_beneficiario")
	private Long id;

	@Column(name="nome")
	private String nome;

	@Column(name="telefone")
	private String telefone;

	@Column(name="rg")
	private String rg; 

	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;

	@Column(name="dt_nascimento")
	private Date dataNascimento;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "beneficiario_convenio", 
			   joinColumns = { @JoinColumn(name = "id_beneficiario") }, 
			   inverseJoinColumns = { @JoinColumn(name = "id_convenio") })
	private List<Convenio> convenios = new ArrayList<Convenio>();

	@OneToMany(mappedBy="beneficiario", cascade = CascadeType.ALL)
	private List<Consulta> consultas = new ArrayList<Consulta>();
	
	public Beneficiario() {
		
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the consultas
	 */
	public List<Consulta> getConsultas() {
		return consultas;
	}

	/**
	 * @param consultas the consultas to set
	 */
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	/**
	 * @return the convenios
	 */
	public List<Convenio> getConvenios() {
		return convenios;
	}

	/**
	 * @param convenios the convenios to set
	 */
	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}
	
}
