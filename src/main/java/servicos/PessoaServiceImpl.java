package servicos;

import entidades.Pessoa;
import entidades.RetornoSoap;
import repositorios.PessoaFakeRepository;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(endpointInterface = "servicos.PessoaService")
public class PessoaServiceImpl implements PessoaService {

	PessoaFakeRepository repository = new PessoaFakeRepository();
	private static final Logger LOGGER = Logger.getLogger( PessoaServiceImpl.class.getName() );

	public RetornoSoap inserirPessoa(Pessoa pessoa) {

		try {
			repository.save(pessoa);
			LOGGER.log(Level.INFO,"Salvou a pessoa");
			return new RetornoSoap(0, "Sucesso");
		} catch (Exception e) {
			LOGGER.log(Level.WARNING,"Erro " + e.getMessage());
			return new RetornoSoap(1, "Erro: " + e);
		}
	}

	public RetornoSoap alterarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	public RetornoSoap removerPessoa(String cpf) {
		String msg = null;
		try {
			repository.delete(cpf);
			LOGGER.log(Level.INFO,"Removeu a pessoa");
			return new RetornoSoap(0, "Sucesso " + msg);
		} catch (Exception e) {
			LOGGER.log(Level.WARNING,"Erro " + e.getMessage());
			return new RetornoSoap(1, "Erro: " + e);
		}
	}

	public RetornoSoap recuperarTodos() {
		try {
			RetornoSoap retornoSoap = new RetornoSoap(0, "sucesso");
			retornoSoap.setPessoas(repository.findAll());
			LOGGER.log(Level.INFO,"Listou as pessoas");
			return retornoSoap;
		} catch (Exception e) {
			RetornoSoap retornoSoap = new RetornoSoap(1, "erro " + e);
			LOGGER.log(Level.WARNING,"Erro " + e.getMessage());
			return retornoSoap;
		}

	}

}
