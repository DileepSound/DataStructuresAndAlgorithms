package com.saveforgreen.datastructures.pattern.p2.twopointers;

import java.util.Arrays;

public class TPSquaresOfASortedArray {
	public static void main(String[] args) {
		int[] input = new int[] {-4,-1,0,3,10};
		Solution sol = new Solution();
		int[] output = sol.sortedSquares(input);
		System.out.println(Arrays.toString(output));
	}
}

class Solution {
	public int[] sortedSquares(int[] nums) {
		if (nums == null) {
			return nums;
		}
		int idx = 0;
		while (idx < nums.length) {
			nums[idx] = nums[idx] * nums[idx];
			idx++;
		}
		int l = 0, r = 1, len = nums.length - 1;
		while (l < r && l <= len && r <= len) {
			if (nums[l] < nums[r]) {
				r++;
			} else if (nums[l] > nums[r]) {
				int temp = nums[l];
				nums[l] = nums[r];
				nums[r] = temp;
				r++;
			} else {
				r++;
			}
			if (r > len) {
				l++;
				r = l + 1;
			}
		}
		return nums;
	}

	private int[] expensiveSolution(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}

		Arrays.sort(nums);
		return nums;
	}
}