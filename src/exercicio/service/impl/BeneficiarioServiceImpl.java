package exercicio.service.impl;

import exercicio.dao.BeneficiarioDAO;
import exercicio.dao.impl.BeneficiarioDAOImpl;
import exercicio.model.Beneficiario;
import exercicio.service.BeneficiarioService;

public class BeneficiarioServiceImpl implements BeneficiarioService {

	private BeneficiarioDAO beneficiarioDAO;
	
	public BeneficiarioServiceImpl() {
		if (this.beneficiarioDAO == null) {
			this.beneficiarioDAO = new BeneficiarioDAOImpl();
		}
	}

	@Override
	public Beneficiario gerarAnamnase(Long id) {

		if (id == null) {
			throw new IllegalArgumentException("ID cant be null.");
		}
		
		return this.beneficiarioDAO.getById(Beneficiario.class, id);
	}

	@Override
	public Beneficiario save(Beneficiario beneficiario) {
		
		if (beneficiario == null) {
			throw new IllegalArgumentException("Beneficiario cant be null.");
		}
		
		return this.beneficiarioDAO.add(beneficiario);
	}
	
}
