package com.saveforgreen.datastructures.problem;

import java.util.Arrays;

public class KthSmallestSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = new int[][] {{1,2,3}, {4, 5, 10}, {6, 8, 9}};
		System.out.println(kthSmallest(input, 6));

	}

    public static int kthSmallest(int[][] matrix, int k) {
        int result = 0;

        int len = matrix[0].length;

        //List<Integer> mergedList = new ArrayList<Integer>();
        int[] mergedList = new int[len * len];
        int mergedListIdx= 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j< len; j++) {
                mergedList[mergedListIdx++] = matrix[i][j];
                //System.out.println(mergedList[mergedListIdx] + ", ");
            }
        }
        Arrays.sort(mergedList);
        result = mergedList[k-1];
        return result;
    }


}
