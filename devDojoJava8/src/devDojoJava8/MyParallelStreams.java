package devDojoJava8;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MyParallelStreams {
	
	public static void main(String[] args) {
		somaFor(10_000_000_000L); //Resultado: 5724 ms
//		somaStream(10_000_000); //Resultado: 664 ms
//		somaStreamParalelos(10_000_000); //Resultado: 4644 ms
//		somaStreamRangeClosed(10_000_000); //18 ms
		somaStreamRangeClosedParalelos(10_000_000_000L); //4089 ms
		System.out.println("N�mero de processadores que est�o sendo usados: " + Runtime.getRuntime().availableProcessors());
//		Mudando numeros de Threads, n�o muito recomendado
//		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12"); //qtde Threads
	}
	
//	Nesse caso o for n�o demora tanto pois ele foi pensado p trabalhar em nivel baixo, n�o h� boxing nem unboxing das vari�veis
//	Ent�o nesses casos o for sempre ser� uma boa pedida
	public static void somaFor(long number) {
		long result= 0;
		long inicio = System.currentTimeMillis();
		for (long i = 1L; i <= number; i++) {
			result+= i;
		}
		long fim = System.currentTimeMillis();
		System.out.println("Resultado: " + result + " " + (fim - inicio) + " ms" );
	}
	
//	Nesse caso h� boxing e autoboxing, por isso a demora bem maior
	public static void somaStream(long number) {
		System.out.println("Stream sequencial");
		long result= 0;
		long inicio = System.currentTimeMillis();
		result += Stream.iterate(1L, n -> n + 1).limit(number).reduce(0L, Long::sum);
		long fim = System.currentTimeMillis();
		System.out.println("Resultado: " + result + " " + (fim - inicio) + " ms" );
	}
	
	
//	Trabalhar com Streams paralelos nada mais � que de uma lista de numeros, eu dividir parte dela p Thread A somar, e a outra parte
//	ser� de responsabilidade da Thread B
//	Devido ao boxing tbm n�o � o melhor a se usar, e tbm devido a n�o saber o inicio e o fim exato, pois vai somando a cada loop
	public static void somaStreamParalelos(long number) {
		System.out.println("Stream paralelos");
		long result= 0;
		long inicio = System.currentTimeMillis();
		result += Stream.iterate(1L, n -> n + 1).limit(number).parallel().reduce(0L, Long::sum);
		long fim = System.currentTimeMillis();
		System.out.println("Resultado: " + result + " " + (fim - inicio) + " ms" );
	}
	
	public static void somaStreamRangeClosed(long number) {
		System.out.println("Stream sequencial range closed");
		long result= 0;
		long inicio = System.currentTimeMillis();
		result += LongStream.rangeClosed(1L, number).reduce(0L, Long::sum); //Faz a defini��o dos numeros na cria��o, a inves de iterar um a um
		long fim = System.currentTimeMillis();
		System.out.println("Resultado: " + result + " " + (fim - inicio) + " ms" );
	}
	
	public static void somaStreamRangeClosedParalelos(long number) {
		System.out.println("Stream paralelo range closed");
		long result= 0;
		long inicio = System.currentTimeMillis();
		result += LongStream.rangeClosed(1L, number).parallel().reduce(0L, Long::sum); 
		long fim = System.currentTimeMillis();
		System.out.println("Resultado: " + result + " " + (fim - inicio) + " ms" );
	}

}
