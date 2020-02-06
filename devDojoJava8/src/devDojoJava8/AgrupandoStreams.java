package devDojoJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	}
	
	public static List<Motorista> getMotoristas(){
		return Arrays.asList(new Motorista("Inez", 52, Genero.FEMININO), new Motorista("Geraldo", 55, Genero.MASCULINO)
				, new Motorista("Igor", 8, Genero.MASCULINO), new Motorista("Douglas", 25, Genero.MASCULINO));
	}

}
