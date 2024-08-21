package com.blog.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class EmployeeMain {
	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
				new Employee("pk","mumbai","india",93836352798l,898895.00),
				new Employee ("sk","patna","China",6482355989243l,958595.00),
				new Employee("dk","mumbai","Japan",93836352798l,54575.00),
				new Employee ("nk","chikago","italy",6482355989000l,575686.00)
				);
		
		// Method Refrence.................
		List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
		 System.out.println(collect);
		 
		 // Lambda Expression..................
		 List<String> collect2 = employees.stream().map(e-> e.getName()).collect(Collectors.toList());
		 System.out.println(collect2);
		 
		// Group by based on requirement
		 Map<String, List<Employee>> collect3 = employees.stream().collect(Collectors.groupingBy(Employee::getCity));

		 // Print key and values
		 for (Map.Entry<String, List<Employee>> entry : collect3.entrySet()) {
		     String city = entry.getKey();
		     List<Employee> employeesInCity = entry.getValue();

		     System.out.println("City: " + city);

		     for (Employee e : employeesInCity) {
		         System.out.println("  Name: " + e.getName() +
		                            ", City: " + e.getCity() +
		                            ", Country: " + e.getCountry() +
		                            ", Salary: " + e.getSalary() +
		                            ", Mobile: " + e.getMob());
		     }
		 }

		 }
		
	}


