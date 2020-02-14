package devDojoJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import devDojoJava8.interfaces.Genero;
import devDojoJava8.interfaces.Maioridade;
import devDojoJava8.model.Motorista;

public class AgrupandoStreams {

	public static void main(String[] args) {
		
		//Agrupamento de pessoas por sexo
		List<Motorista> motoristas = getMotoristas();
		List<Motorista> masc= new ArrayList<>();
		List<Motorista> femi= new ArrayList<>();
		Map<Genero, List<Motorista>> map= new HashMap<>();
		
		for (Motorista motorista : motoristas) {
			if(motorista.getGenero().equals(Genero.MASCULINO)) {
				masc.add(motorista);
			}else {
				femi.add(motorista);
			}
		}
		map.put(Genero.MASCULINO, masc);
		map.put(Genero.FEMININO, femi);
		System.out.println(map);
		
		//Com Java8
		Map<Genero, List<Motorista>> collect = motoristas.stream().collect(Collectors.groupingBy(Motorista::getGenero));
		System.out.println(collect); //{MASCULINO=[Geraldo , Igor , Douglas ], FEMININO=[Inez ]}
		//agrupando por Maioridade
		Map<Maioridade, List<Motorista>> collect2 = getMotoristas().stream().collect(Collectors.groupingBy(motorista -> {
			if(motorista.getIdade() < 18) return Maioridade.ADOLESCENTE;
			else return Maioridade.ADULTO;
		}));
		System.out.println(collect2); //{ADOLESCENTE=[Igor ], ADULTO=[Inez , Geraldo , Douglas ]}
		
		//agrupando por genero e maioridade
		Map<Genero, Map<Maioridade, List<Motorista>>> collect3 = getMotoristas().stream().collect(Collectors.groupingBy(Motorista::getGenero, Collectors.groupingBy( motorista -> {
			if(motorista.getIdade() < 18) return Maioridade.ADOLESCENTE;
			else return Maioridade.ADULTO;
		})));
		System.out.println(collect3); //{MASCULINO={ADOLESCENTE=[Igor ], ADULTO=[Geraldo , Douglas ]}, FEMININO={ADULTO=[Inez ]}}
		
//		Agrupando por genêro e quanidade
		Map<Genero, Long> collect4 = getMotoristas().stream().collect(Collectors.groupingBy(Motorista::getGenero, Collectors.counting()));
		System.out.println(collect4); //{MASCULINO=3, FEMININO=1}
		
//		Agrupando por genêro e maior salário
		Map<Genero, Optional<Motorista>> collect5 = getMotoristas().stream().collect(Collectors.groupingBy(Motorista::getGenero,
				Collectors.maxBy(Comparator.comparing(Motorista::getIdade))));
		System.out.println(collect5); //{MASCULINO=Optional[Geraldo ], FEMININO=Optional[Inez ]}
		
//		Nesse caso nao faz sentido termos o Optional pois quando nao tiver o valor, nao existirá chave
		Map<Genero, Motorista> collect6 = getMotoristas().stream().collect(Collectors.groupingBy(Motorista::getGenero,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Motorista::getIdade)), Optional::get)));
		System.out.println(collect6); //{MASCULINO=Geraldo , FEMININO=Inez }
		
//		Agrupando por genero e estatisticas
		Map<Genero, DoubleSummaryStatistics> collect7 = getMotoristas().stream().collect(Collectors.groupingBy(Motorista::getGenero, Collectors.summarizingDouble(Motorista::getIdade)));
		System.out.println(collect7); //{MASCULINO=DoubleSummaryStatistics{count=3, sum=88,000000, min=8,000000, average=29,333333, max=55,000000}, FEMININO=DoubleSummaryStatistics{count=1, sum=52,000000, min=52,000000, average=52,000000, max=52,000000}}
		
//		Agrupando por genero e maioridade de forma distinta
		Map<Genero, List<Maioridade>> collect8 = getMotoristas().stream().collect(Collectors.groupingBy(Motorista::getGenero, Collectors.mapping(m -> {
			if(m.getIdade() > 18) {
				return Maioridade.ADULTO;
			}
			return Maioridade.ADOLESCENTE;
		}, Collectors.toList())));
		System.out.println(collect8); //{MASCULINO=[ADULTO, ADOLESCENTE, ADULTO], FEMININO=[ADULTO]}
		
		Map<Genero, Set<Maioridade>> collect9 = getMotoristas().stream().collect(Collectors.groupingBy(Motorista::getGenero, Collectors.mapping(m -> {
			if(m.getIdade() > 18) {
				return Maioridade.ADULTO;
			}
			return Maioridade.ADOLESCENTE;
		}, Collectors.toSet())));
		System.out.println(collect9); //{MASCULINO=[ADOLESCENTE, ADULTO], FEMININO=[ADULTO]}
		
//		Other implementation List, mantem a ordem de inserção
		Map<Genero, Set<Maioridade>> collect10 = getMotoristas().stream().collect(Collectors.groupingBy(Motorista::getGenero, Collectors.mapping(m -> {
			if(m.getIdade() > 18) {
				return Maioridade.ADULTO;
			}
			return Maioridade.ADOLESCENTE;
		}, Collectors.toCollection(LinkedHashSet::new))));
		System.out.println(collect10); //{MASCULINO=[ADOLESCENTE, ADULTO], FEMININO=[ADULTO]}
		
		
		
	}
	
	public static List<Motorista> getMotoristas(){
		return Arrays.asList(new Motorista("Inez", 52, Genero.FEMININO), new Motorista("Geraldo", 55, Genero.MASCULINO)
				, new Motorista("Igor", 8, Genero.MASCULINO), new Motorista("Douglas", 25, Genero.MASCULINO));
	}

}
