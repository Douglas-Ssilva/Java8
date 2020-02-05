package devDojoJava8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import devDojoJava8.model.Motorista;

public class MyStreams {
	
	public static void main(String[] args) {
		
		List<Motorista> motoristas = Motorista.getBD();
		List<String> motoristasFilter = motoristas.stream().filter(p -> p.getIdade() < 25).sorted(Comparator.comparing(Motorista::getNome))
			.limit(1).map(Motorista::getNome).collect(Collectors.toList());
//		.distinct();
//		.count();
//		.limit()
//		.skip(2) pulará os 2 primeiros resultados
		
		motoristasFilter.forEach(System.out::println);
	}
//	Aula 187: Java 8 Streams pt 03, map e flatmap

}
