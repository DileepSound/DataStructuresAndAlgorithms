package com.saveforgreen.datastructures.problem.number;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(fibonacciNumbers(5));
		int n = 8;
		System.out.print("0 1 ");
		fibonacciNumbersRecursive(n-2);
	}
	static int n1 = 0, n2 = 1, n3= 0;
	private static void fibonacciNumbersRecursive(int input) {


		if (input > 0) {

			n3 = n2 + n1;
			n1 = n2;
			n2 = n3;
			System.out.print(n3 + " ");
			fibonacciNumbersRecursive(input-1);
		}


	}

}
