package devDojoJava8.interfaces.predicates;

import java.util.Calendar;

import devDojoJava8.Car;
import devDojoJava8.interfaces.PredicateCar;

public class PredicatorYear implements PredicateCar {

	@Override
	public boolean test(Car car) {
		return car.getAno() > (Calendar.getInstance().get(Calendar.YEAR) - 10);
	}

}
