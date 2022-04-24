package com.saveforgreen.datastructures.problem.array;

public class ProductOfAllOtherNumbersInArray {

	public static void main(String[] args) {
		int[] input = new int[] { 1, 3, 5 };
		int[] result = productOfOtherNumbers(input);
		for (int element : result) {
			System.out.print(element + ", ");
		}

	}

	public static int[] productOfOtherNumbers(int[] input) {
		int[] result = new int[input.length];
		int i = 0, j = 0;
		while (i < input.length) {
			result[i] = 1;
			j = 0;
			while (j < input.length) {
				if (i != j) {
					result[i] *= input[j];
				}
				j++;
			}
			i++;
		}

		return result;
	}

	public static int[] productOfOtherNumbersEfficient(int[] input) {
		int[] result = new int[input.length];
		int i = 0, j = 0;
		int[] prefix = new int[input.length], suffix = new int[input.length];
		while (i < input.length) {
			if (prefix[0] != -1) {
				prefix[i] = prefix[i - 1] * input[i];
			} else {
				prefix[0] = input[0];
			}
		}

		while (j < input.length) {
			if (suffix[0] != -1) {
				suffix[j] = suffix[j - 1] * input[j];
			} else {
				suffix[0] = input[0];
			}
		}

		i = 0;
		while (i < input.length) {
			if (i == 0) {
				result[0] = suffix[1];
			} else if (i == input.length - 1) {
				result[input.length - 1] = prefix[input.length - 2];
			} else {
				result[i] = prefix[i - 1] * suffix[i + 1];
			}
		}

		return result;
	}
}
