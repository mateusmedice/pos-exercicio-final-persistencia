package exercicio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="especialidade")
public class Especialidade implements Serializable {

	private static final long serialVersionUID = 3118741286833554255L;

	@Id
	@GeneratedValue
	@Column(name="id_especialidade")
	private Long id;
	
	@Column(name="descricao")
	private String descricao;
	
	@ManyToMany(mappedBy="especialidades")
	private List<Prestador> prestadores = new ArrayList<Prestador>();
	
	public Especialidade() {
		
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
}
