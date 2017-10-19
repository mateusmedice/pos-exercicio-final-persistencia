package exercicio.service.impl;

import java.util.Date;

import exercicio.dao.ConsultaDAO;
import exercicio.dao.impl.ConsultaDAOImpl;
import exercicio.service.ConsultaService;

public class ConsultaServiceImpl implements ConsultaService {

	private ConsultaDAO consultaDAO;
	
	public ConsultaServiceImpl() {
		if (this.consultaDAO == null) {
			this.consultaDAO = new ConsultaDAOImpl();
		}
	}
	
	@Override
	public Integer obterQuantidadeConsultaPor(Long idConvenio,
			Date dataInicial, Date dataFinal) {

		return this.consultaDAO.obterQuantidadeConsultaPor(idConvenio, dataInicial, dataFinal);
	}

}
