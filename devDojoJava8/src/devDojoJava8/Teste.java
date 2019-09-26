package devDojoJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import devDojoJava8.interfaces.PredicateCar;
import devDojoJava8.interfaces.predicates.PredicateColor;

public class Teste { // Unica coisa que muda entre esses metodos é o IF, com parametros conseguimos
						// resolver isso

	public static void main(String[] args) {

		List<Car> list = Arrays.asList(new Car("White", 2010), new Car("Black", 2000), new Car("Green", 2011));

//		System.out.println(filterCar(list, "Gree n"));
//		System.out.println(filterCarForYear(list));
		System.out.println(filterCarPredicator(list, new PredicateColor()));
		System.out.println(filter(list, new Predicate<Car>() {
			@Override
			public boolean test(Car t) {
				return t.getAno() > 2010;
			}
		}));

	}

	public static List<Car> filterCar(List<Car> list, String color) {
		List<Car> listFilter = new LinkedList<>();
		for (Car car : list) {
			if (car.getColor().equals(color)) {
				listFilter.add(car);
			}
		}
		return listFilter;
	}

	public static List<Car> filterCarForYear(List<Car> list) {
		List<Car> listFilter = new LinkedList<>();
		int anoCurrent = Calendar.getInstance().get(Calendar.YEAR);

		for (Car car : list) {
			int diferencaAno = anoCurrent - car.getAno();
			if (diferencaAno < 10) {
				listFilter.add(car);
			}
		}
		return listFilter;
	}

//	Usando Predicator
	public static List<Car> filterCarPredicator(List<Car> list, PredicateCar predicateCar) {
		List<Car> listFilter = new LinkedList<>();
		for (Car car : list) {
			if (predicateCar.test(car)) {
				listFilter.add(car);
			}
		}
		return listFilter;

	}

	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		List<T> listGeneric = new ArrayList<>();

		for (T t : list) {
			if (predicate.test(t)) {
				listGeneric.add(t);
			}
		}
		return listGeneric;
	}

}
