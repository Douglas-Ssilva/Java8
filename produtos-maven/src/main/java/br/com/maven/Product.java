package br.com.maven;

public class Product {
	
	private final String nome;
	private final String cpf;
	
	public Product(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void embaralharCpf() {
		this.cpf.replace("1", "0");
	}
}
