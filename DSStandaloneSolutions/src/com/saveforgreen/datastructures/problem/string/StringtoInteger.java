package com.saveforgreen.datastructures.problem.string;

public class StringtoInteger {

	public static void main(String args[]) {
		System.out.println("Result = " + myAtoi("343 sdfs"));
	}

	public static int myAtoi(String str) {
		int result = 0;
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}
		boolean isNegative = false;
		String firstChar = str.charAt(0) + "";
		// if the first characters is no '+', '-' or digit return 0
		if (!"+-1234567890".contains(firstChar)) {
			return result;
		}
		if ("+-".contains(firstChar)) {
			if (firstChar.equals("-")) {
				isNegative = true;
			}
			str = str.substring(1);
		}
		int index = 0;
		while (index < str.length()) {
			String nextChar = String.valueOf(str.charAt(index));
			if ("1234567890".contains(nextChar+"")) {
				int nextNum = Integer.parseInt(String.valueOf(nextChar));
				// -214748364#8
				if (isNegative &&
						((result * -1) < Math.abs(Integer.MIN_VALUE)/10 ||
								(((result * -1) == Math.abs(Integer.MIN_VALUE)/10) && (nextNum * -1) <= (Math.abs(Integer.MIN_VALUE)%10)))) {
					return Integer.MIN_VALUE;
				} else if (result > Integer.MAX_VALUE/10 ||
						(result == Integer.MAX_VALUE/10 && nextNum > Integer.MAX_VALUE%10)) {
					return Integer.MAX_VALUE;

				} else {
					result = result * 10 + nextNum;
				}
			} else {
				break;
			}
			index++;
		}

		if (isNegative) {
			result = result * -1;
		}

		return result;
	}

}
