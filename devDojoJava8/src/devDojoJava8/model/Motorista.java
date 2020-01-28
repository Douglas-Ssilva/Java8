package devDojoJava8.model;

import java.util.Optional;

public class Motorista {
	
	private String nome;
	private int idade;
	private Optional<Caminhao> caminhao;
	
	public Motorista(String nome, Optional<Caminhao> caminhao) {
		this.nome = nome;
		this.setCaminhao(caminhao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Optional<Caminhao> getCaminhao() {
		return caminhao;
	}

	public void setCaminhao(Optional<Caminhao> caminhao) {
		this.caminhao = caminhao;
	}
}
