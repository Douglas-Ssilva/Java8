package devDojoJava8.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

public class Motoristas {
	
	private HashMap<String, Optional<Motorista>> motoristas= new HashMap<>();

	public Motoristas() {
		Seguro seguro = new Seguro("Parcial", new BigDecimal(1000.0));
		Caminhao caminhao = new Caminhao("Mercedes", Optional.ofNullable(seguro));
		Optional<Motorista> motorista1 = Optional.ofNullable(new Motorista("Joao", Optional.ofNullable(caminhao)));
		Optional<Motorista> motorista2 = Optional.ofNullable(new Motorista("Jose", null));
		motoristas.put("Joao", motorista1);
		motoristas.put("Jose", motorista2);
	}
	
	public Optional<Motorista> getName(String nome) {
		return motoristas.get(nome);
	}
	
	

}
