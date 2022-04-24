package com.saveforgreen.datastructures.pattern.p0.general;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	    public int[] twoSum(int[] nums, int target) {
	        if (nums == null) {
	            return nums;
	        } else if (nums.length == 2 && (nums[0] + nums[1]) == target) {
	            return new int[]{0,1};
	        }
	        Map<Integer, Integer> tempMap = new HashMap<>();
	        int tempMapIdx = 0;
	        for (int i = 0; i < nums.length; i++) {
	            int compVal = target - nums[i];
	            if (!tempMap.containsKey(compVal)) {
	                tempMap.put(nums[i], tempMapIdx++);
	            } else {
	                return new int[] {i, tempMap.get(compVal)};
	            }
	        }
	        return null;
	    }
	}