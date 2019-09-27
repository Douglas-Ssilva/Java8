package devDojoJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import devDojoJava8.interfaces.PredicateCar;

public class MyLambda {
	
	public static void main(String[] args) {
//		Lambdas(expressão) foi criado p acabar com a verbosidade do Java.
//		É anônima
//		É uma função, pois nao está associada a nenhuma class
//		Pode ser passada como args, ou guardar em variaveis
//		É concisa, resolvemos as coisas com uma linha
//		Partes da Lambda: params(opcional) / seta separador do corpo
//		(Car car) -> car.getNome().equals('');
//		Podemos ter mais de um param
//		Quando podemos usar? Somente com interface funcional
//		Quando temos uma interface que possui apenas um metodo podemos chamada de interface funcional(@FuncionalInterface)
//		A assinatura do metodo dessa interface diz como a expressão será, se temos param no metodo
//		teremos que ter no lambda
//		Predicate tem um metodo que retorna boolean, assim podemos usa la p validar expressões true or false
//		Consumer tem um void o accept, podemos criar metodos que imprimar valores de uma list
//		Function tem o apply, passamos um tipo  e temos como retorno um outro tipo. Ex: passo uma lista e quero o tamanho dos elementos
		
		PredicateCar predicateCar= new PredicateCar() {
			@Override
			public boolean test(Car car) {
				return car.getAno() == 2010;
			}
		};
		System.out.println(predicateCar.test(new Car("", 2010)));
		
		//Com lambda
		Predicate<Car> predicateCar2= (Car car) -> car.getAno() == 2012;
		System.out.println(predicateCar2.test(new Car("", 2010)));
		
		Runnable runnable= () -> System.out.println("Dentro do run");
		runnable.run();
		new Thread(runnable).start();
		
		forEach(Arrays.asList(1,2,3,4), (Integer i) -> System.out.println(i));
		List<Integer> size = getList(Arrays.asList("Douglas", "Inez", "Geraldo", "Igor"), (String s) -> s.length());
		System.out.println(size);
		
		List<Car> list = Arrays.asList(new Car("White", 2010), new Car("Black", 2000), new Car("Green", 2011));
		List<Integer> list2 = getList(list, (Car c) -> c.getAno());
		System.out.println(list2);
		
		IntPredicate intPredicate= (int i) -> i % 2 == 0;
		System.out.println(intPredicate.test(2));
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c){
		for (T t : list) {
			c.accept(t);
		}
	}
	
	public static <T, R> List<R> getList(List<T> list, Function<T, R> function){
		List<R> listTemp= new ArrayList<>();
		for (T t : list) {
			listTemp.add(function.apply(t));
		}
		return listTemp;
	}
	
	

}
