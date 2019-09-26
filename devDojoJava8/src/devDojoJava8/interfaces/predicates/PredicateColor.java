package devDojoJava8.interfaces.predicates;

import devDojoJava8.Car;
import devDojoJava8.interfaces.PredicateCar;

public class PredicateColor implements PredicateCar{

	@Override
	public boolean test(Car car) {
		return car.getColor().equals("White");
	}

}
