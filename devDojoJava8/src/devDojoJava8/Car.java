package devDojoJava8;

public class Car {
	
	private String name= "Ford";
	private String color;
	private int ano;
	
	public Car(String color, int ano) {
		this.color = color;
		this.ano = ano;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

}
