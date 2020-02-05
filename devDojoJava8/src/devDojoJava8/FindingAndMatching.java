package devDojoJava8;

import java.util.Arrays;
import java.util.List;

public class FindingAndMatching {

	public static void main(String[] args) {
		List<String> nomes= Arrays.asList("Goku", "Kamissam�", "Gohan");
		System.out.println(nomes.stream().anyMatch(nome -> nome.equals("Gohan"))); //true
		
		System.out.println(nomes.stream().allMatch(nome -> nome.equals("Goku"))); // false, todos s�o goku? 
		System.out.println(nomes.stream().noneMatch(nome -> nome.equals("Nao existe"))); // true, se tiver uma ocorrencia return true
		nomes.stream().filter(nome -> nome.equals("Kamissam�")).findFirst().ifPresent(n -> System.out.print("Existe"));
//		.findFirst- return primeiro elemento
	}

}
