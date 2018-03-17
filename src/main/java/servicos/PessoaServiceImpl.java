package servicos;

import hibernate.HibernateUtil;

import java.util.ArrayList;

import javax.jws.WebService;

import org.hibernate.SessionFactory;

import repositorios.PessoaDAOImpl;
import entidades.Pessoa;
import entidades.RetornoSoap;

@WebService(endpointInterface = "servicos.PessoaService")
public class PessoaServiceImpl implements PessoaService {

	ArrayList<Pessoa> repositorioPessoas = new ArrayList<Pessoa>();
	static HibernateUtil util = new HibernateUtil();
	SessionFactory sessionFactory = util.getSessionFactory();

	public RetornoSoap inserirPessoa(Pessoa pessoa) {

		try {
			PessoaDAOImpl dao = new PessoaDAOImpl(util.getSessionFactory());
			dao.salvar(pessoa);
			return new RetornoSoap(0, "Sucesso");
		} catch (Exception e) {
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
			for (Pessoa pessoa : repositorioPessoas) {
				if (pessoa.getCpf().equals(cpf)) {
					repositorioPessoas.remove(pessoa);
					msg = pessoa.getNome() + " removido";
				}
			}
			return new RetornoSoap(0, "Sucesso " + msg);
		} catch (Exception e) {
			return new RetornoSoap(1, "Erro: " + e);
		}
	}

	public RetornoSoap recuperarPessoa(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	public RetornoSoap pesquisarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	public RetornoSoap recuperarTodos() {
		try {
			PessoaDAOImpl dao = new PessoaDAOImpl(util.getSessionFactory());
			RetornoSoap retornoSoap = new RetornoSoap(0, "sucesso");
			retornoSoap.setPessoas((ArrayList<Pessoa>) dao.recuperarTodos());
			return retornoSoap;
		} catch (Exception e) {
			RetornoSoap retornoSoap = new RetornoSoap(1, "erro " + e);
			return retornoSoap;
		}

	}

}
