package com.saveforgreen.datastructures.problem.array;

import java.util.HashMap;
import java.util.Map;

public class SumofTwoNumberInArray {

	public static void main(String[] args){
		SumofTwoNumberInArray solution = new SumofTwoNumberInArray();
		int[] result = null;
        int[] nums = new int[]{10, 15, 3, 7};
        // int[] nums = new int[]{3, 2, 4};
        int target = 1;
        try {
        long startTimeinMillis = System.nanoTime();
        result = solution.twoSumBigOofNsq(nums, target);
        if (result != null) {
            System.out.println("twoSumBigOofNsq - restult =  {" + result[0] + "," + result[1] + "}");
            System.out.println("twoSumBigOofNsq = " + ((System.nanoTime() - startTimeinMillis)/1000) );
        }
        
        startTimeinMillis = System.nanoTime();
        result = solution.twoSumBigOofN(nums, target);
        if (result != null) {
        System.out.println("twoSumBigOofN - restult =  {" + result[0] + "," + result[1] + "}");
        System.out.println("twoSumBigOofN = " + ((System.nanoTime() - startTimeinMillis)/1000) );
        }
        } catch (Exception e) {
        	System.err.print(e.getMessage());
        }
    }
	// O(n2) Time complexity, O(1) Space complexity 
	public int[] twoSumBigOofNsq(int[] sortedNums, int target) {
        for (int i= 0; i < sortedNums.length; i++) {
            for (int j = i+1; j < sortedNums.length; j++) {
                if (sortedNums[i] + sortedNums[j] == target) {
                   return new int[]{i, j};                     
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
	
	// O(n) Time complexity, O(n) Space complexity
	public int[] twoSumBigOofN(int[] nums, int target) {
		
		 Map<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < nums.length; i++) {
		        map.put(nums[i], i);
		    }
		    for (int i = 0; i < nums.length; i++) {
		        int complement = target - nums[i];
		        if (map.containsKey(complement) && map.get(complement) != i) {
		            return new int[] { i, map.get(complement) };
		        }
		    }
		    throw new IllegalArgumentException("No two sum solution");
	}
	
}
