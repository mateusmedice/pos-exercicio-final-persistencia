/**
 * 
 */
package exercicio.dao;

import java.util.Date;

import exercicio.model.Consulta;

/**
 * @author mateus.medice
 *
 */
public interface ConsultaDAO extends DAO<Consulta, Integer> {

	Integer obterQuantidadeConsultaPor(Long idConvenio, Date dataInicial, Date dataFinal);
	
}
