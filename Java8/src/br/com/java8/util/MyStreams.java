package br.com.java8.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.java8.model.Person;

public class MyStreams {

	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<>();
		list.add(new Person("DevDojo", 30));
		list.add(new Person("DevMedia", 10));
		list.add(new Person("Alura", 20));
		
//		list.sort(Comparator.comparing(Person::getIdade));
//		list.forEach(System.out::println); //Com method reference nao consiguimos imprimir o nome, visto que com ele temos algumas limitações
//		list.forEach(c -> System.out.println(c.getName()));
		
		//filtrando dentro das collections. Tudo que é feito no stream nao impacta na lista que originou o stream
		list.stream()//Devolve um fluxo de objetos
		.filter(c -> c.getIdade() > 10) //Em comparação nao consigo usar o method references
		.map(c -> c.getIdade()) //Mapeando o stream de curso p alguma outra coisa, uma sequencia de numeros nesse caso
		.forEach(System.out::println); //imprimindo os numeros
//	    .forEach(System.out::println);
		
		int sum = list.stream()
		.filter(c -> c.getIdade() > 10)
		.mapToInt(Person::getIdade)
		.sum();
		
		System.out.println(sum);
		//Me devolva qualquer pessoa com base nesse filtro
		//Opcional nos permite trabalhar de forma mais legivel sem termos que usar sempre o null
		Optional<Person> optionalCurso = list.stream().filter(curso -> curso.getIdade() > 10).findAny();
//		optionalCurso.get(); me de um curso que está ai dentro, se nao houver tomo um NoSuchElement
		Person person = optionalCurso.orElse(null);//se nao tiver curso, me devolva null
		System.out.println(person); //Devolve qualquer um que encontrou
		
		optionalCurso.ifPresent(c -> System.out.println(c.getName())); //Se existir esse curso, imprima o nome
		
		//fazendo a união
		list.stream().filter(curso -> curso.getIdade() > 10).findAny().ifPresent(c -> System.out.println(c.getName()));
		
		//guardando o filtro em uma list
		List<Person> collect = list.stream().filter(c -> c.getIdade() > 20).collect(Collectors.toList());
		System.out.println(collect);
		
		list.stream().filter(c -> c.getIdade() > 20).collect(Collectors.toMap(c -> c.getName(), c -> c.getIdade())).
		forEach((nome, idade) -> System.out.println(nome + " tem " + idade + " anos" ));
		
		List<Integer> numbers3= new LinkedList<>();
		List<Integer> numbers2= Arrays.asList(30,152);
		List<Integer> numbers = list.stream().map(Person::getIdade).collect(Collectors.toList());
		System.out.println(numbers);
		
		//numbers.stream().filter(numero -> numero.equals(numbers2.forEach(item -> item))).mapToInt(mapper);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
