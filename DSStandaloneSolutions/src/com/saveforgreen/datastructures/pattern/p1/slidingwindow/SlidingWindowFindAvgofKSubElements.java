package com.saveforgreen.datastructures.pattern.p1.slidingwindow;

import java.util.Arrays;

// "static void main" must be defined in a public class.
// Given an array, find the average of all subarrays of ‘K’ contiguous elements in it.
public class SlidingWindowFindAvgofKSubElements {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        System.out.println(Arrays.toString(findAveragesOofn(k, input)));
    }

    public static double[] findAveragesOofn2(int k, int[] arr) {
        int left = 0, right = left + k -1;
        double[] result = new double[arr.length-k+1];
        while (right < arr.length) {
            for (int i  = left; i <= right; i++) {
                result[left] = result[left] + arr[i];
            }
            result[left] = result[left]/k;
            System.out.println(result[left]);
            left++;
            right++;
        }
        return result;
    }

    public static double[] findAveragesOofn(int k, int[] arr) {
        int left = 0, right = left + k -1;
        double[] result = new double[arr.length-k+1];
        double[] sum = new double[arr.length-k+1];
        for (int i  = left; i <= right; i++) {
            sum[left] = sum[left] + arr[i];
        }
        result[left] = sum[left]/k;
        left++;
        right++;

        while (right < arr.length) {
            sum[left] = findNextSum(arr, sum[left-1], left-1, right);
            result[left] = sum[left]/k;
            left++;
            right++;
        }
        return result;
    }

    public static double findNextSum(int[] arr, double prevSum, int subtractidx, int addidx) {
        double nextSum = prevSum - arr[subtractidx] + arr[addidx];
        return nextSum;
    }
}