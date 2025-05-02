package edu.pucp.mechatronics.model;

public class Product {
	private int id;
	private String name;
	private int stock;
	
	//Generar los constructores usando source/Generate constructor using ...
	//No se selecciona ninguno
	public Product() {
		super();
	}

	//Solo seleccionar name, stock
	public Product(String name, int stock) {
		super();
		this.name = name;
		this.stock = stock;
	}

	//Generar getter and seters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
