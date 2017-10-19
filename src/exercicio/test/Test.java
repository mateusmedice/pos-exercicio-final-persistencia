package exercicio.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import exercicio.model.Beneficiario;
import exercicio.model.Consulta;
import exercicio.model.Convenio;
import exercicio.model.Endereco;
import exercicio.model.Especialidade;
import exercicio.model.Prestador;
import exercicio.model.dto.FaturamentoDTO;
import exercicio.service.BeneficiarioService;
import exercicio.service.ConsultaService;
import exercicio.service.ConvenioService;
import exercicio.service.PrestadorService;
import exercicio.service.impl.BeneficiarioServiceImpl;
import exercicio.service.impl.ConsultaServiceImpl;
import exercicio.service.impl.ConvenioServiceImpl;
import exercicio.service.impl.PrestadorServiceImpl;
import exercicio.util.DateUtil;

public class Test {
	
	private BeneficiarioService beneficiarioService;
	
	private ConsultaService consultaService;
	
	private ConvenioService convenioService;

	private PrestadorService prestadorService;
	
	public Test() {
		
		if (this.beneficiarioService == null) {
			this.beneficiarioService = new BeneficiarioServiceImpl();
		}
		
		if (this.consultaService == null) {
			this.consultaService = new ConsultaServiceImpl();
		}
		
		if (this.convenioService == null) {
			this.convenioService = new ConvenioServiceImpl();
		}
		
		if (this.prestadorService == null) {
			this.prestadorService = new PrestadorServiceImpl();
		}
		
	}

	public void process() {
		
		Beneficiario beneficiarioSaved = createBeneficiario();
		
		Prestador prestadorSaved = createPrestador(beneficiarioSaved);
		
		Beneficiario beneficiario = this.beneficiarioService.gerarAnamnase(beneficiarioSaved.getId());
		
		System.out.println(" ****************** Anamnese ****************** ");
		
		System.out.println("Anamnese: " + beneficiario.getNome());
		
		for (Consulta consulta : beneficiario.getConsultas()) {
			System.out.println("ID: " + consulta.getId());
			System.out.println("DATA: " + DateUtil.format(consulta.getDataConsulta(), DateUtil.FORMAT_DD_MM_YYYY));
			System.out.println("Relatorio: " + consulta.getId());
			System.out.println("--");
		}

		Calendar dataInicial = Calendar.getInstance();
		dataInicial.set(Calendar.DAY_OF_MONTH, 1);
		dataInicial.set(Calendar.MONTH, 4);
		dataInicial.set(Calendar.YEAR, 2014);
		
		Calendar dataFinal = Calendar.getInstance();
		dataFinal.set(Calendar.DAY_OF_MONTH, 25);
		dataFinal.set(Calendar.MONTH, 4);
		dataFinal.set(Calendar.YEAR, 2014);
		
		List<FaturamentoDTO> faturamentoList = 
			this.convenioService.calcularFaturamento(dataInicial.getTime(), dataFinal.getTime());
		
		System.out.println(" ****************** Faturamento Por Convenio ****************** ");
		
		for (FaturamentoDTO faturamentoDTO : faturamentoList) {
			System.out.println("Convenio: " + faturamentoDTO.getConvenio());
			System.out.println("Faturamento: " + faturamentoDTO.getFaturamento());
			System.out.println("--");
		}
		
		List<Convenio> listaConvenios = this.convenioService.obterTodosConvenios();

		System.out.println(" ****************** Prestadores por convenio ****************** ");
		
		for (Convenio convenio : listaConvenios) {
			
			System.out.println("Convenio: " + convenio.getNome());
			
			List<Prestador> prestadores = this.convenioService.obterPrestadoresPorConvenio(1L);
			
			for (Prestador prestador : prestadores) {
				System.out.println("Nome: " + prestador.getNome());
				System.out.println("--");
			}
		}

		System.out.println(" ****************** Quantidade de Consultas por convenio ****************** ");
		
		for (Convenio convenio : listaConvenios) {

			System.out.println("Convenio: " + convenio.getNome());
			
			Integer quantidade = this.consultaService.obterQuantidadeConsultaPor(convenio.getId(), dataInicial.getTime(), dataFinal.getTime());

			System.out.println("Quantidade: " + quantidade);
		}
		
	}
	
	private Beneficiario createBeneficiario() {
		
		Beneficiario beneficiario = new Beneficiario();
		
		beneficiario.setDataNascimento(new Date());
		beneficiario.setNome("Teste 1");
		beneficiario.setRg("123456789");
		beneficiario.setTelefone("11-965125432");
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Santa Cecilia");
		endereco.setCidade("São Paulo");
		endereco.setComplemento("A23");
		endereco.setEstado("SP");
		endereco.setNumero("123");
		endereco.setRua("Rua Das Cantareiras");
		
		beneficiario.setEndereco(endereco);
		
		Consulta consulta = new Consulta();
		
		consulta.setDataConsulta(new Date());
		consulta.setRelatorio("Relatório dado pelo médico...");

		beneficiario.getConsultas().add(consulta);
		beneficiario.getConsultas().add(consulta);
		beneficiario.getConsultas().add(consulta);
		beneficiario.getConsultas().add(consulta);
		beneficiario.getConsultas().add(consulta);
		beneficiario.getConsultas().add(consulta);
		beneficiario.getConsultas().add(consulta);
		beneficiario.getConsultas().add(consulta);
		beneficiario.getConsultas().add(consulta);

		return this.beneficiarioService.save(beneficiario);
	}
	
	private Prestador createPrestador(Beneficiario beneficiario) {
		
		Prestador prestador = new Prestador();
		
		prestador.setCrm("123123");
		prestador.setNome("Prestador 1");
		
		Convenio convenio = new Convenio();
		
		convenio.setDataUltimoContrato(new Date());
		convenio.setNome("Convenio 1");
		convenio.setTelefone("11-36089795");
		convenio.setValorConsulta(350.6);
		
		convenio.getBeneficiarios().add(beneficiario);

		prestador.getConvenios().add(convenio);
		
		Especialidade especialidade = new Especialidade();
		especialidade.setDescricao("Especialidade 1");
		
		prestador.getEspecialidades().add(especialidade);
		
		return this.prestadorService.salvarPrestador(prestador);
	}
	
	public static void main(String[] args) {
		
		Test test = new Test();
		
		test.process();
	
		System.exit(0);
	}
	
}
