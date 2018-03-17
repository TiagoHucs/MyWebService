package servicos;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import entidades.Pessoa;
import entidades.RetornoSoap;

@WebService
@SOAPBinding(style = Style.RPC)
public interface PessoaService {
	
	@WebMethod
	public RetornoSoap inserirPessoa(Pessoa pessoa);
	@WebMethod
	public RetornoSoap alterarPessoa(Pessoa pessoa);
	@WebMethod
	public RetornoSoap removerPessoa(String cpf);
	@WebMethod
	public RetornoSoap recuperarPessoa(String cpf);
	@WebMethod
	public RetornoSoap pesquisarPessoa(Pessoa pessoa);
	@WebMethod
	public RetornoSoap recuperarTodos();

}
