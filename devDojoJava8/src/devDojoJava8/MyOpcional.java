package devDojoJava8;

import java.util.Optional;

public class MyOpcional {
	
	private String name;

	public static void main(String[] args) {
		
		MyOpcional myOpcional = new MyOpcional();
		Optional<String> optional= Optional.of(""); //Temos que obrigatoriamente ter um value
		Optional<String> optional1= Optional.of("DevDojo");
		Optional<String> optional2= Optional.empty();
		Optional<String> optional3= Optional.ofNullable(myOpcional.name); //Pode ou nao ser null
		
		System.out.println(optional);
		System.out.println(optional1);
		System.out.println(optional2);
		System.out.println(optional3);
		
		//getValue
		System.out.println(optional1.get());
		if (optional.isPresent()) {} //Verificando se há algo no opcional
		System.out.println(optional3.orElse("Retorno caso nao haja valor"));
		
		
		
		
	}

}
