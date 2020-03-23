package com.chang.team.domain;

public class Employee {

	private int id;
	private String name;
	private int age;
	private double salary;

	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}
	
	public String getDetails() {
		return id + "\t" + name + "\t" + age +"\t" + salary;
	}

	@Override
	public String toString() {
		return getDetails();
	}
}
