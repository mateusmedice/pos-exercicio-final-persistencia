package exercicio.service.impl;

import java.util.Date;
import java.util.List;

import exercicio.dao.ConvenioDAO;
import exercicio.dao.impl.ConvenioDAOImpl;
import exercicio.model.Convenio;
import exercicio.model.Prestador;
import exercicio.model.dto.FaturamentoDTO;
import exercicio.service.ConvenioService;

public class ConvenioServiceImpl implements ConvenioService {

	private ConvenioDAO convenioDAO;
	
	public ConvenioServiceImpl() {
		if (this.convenioDAO == null) {
			this.convenioDAO = new ConvenioDAOImpl();
		}
	}
	
	@Override
	public List<FaturamentoDTO> calcularFaturamento(Date dataInicio, Date dataFim) {

		return this.convenioDAO.calcularFaturamentoPor(dataInicio, dataFim);
	}

	@Override
	public List<Prestador> obterPrestadoresPorConvenio(Long id) {

		return this.convenioDAO.obterPrestadoresPorConvenio(id);
	}

	@Override
	public Convenio salvarConvenio(Convenio convenio) {

		return this.convenioDAO.add(convenio);
	}

	@Override
	public List<Convenio> obterTodosConvenios() {

		return this.convenioDAO.getAll(Convenio.class);
	}

}
