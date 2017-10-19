package exercicio.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import exercicio.dao.ConvenioDAO;
import exercicio.model.Convenio;
import exercicio.model.Prestador;
import exercicio.model.dto.FaturamentoDTO;

public class ConvenioDAOImpl extends DAOImpl<Convenio, Integer> implements ConvenioDAO {

	@Override
	public List<FaturamentoDTO> calcularFaturamentoPor(Date dataInicio, Date dataFim) {

		Criteria criteria = createCriteria(Convenio.class);
		
		criteria.add(Restrictions.between("dataUltimoContrato", dataInicio, dataFim));
		
		criteria.setProjection(Projections.projectionList()
				.add(Projections.sum("valorConsulta"), "faturamento")
				.add(Projections.groupProperty("nome"), "convenio"));
		
		criteria.setResultTransformer(Transformers.aliasToBean(FaturamentoDTO.class));
		
		return (List<FaturamentoDTO>) criteria.list();
	}

	@Override
	public List<Prestador> obterPrestadoresPorConvenio(Long id) {
		
		Criteria criteria = createCriteria(Prestador.class);
		
		criteria.createAlias("convenios", "convenios");
		
		criteria.add(Restrictions.eq("convenios.id", id));
		
		// criteria.setProjection(Projections.rowCount());
		
		return criteria.list();
	}
	
}
