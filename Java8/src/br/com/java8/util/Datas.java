package br.com.java8.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Datas {

	public static void main(String[] args) {
		
		LocalDate localDate= LocalDate.now();
		System.out.println(localDate); //2019-10-01 Pega num formato ISO, locale que pegou internamente
		
		LocalDate olimpiadas= LocalDate.of(2022, Month.JUNE, 5);
		
		int anos= olimpiadas.getYear() - localDate.getYear();
		System.out.println("Faltam " + anos + " anos paras as olimpiadas");
		
		Period period= Period.between(localDate, olimpiadas);
		System.out.println(period.getDays());
	}

}
