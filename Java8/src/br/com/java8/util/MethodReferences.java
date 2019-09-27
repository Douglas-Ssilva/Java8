package br.com.java8.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import javax.swing.JOptionPane;

public class MethodReferences {

	public static void main(String[] args) {
		
		List<String> list3 = new ArrayList<>();
		List<String> list = new ArrayList<>();
		list.add("DevMedia");
		list.add("DevDojo");
		list.add("Alura");
		list.add("Algaworks");
		
//		Function de String que devolve um integer
		Function<String, Integer> function= new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		
		Comparator<String> comparator= Comparator.comparing(function);
		list.sort(comparator);
		
		list.forEach(name -> { if (!list3.contains(name)) list3.add(name);
			System.out.println(name);
		});
		JOptionPane.showMessageDialog(null, list3.size());
		
		
		list.sort(Comparator.comparing(s -> s.length()));
		list.sort(Comparator.comparing(String::length)); //Sintaxes equivalentes. É avaliado também como um lamba
		
		Function<String, Integer> function2= (String::length);
		

		list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
//		usando method reference
		list.forEach(System.out::println);
		list.forEach(s -> System.out.println(s)); //lamba
		
	}

}
