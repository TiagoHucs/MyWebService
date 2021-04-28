import servicos.PessoaServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8085/AulaWebSevice/pessoas", new PessoaServiceImpl());
		System.out.println("Serviço publicado com sucesso");
	}

}