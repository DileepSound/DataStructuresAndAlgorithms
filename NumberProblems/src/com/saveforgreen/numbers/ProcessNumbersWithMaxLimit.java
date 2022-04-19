package com.saveforgreen.numbers;

import java.util.Scanner;

public class ProcessNumbersWithMaxLimit {
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int input =scanner.nextInt();
			if (input == 42) {
				scanner.close();
				break;
			}
			System.out.println(input);
		}
		scanner.close();
	}	
}
