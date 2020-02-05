package devDojoJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyFlat {

	public static void main(String[] args) {
		
//		Map aplica a função p cada elemento (Já tenho valores)
//		FlatMap quando tenho varios valores e quando quero achatar tudo em um só valor (Extrair)
		
		List<List<String>> nomes= new ArrayList<>();
		nomes.add(Arrays.asList("Teste", "Teste2"));
		nomes.add(Arrays.asList("Test4", "Teste3"));
		nomes.forEach(System.out::println); //[Teste, Teste2] [Test4, Teste3]
		List<String> collect = nomes.stream().flatMap(Collection::stream).collect(Collectors.toList());
		collect.forEach(System.out::println); //Teste Teste2	Test4 Teste3
		
		List<String> list= Arrays.asList("Goku", "Kuririm");
		String[] split = list.get(0).split("");
		System.out.println(Arrays.toString(split)); //[G, o, k, u]
		List<String> collect2 = list.stream().map(l -> l.split("u")) //Stream<String[]> 
				.flatMap(Arrays::stream) //Stream<String>
				.collect(Collectors.toList());
		
		System.out.println(collect2); //[Gok, K, ririm]

	}

}
