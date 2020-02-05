package devDojoJava8.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import devDojoJava8.interfaces.Genero;

public class Motorista {
	
	private String nome;
	private int idade;
	private Optional<Caminhao> caminhao;
	private Genero genero;
	
	public Motorista(String nome, Optional<Caminhao> caminhao) {
		this.nome = nome;
		this.setCaminhao(caminhao);
	}
	
	public Motorista(String nome, int idade) {
		this.nome = nome;
		this.idade= idade;
	}
	
	public Motorista(String nome, int idade, Genero genero) {
		this.nome = nome;
		this.idade= idade;
		this.genero = genero;
	}

	public Motorista() {
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
	
	public static List<Motorista> getBD(){
		return Arrays.asList(new Motorista("Douglas", 25), new Motorista("Geraldo", 55), new Motorista("Inez", 51), new Motorista("Igor", 24));
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return this.nome + " ";
	}
}
