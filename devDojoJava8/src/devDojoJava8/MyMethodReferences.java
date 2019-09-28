package devDojoJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import devDojoJava8.interfaces.PredicateCar;
import devDojoJava8.interfaces.predicates.PredicateColor;

public class MyMethodReferences {

	public static void main(String[] args) {
		List<String> listInteger = Arrays.asList("1","2","3","4");
		List<String> list = new ArrayList<>();
		list.add("DevMedia");
		list.add("DevDojo");
		list.add("Alura");
		list.add("Algaworks");
		
		list.forEach(System.out::println);
		list.sort(Comparator.comparing(String::length));
		list.sort(String::compareTo);
		list.sort((s, e) -> s.compareTo(e));
		list.forEach(System.out::println);
		
		Function<String, Integer> function= Integer::parseInt;
		Function<String, Integer> function2= (e) -> Integer.parseInt(e);
//		Predicate tem o methodo test porem so recebe um param
		BiPredicate<List<String>, String> biPredicate= List<String>::contains; 
		BiPredicate<List<String>, String> biPredicate2= (list22, e) -> list22.contains(e); 
		System.out.println(function.apply("4"));
		System.out.println(biPredicate.test(list, "Alura"));
		
		Supplier<PredicateCar> supplier= PredicateColor::new;
		supplier.get(); //Retorna o objeto
		
		
		BiFunction<String, Integer, Car> biFunction= (nome, ano) -> new Car(nome, ano);
		BiFunction<String, Integer, Car> biFunction2= Car::new;
	}
	
	
	
	
	
	
	
	

}
