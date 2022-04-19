package com.saveforgreen.datastructures.problem.string;

import java.util.Arrays;
import java.util.Collections;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// aycmalayalamxyz
		// zyxmalayalamcya
		System.out.println(longestPalindrome("aycdadxyz"));

	}

	public static String longestPalindrome(String s) {
		String origStr = s;
		String reverseStr = new StringBuffer(s).reverse().toString();
		if (origStr.equalsIgnoreCase(reverseStr)) {
			return origStr;
		}
		StringBuffer palindrome = new StringBuffer();
		int i = 0, j = 0;
		while (i < origStr.length()) {
			while (j < reverseStr.length()) {
				if (origStr.charAt(i) == reverseStr.charAt(j)) {
					palindrome.append(origStr.charAt(i));
					longestPalindrome(origStr.substring(i+1));
				} else {
					// palindrome.deleteCharAt();
				}
				j++;
			}
			i++;
		}
		return palindrome.toString();
	}

}
