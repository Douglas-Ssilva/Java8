package devDojoJava8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import devDojoJava8.model.Motorista;

public class StreamCollectorsReducaoSumarizacao {

	public static void main(String[] args) {
		List<Motorista> motoristas = getMotoristas();
		motoristas.stream().count();
		Long qtde = motoristas.stream().collect(Collectors.counting());
		
		motoristas.stream().max(Comparator.comparing(Motorista::getIdade));
		System.out.println(motoristas.stream().collect(Collectors.maxBy(Comparator.comparing(Motorista::getIdade))).get().getNome());
		
		motoristas.stream().mapToInt(Motorista::getIdade).sum();
		Integer collect = motoristas.stream().collect(Collectors.summingInt(Motorista::getIdade));
		System.out.println(collect);
		
		IntSummaryStatistics collect2 = motoristas.stream().collect(Collectors.summarizingInt(Motorista::getIdade));
		System.out.println(collect2); //IntSummaryStatistics{count=4, sum=156, min=24, average=39,000000, max=55}
		
		String collect3 = motoristas.stream().map(Motorista::getNome).collect(Collectors.joining(","));
		System.out.println(collect3);
		
	}
	
	public static List<Motorista> getMotoristas(){
		return Arrays.asList(new Motorista("Inez", 52), new Motorista("Geraldo", 55), new Motorista("Igor", 24), new Motorista("Douglas", 25));
	}

}
