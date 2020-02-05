package devDojoJava8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GerandoStreams {
	
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 20).filter(n -> n % 2 == 0).forEach(n -> System.out.println(n + " "));
		IntStream.range(1, 20).filter(n -> n % 2 == 0).forEach(n -> System.out.println(n + " ")); //Não é inclusivo
		
		Stream<String> stream = Stream.of("Goku", "Kuririm", "Gohan");
		stream.map(String::toUpperCase).forEach(nome -> System.out.println(nome));
		
		int num[]= {1,2,3};
		int sum = Arrays.stream(num).sum();
		
		try(Stream<String> lines= Files.lines(Paths.get("util.txt"), Charset.defaultCharset())){
			lines.flatMap(line -> Arrays.stream(line.split("\n")))
			.filter(p -> p.contains("File"))
			.forEach(System.out::println);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//Streams infinitos(Sequencia de fibonnaci(0,1,1,2,3,5,8))
		Stream.iterate(0, n -> n + 1).limit(20).forEach(System.out::println);  //faz a soma do numero 1 com o 2 infinitamente, por isso temos que usar o limit p parar o processamento
		//posição 2 é a soma dos dois, posição 1 é o valor em si (0,1) (1,1) (1,2) (2,3) (3,5) (5,8)
		Stream.iterate(new int[]{0,1}, a -> new int[]{ a[1], a[0] + a[1] }).limit(30).map( t -> t[0]).forEach(System.out::println); //1 args de entrada
		
		//Apenas gera os numeros de forma aleatoria
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
		
		ThreadLocalRandom t= ThreadLocalRandom.current();
		Stream.generate(() -> t.nextInt(1,1000)).forEach(System.out::println);
	}

}




















