package exercicio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="convenio")
public class Convenio implements Serializable {

	private static final long serialVersionUID = 400163867799941164L;

	@Id
	@GeneratedValue
	@Column(name="id_convenio")
	private Long id;

	@Column(name="nome")
	private String nome;

	@Column(name="telefone")
	private String telefone;

	@Column(name="valor_consulta")
	private Double valorConsulta;

	@Column(name="dt_ultimo_contrato")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimoContrato;
	
	@ManyToMany(mappedBy="convenios")
	private List<Prestador> prestadores = new ArrayList<Prestador>();

	@ManyToMany(mappedBy="convenios")
	private List<Beneficiario> beneficiarios = new ArrayList<Beneficiario>();
	
	public Convenio() {
		
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
	 * @return the valorConsulta
	 */
	public Double getValorConsulta() {
		return valorConsulta;
	}

	/**
	 * @param valorConsulta the valorConsulta to set
	 */
	public void setValorConsulta(Double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	/**
	 * @return the dataUltimoContrato
	 */
	public Date getDataUltimoContrato() {
		return dataUltimoContrato;
	}

	/**
	 * @param dataUltimoContrato the dataUltimoContrato to set
	 */
	public void setDataUltimoContrato(Date dataUltimoContrato) {
		this.dataUltimoContrato = dataUltimoContrato;
	}

	/**
	 * @return the prestadores
	 */
	public List<Prestador> getPrestadores() {
		return prestadores;
	}

	/**
	 * @param prestadores the prestadores to set
	 */
	public void setPrestadores(List<Prestador> prestadores) {
		this.prestadores = prestadores;
	}

	/**
	 * @return the beneficiarios
	 */
	public List<Beneficiario> getBeneficiarios() {
		return beneficiarios;
	}

	/**
	 * @param beneficiarios the beneficiarios to set
	 */
	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
	
}
