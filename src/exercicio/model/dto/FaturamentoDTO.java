package exercicio.model.dto;

import java.io.Serializable;

public class FaturamentoDTO implements Serializable {

	private String convenio;
	
	private Double faturamento;
	
	public FaturamentoDTO() {
		
	}

	/**
	 * @return the convenio
	 */
	public String getConvenio() {
		return convenio;
	}

	/**
	 * @param convenio the convenio to set
	 */
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	/**
	 * @return the faturamento
	 */
	public Double getFaturamento() {
		return faturamento;
	}

	/**
	 * @param faturamento the faturamento to set
	 */
	public void setFaturamento(Double faturamento) {
		this.faturamento = faturamento;
	}
	
}
