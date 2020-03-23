package com.chang.team.domain;

public class NoteBook implements Equipment {

	private String model;//机器型号
	private Double price;//价格

	public NoteBook() {
		super();
	}

	public NoteBook(String model, Double price) {
		super();
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String getDescription() {
		return model + "(" + price + ")";
	}

}
