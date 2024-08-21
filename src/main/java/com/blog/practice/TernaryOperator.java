package com.blog.practice;

public class TernaryOperator {

	public static void main(String[] args) {
		
		// int result = (condition)?val1:val2............
		int x = 3;
		int y = 4;
		String result = (x>y)?"x is greater":"y is greter";
		System.out.println(result);
	}
}
