package com.blog.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeClassMain {

	public static void main(String[] args) {
		
		EmployeeClass ec = new EmployeeClass();
		ec.setAge(12);
		ec.setCity("Chenai");
		ec.setName("PK");
		ec.setId(1);
		
		EmployeeClass ec1 = new EmployeeClass();
		ec.setAge(122);
		ec.setCity("Bhopal");
		ec.setName("sk");
		ec.setId(2);
		
		EmployeeClass ec2 = new EmployeeClass();
		ec.setAge(13);
		ec.setCity("BLR");
		ec.setName("DK");
		ec.setId(3);
		
		List<EmployeeClass> asList = Arrays.asList(ec,ec1,ec2);
		List<EmployeeClassDto> collect = asList.stream().map(e->mapToDto(e)).collect(Collectors.toList());
		  
		System.out.println(collect);
		for(EmployeeClassDto e:collect) {
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getCity());
			System.out.println(e.getAge());
		}
			
			
		}
		
	
	public static EmployeeClassDto mapToDto(EmployeeClass emp) {
		
		EmployeeClassDto dto = new EmployeeClassDto();
		dto.setName(emp.getName());
		dto.setAge(emp.getAge());
		dto.setCity(emp.getCity());
		dto.setId(emp.getId());
		return dto;
		
	}
}
