package com.blog.practice;

public class Employee {

	private String name;
	private String city;
	private String country;
	private Long mob;
	private Double salary;

	public Employee(String name, String city, String country, Long mob, Double salary) {
		super();
		this.name = name;
		this.city = city;
		this.country = country;
		this.mob = mob;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public Long getMob() {
		return mob;
	}

	public Double getSalary() {
		return salary;
	}

	

}
