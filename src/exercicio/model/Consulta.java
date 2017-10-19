package exercicio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="consulta")
public class Consulta implements Serializable {

	private static final long serialVersionUID = -5880584323927146507L;

	@Id
	@GeneratedValue
	@Column(name="id_consulta")
	private Long id;

	@Column(name="data_consulta")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataConsulta;
	
	@Column(name="relatorio")
	private String relatorio;
	
	@ManyToOne
	@JoinColumn(name="id_beneficiario")
	private Beneficiario beneficiario;
	
	public Consulta() {
		
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
	 * @return the dataConsulta
	 */
	public Date getDataConsulta() {
		return dataConsulta;
	}

	/**
	 * @param dataConsulta the dataConsulta to set
	 */
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	/**
	 * @return the relatorio
	 */
	public String getRelatorio() {
		return relatorio;
	}

	/**
	 * @param relatorio the relatorio to set
	 */
	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	/**
	 * @return the beneficiario
	 */
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	/**
	 * @param beneficiario the beneficiario to set
	 */
	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	
}
