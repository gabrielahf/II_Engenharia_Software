package serializacao.dados;

import java.io.Serializable;

public class Pessoa implements Serializable {
	private String nome;
	private Endereco endereco;

	public Pessoa(String nome, Endereco endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		String aux = "";
		aux += "Nome: " + nome + "\n";
		aux += "Endereco: " + "\n";
		aux += endereco.toString() + "\n";
		return aux;
	}

}