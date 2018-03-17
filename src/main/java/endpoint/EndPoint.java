package endpoint;

import javax.xml.ws.Endpoint;

import servicos.PessoaServiceImpl;
import datasource.ConexaoDB;

public class EndPoint {

	static ConexaoDB conexao = new ConexaoDB();
	
	public static void main(String[] args) {
		conexao.iniciaServidor();
		Endpoint.publish("http://localhost:8085/AulaWebSevice/pessoas", new PessoaServiceImpl());
		System.out.println("Serviço publicado com sucesso");
	}

}