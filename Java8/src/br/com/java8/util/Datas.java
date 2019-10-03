package br.com.java8.util;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Datas {

	public static void main(String[] args) {
		
		LocalDate localDate= LocalDate.now();
//		System.out.println(localDate); //2019-10-01 Pega num formato ISO, locale que pegou internamente
		
		LocalDate olimpiadas= LocalDate.of(2022, Month.JUNE, 6); //Podemos no mês passar valores também, de 1 a 12
		olimpiadas.getMonthValue();//retorna 2 p salvarmos no banco
		olimpiadas.isLeapYear(); //ano bissexto
		
		int anos= olimpiadas.getYear() - localDate.getYear();
//		System.out.println("Faltam " + anos + " anos paras as olimpiadas");
		
		Period period= Period.between(localDate, olimpiadas);
		System.out.println("Faltam " + period.getYears() + " anos " + period.getDays() + " dias " + period.getMonths() + " meses");
		
//		Toda API de data é imutável
		LocalDate localDate2 = olimpiadas.plusYears(4);
		System.out.println("Proximas olimpiadas: " + localDate2);
		
		DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String format = localDate2.format(dateTimeFormatter);
		System.out.println(format);
		
//		Me da horas, minutos e segundos
		DateTimeFormatter dateTimeFormatter2= DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		LocalDateTime dateTime= LocalDateTime.now();
		System.out.println(dateTime.format(dateTimeFormatter2));
		
//		pegando somente a data
		
		LocalTime localTime= LocalTime.of(15, 30);
		System.out.println(localDate);
		System.out.println(LocalDate.MAX); //Data máxima  
		System.out.println(LocalDate.MIN);
		
		
		dateTime.toLocalDate();
		
		LocalTime dateTime2= LocalTime.of(20, 10, 12);
		System.out.println(dateTime2);
		
//		parse de datas
		LocalDate parse = LocalDate.parse("2017-02-15");
		LocalTime localTime2= LocalTime.parse("15:25:15");
		System.out.println(parse);
		System.out.println(localTime2);
		
		LocalDateTime dateTime22= LocalDateTime.now();
		System.out.println(dateTime22);
		
		LocalDateTime dateTime3= LocalDate.now().atTime(LocalTime.now());
		System.out.println(dateTime3);
		
		Instant now = Instant.now(); 
		System.out.println(now.getNano());
		System.out.println(now.getEpochSecond());
		
		//Podemos trabalhar com intervalo de datas com a Duration
		LocalDateTime dateTime4= LocalDateTime.now();
		LocalDateTime dateTime5= LocalDateTime.of(2020, Month.AUGUST, 10, 22, 50, 58);
		LocalTime localTime3= LocalTime.now();
		LocalTime localTime4= LocalTime.of(22, 10, 55);
		
		//Não podemos usar LocalDate, pois a Duration usa segundos e nanosegundos, nem misturar LocalDateTime com LocalTime
		Duration duration= Duration.between(dateTime4, dateTime5);
		Duration duration1= Duration.between(localTime3, localTime4);
		Duration duration2= Duration.ofDays(10);
		Duration duration3= Duration.ofMinutes(3);
		System.out.println(duration);
		System.out.println(duration1);
		
		Duration duration5= Duration.between(dateTime5, localTime3.atDate(dateTime5.toLocalDate())); //Forma de comparar os 2
		System.out.println(duration5);
		System.out.println("Dias p horas: " + duration2);
		System.out.println("Minutos p segundos: " + duration3);
		
		//Period
		Period p1= Period.between(dateTime4.toLocalDate(), dateTime5.toLocalDate());
		System.out.println(p1);
		
		LocalDateTime dateTime6= LocalDateTime.now();
		Period ofDays = Period.ofDays(10);
		Period ofMonths = Period.ofMonths(10);
		Period ofWeeks = Period.ofWeeks(58);
		System.out.println(ofDays);
		System.out.println(ofMonths);
		System.out.println(ofWeeks);
		System.out.println("MEses: " + dateTime6.until(dateTime6.plusDays(ofWeeks.getDays()), ChronoUnit.MONTHS));
		
		LocalDateTime dateTime9= LocalDateTime.of(1994, Month.SEPTEMBER, 24, 22, 50, 58);
		//ChronoUnit
		System.out.println(ChronoUnit.DAYS.between(dateTime9, dateTime6));
		System.out.println(ChronoUnit.MONTHS.between(dateTime9, dateTime6));
		System.out.println(ChronoUnit.WEEKS.between(dateTime9, dateTime6));
		System.out.println(ChronoUnit.YEARS.between(dateTime9, dateTime6));
		
		
		//Aula 205
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
