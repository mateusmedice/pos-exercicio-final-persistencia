/**
 * 
 */
package exercicio.dao;

import java.util.Date;
import java.util.List;

import exercicio.model.Convenio;
import exercicio.model.Prestador;
import exercicio.model.dto.FaturamentoDTO;

/**
 * @author mateus.medice
 *
 */
public interface ConvenioDAO extends DAO<Convenio, Integer> {
	
	List<FaturamentoDTO> calcularFaturamentoPor(Date dataInicio, Date dataFim);
	
	List<Prestador> obterPrestadoresPorConvenio(Long id);
}
