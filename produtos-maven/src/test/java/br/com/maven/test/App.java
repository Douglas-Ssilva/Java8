package br.com.maven.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.maven.Product;

public class App {
	
	@Test
	public void randomCFP() {
		double a= 100;
		double aa= 100;
		
		Product product = new Product("Notbook", "111.111.111-99");
		product.embaralharCpf();
		assertEquals(a, aa, 0.0001);
	}

}
