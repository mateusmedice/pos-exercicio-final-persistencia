package exercicio.service;

import java.util.Date;

public interface ConsultaService {
	
	Integer obterQuantidadeConsultaPor(Long idConvenio, Date dataInicial, Date dataFinal);
	
}
