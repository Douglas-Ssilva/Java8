package br.com.java8.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrderString {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("DevMedia");
		list.add("DevDojo");
		list.add("Alura");
		list.add("Algaworks");

		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, new ComparatorForLength());
//		System.out.println(list);
		
		//Novas formas
		
		list.sort(new ComparatorForLength());
		System.out.println(list);
		
//		for (String s : list) {
//			System.out.println(s);
//		}
		
		//new way
		list.forEach(new PrinterInline());

	}

}

class PrinterInline implements Consumer<String>{

	@Override
	public void accept(String t) {
		System.out.println("Dentro de consumer: " +  t);
	}
	
}

//Other form de order
class ComparatorForLength implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() > s2.length()) 
			return 1;
		if (s1.length() < s2.length()) 
			return -1;
		return 0;
	}

}
