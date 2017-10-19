package exercicio.service;

import java.util.Date;
import java.util.List;

import exercicio.model.Convenio;
import exercicio.model.Prestador;
import exercicio.model.dto.FaturamentoDTO;

public interface ConvenioService {

	List<FaturamentoDTO> calcularFaturamento(Date dataInicio, Date dataFim);
	
	List<Prestador> obterPrestadoresPorConvenio(Long id);
	
	Convenio salvarConvenio(Convenio convenio);
	
	List<Convenio> obterTodosConvenios();
}
