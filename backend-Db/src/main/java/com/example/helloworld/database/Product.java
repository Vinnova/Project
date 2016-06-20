package com.example.helloworld.database;

public class Product {
	private Integer id;
	private String name;
	
	public Product() {
		super();
	}
	
	public Product(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product []";
	}

	public Product(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
