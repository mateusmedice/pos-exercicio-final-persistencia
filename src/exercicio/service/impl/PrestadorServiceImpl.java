package exercicio.service.impl;

import exercicio.dao.PrestadorDAO;
import exercicio.dao.impl.PrestadorDAOImpl;
import exercicio.model.Prestador;
import exercicio.service.PrestadorService;

public class PrestadorServiceImpl implements PrestadorService {

	private PrestadorDAO prestadorDAO;
	
	public PrestadorServiceImpl() {
		if (this.prestadorDAO == null) {
			this.prestadorDAO = new PrestadorDAOImpl();
		}
	}
	
	@Override
	public Prestador salvarPrestador(Prestador prestador) {

		return this.prestadorDAO.add(prestador);
	}

}
