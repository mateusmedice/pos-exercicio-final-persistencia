package exercicio.service;

import exercicio.model.Beneficiario;

public interface BeneficiarioService {

	Beneficiario gerarAnamnase(Long id);
	
	Beneficiario save(Beneficiario beneficiario);

}
