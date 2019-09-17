package br.com.java8.model;

public class Person {

	private String name;
	private byte idade;
	
	public Person(String name, byte idade) {
		this.name = name;
		this.idade = idade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getIdade() {
		return idade;
	}

	public void setIdade(byte idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", idade=" + idade + "]";
	}

}
