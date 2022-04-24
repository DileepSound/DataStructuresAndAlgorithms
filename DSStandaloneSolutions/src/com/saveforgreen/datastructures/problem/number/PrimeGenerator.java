package com.saveforgreen.datastructures.problem.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// number t of test cases
		// in a single line (t<=10).
		// In each of the next t lines there are two numbers m and n
		// (1 <= m <= n <= 1000000000,
		// n-m<=100000)
		// separated by a space

		// For every test case
		// print all prime numbers p such that m <= p <= n,
		// one number per line
		// test cases separated by an empty line.

		Scanner in = new Scanner(System.in);
		int noOfTestcases = in.nextInt();
		List<String> listOfTestcases = new ArrayList<>();
		int index = 0;
		while (in.hasNextLine()) {

			listOfTestcases.add(in.nextLine());
			// check boundary conditions
			if (index++ >= noOfTestcases) {
				in.close();
				break;
			}
		}

		for (String testcase : listOfTestcases) {
			String[] boundary = testcase.split(" ");
			if (boundary.length > 1) {
				try {
					int m = Integer.parseInt(boundary[0]);
					int n = Integer.parseInt(boundary[1]);

//					// check boundaries
//					StringBuilder validationMessages = new StringBuilder();
//					if (m < 1) {
//						validationMessages.append("\\n m should be >= 1");
//					}
//					if (n > 1000000000) {
//						validationMessages.append("\\n n should be <= 1000000000");
//					}
//					if ((n - m) > 100000) {
//						validationMessages.append("\n n-m should be <= 100000");
//					}
//					if (validationMessages.length() > 0) {
//						System.err.println(validationMessages);
//						break;
//					}

					int p = m;
					index = 2;
					while (p <= n) {
						if (p > 1 && isPrime(p)) {
							System.out.println(p);
						}
						p++;
					}
				} catch (NumberFormatException nfe) {
					System.err.print("Invalid input.");
				}
			}
			System.out.println();
		}
	}

	private static boolean isPrime(int p) {

		int index = 2;
		while (index < p) {
			if ((p % index) == 0) {
				return false;
			}
			index++;
		}
		return true;
	}

}
