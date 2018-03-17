package entidades;

import java.util.ArrayList;

public class RetornoSoap {

	private int codRetorno;
	private String textoRetorno;
	private double valorRetorno;
	private ArrayList<Pessoa> pessoas;

	public RetornoSoap(int codRetorno, String textoRetorno) {
		this.codRetorno = codRetorno;
		this.textoRetorno = textoRetorno;
	}


	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}


	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}


	public int getCodRetorno() {
		return codRetorno;
	}

	public void setCodRetorno(int codRetorno) {
		this.codRetorno = codRetorno;
	}

	public String getTextoRetorno() {
		return textoRetorno;
	}

	public void setTextoRetorno(String textoRetorno) {
		this.textoRetorno = textoRetorno;
	}

	public double getValorRetorno() {
		return valorRetorno;
	}

	public void setValorRetorno(double valorRetorno) {
		this.valorRetorno = valorRetorno;
	}

}
