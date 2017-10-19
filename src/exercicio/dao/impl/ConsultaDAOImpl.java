package exercicio.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import exercicio.dao.ConsultaDAO;
import exercicio.model.Consulta;

public class ConsultaDAOImpl extends DAOImpl<Consulta, Integer> implements ConsultaDAO {

	@Override
	public Integer obterQuantidadeConsultaPor(Long idConvenio, Date dataInicial, Date dataFinal) {

		Criteria criteria = createCriteria(Consulta.class);

		criteria.createAlias("beneficiario", "beneficiario");
		criteria.createAlias("beneficiario.convenios", "convenios");
				
		criteria.add(Restrictions.eq("convenios.id", idConvenio));
		criteria.add(Restrictions.between("dataConsulta", dataInicial, dataFinal));
		
		criteria.setProjection(Projections.projectionList()
				.add(Projections.rowCount()));
		
		return ((Long) criteria.list().get(0)).intValue();
	}

}
