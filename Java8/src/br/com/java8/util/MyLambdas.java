package br.com.java8.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import br.com.java8.model.Person;

public class MyLambdas {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("DevMedia");
		list.add("DevDojo");
		list.add("Alura");
		list.add("Algaworks");

//		Podemos usar a sintaxe de class anonima quando a interface possui apenas um method. Usamos quando nao vamos reaproveitar em demais lugares
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});

//		Como o foreach recebe consumer e possui apenas um method, podemos fazer isso: 
		list.forEach((String s) -> {
			System.out.println(s);
		});

//		Como esse lambda recebe apenas um argumento, nao precisamos colocar os parenteses nem o tipo, ele consegue inferir
//		Se só possuir um comando, podemos tirar o ; e as chaves
		list.forEach(s -> {
			System.out.println(s);
		});

//		Se só possuir um comando, podemos tirar o ; e as chaves
		list.forEach(s -> System.out.println(s));

		list.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length())
					return -1;
				if (s1.length() > s2.length())
					return 1;
				return 0;
			}
		});

		list.sort((s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});

		list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		byte idade = 24;
		Person person = new Person("Douglas", idade);
		Person person2 = new Person("Inez", idade);
		Person person3 = new Person("Geraldo", idade);
		Person person4 = new Person("Igor", idade);

		List<Person> list2 = Arrays.asList(person, person2, person3, person4);

		list2.forEach(p -> System.out.println(p));

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Execute Runnable");
			}
		}).start();

		new Thread(() -> System.out.println("Execute Runnable")).start();

	}

}
