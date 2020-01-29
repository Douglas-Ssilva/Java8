package devDojoJava8;

import java.math.BigDecimal;
import java.util.Optional;

import devDojoJava8.model.Caminhao;
import devDojoJava8.model.Motorista;
import devDojoJava8.model.Motoristas;
import devDojoJava8.model.Seguro;

public class MyOpcional {
	
	private String name;

	public static void main(String[] args) {
		
		MyOpcional myOpcional = new MyOpcional();
		Optional<String> optional= Optional.of(""); //Temos que obrigatoriamente ter um value. Caso passe null da NullPointer
		Optional<String> optional1= Optional.of("DevDojo");
		Optional<String> optional2= Optional.empty();
		Optional<String> optional3= Optional.ofNullable(myOpcional.name); //Pode ou  nao ser null
		
		System.out.println(optional);  //Optional[]
		System.out.println(optional1); //Optional[DevDojo]
		System.out.println(optional2); //Optional.empty
		System.out.println(optional3); //Optional.empty
		
		System.out.println(optional1.get()); //DevDojo
		System.out.println(optional3.orElse("Retorno caso nao haja valor")); //Retorno caso nao haja valor
		if (optional.isPresent()) {} //Verificando se há algo no opcional
		
		//Algaworks
		Motoristas motoristas= new Motoristas();
//		Motorista motorista = motoristas.getName("Jose");
//		
//		String cobertura= "Sem cobertura";
//		if(motorista != null) {
//			Caminhao caminhao = motorista.getCaminhao();
//			if (caminhao != null) {
//				Seguro seguro = caminhao.getSeguro();
//				if(seguro != null) {
//					cobertura= seguro.getCobertura();
//				}
//			}
//		}
//		System.out.println(cobertura);
		
		Optional<Motorista> motoristaOptional = motoristas.getName("Joao");
//		Optional<Optional<Caminhao>> map = motoristaOptional.map(Motorista::getCaminhao); Devolve um Optional de Optional, pois o attr é desse tipo
//		assim usamos o flatMap
		String cobertura = motoristaOptional.flatMap(Motorista::getCaminhao).flatMap(Caminhao::getSeguro).map(Seguro::getCobertura).orElse(null);//cobertura é do tipo String 

		
		
		//Optional é uma caixa de alguma coisa que pode estar vazia
		Seguro seguro = new Seguro("Parcial", null);
		Optional<Seguro> seguroOptional = Optional.ofNullable(seguro);
		
		BigDecimal valorFranquia = seguroOptional.map(Seguro::getValorFranquia).orElse(null);
		System.out.println(valorFranquia);
		
		
		
		
	}
	
	//usando filtros
	public static String obterNomeSeguradoraIdade(Motorista pessoa, int idadeMinima) {
		return Optional.ofNullable(pessoa).filter(p -> p.getIdade() > idadeMinima)
				.flatMap(Motorista::getCaminhao)
				.flatMap(Caminhao::getSeguro)
				.map(Seguro::getCobertura).orElse("Não existe seguro");
	}
	
	public static void verificarNomesIguais(String nome) {
		Optional.ofNullable(nome).filter(n -> n.equals("DevDojo")).ifPresent(x -> System.out.print("Nomes iguais"));
	}
//	Ainda que encontre algum objeto null, não tomarei nullPointer
//	public static String obterNomeSeguro(Optional<Motorista> motorista) {
//		return motorista.flatMap(Motorista::getCaminhao).flatMap(Caminhao::getSeguro).map(Seguro::getNome).orElse("Não existe seguradora");
//	}
	
//	Nem toda pessoa terá carro, então posso fazer isso: 
//	public static Optional<Caminhao> getCaminhao(Motorista motorista){
//		return Optional.ofNullable(motorista.getCaminhao());
//	}
	
}
