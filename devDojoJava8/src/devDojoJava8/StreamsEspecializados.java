package devDojoJava8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamsEspecializados {

	public static void main(String[] args) {
		//reduce é pegar um stream e transformar em um resultado final. Pegar a soma do salario de todas pessoas.
		List<Integer> numeros = Arrays.asList(1,2,3,6,4,8);
		Optional<Integer> returnOptionalNaoSabeSeTemValorList = numeros.stream().reduce((x,y) -> x + y);// soma 1 com 2, result com 3
		System.out.println(returnOptionalNaoSabeSeTemValorList.get());
		
		numeros = Arrays.asList(1,2,3,6,4,8);
		Optional<Integer> reduce = numeros.stream().reduce(Integer::sum);
		System.out.println(reduce.get());
		
		List<Integer> numeros1 = Arrays.asList(1,2,3,6,4,8);
		Integer number = numeros.stream().reduce(0, (x, y) -> x + y);
		System.out.println(number);
		
		Optional<Integer> reduce2 = getNumbers().reduce((x, y) -> x * y); //(1,(x, y) -> x * y) return number
		System.out.println(reduce2.get());
		
		Optional<Integer> max = getNumbers().reduce(Integer::max);
		System.out.println(max.get());
		
//		Optional<Double> salario= pessoas.stream().filter(p -> p.getSalario > 1000).map(p -> p.getSalario ).reduce(Double::sum);
//		Double valor= pessoas.stream().filter(p -> p.getSalario > 1000).mapToDouble(p -> p.getSalario ).sum();
//		DoubleStream db= pessoas.stream().filter(p -> p.getSalario > 1000).mapToDouble(p -> p.getSalario );
//		StreamDouble db2= db.boxed();
	}
	
	private static Stream<Integer> getNumbers(){
		return Arrays.asList(1,2,3,6,4,8).stream();
	}

}
