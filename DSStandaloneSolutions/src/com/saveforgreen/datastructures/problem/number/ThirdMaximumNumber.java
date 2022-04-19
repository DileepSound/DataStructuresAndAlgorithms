package com.saveforgreen.datastructures.problem.number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input = new int[] {3, 2, 1, 5, 4, 3, 1, 0, 9, 9, 99, 100};
		int[] input = new int[] {3, 2, 1};
		
		System.out.println(getThirdMaximumNumber(input));

	}
	
	private static int getThirdMaximumNumber(int[] input) {
		int result = 0;
		
		int[] sortedInput = Arrays.copyOf(input, input.length);
        Arrays.sort(sortedInput);
        Set<Integer> threeLargestNumbers = new HashSet<Integer>();
            
        if (sortedInput.length <= 2) {
        	return sortedInput[sortedInput.length-1];
        }
        
        for (int i=sortedInput.length -1; i >= 0; i--)   {
        	threeLargestNumbers.add(sortedInput[i]);
        	if (threeLargestNumbers.size() == 3) {
        		result = sortedInput[i];
        		break;
        	}        	
        	result = sortedInput[i];
        }
        if (threeLargestNumbers.size() < 3) {
        	return sortedInput[sortedInput.length-1];
        }
		return result;
	}

}
