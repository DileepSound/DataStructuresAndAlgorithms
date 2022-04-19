package com.saveforgreen.datastructures.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] {1,2,3}, new int[] {5,4,5}));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arrayList = new int[nums1.length + nums2.length];
        int i = 0, j = 0, cnt = 0;
        while (i < nums1.length || j < nums2.length) {
        	if (i < nums1.length) {
        		arrayList[cnt++] = nums1[i++];
        	}
        	if (j < nums2.length) {
        		arrayList[cnt++] = nums2[j++];
        	}
        }
        Arrays.sort(arrayList);
        int len = arrayList.length;
        System.out.println(len);
        
        if (len % 2 != 0) {
        	return arrayList[len/2];
        }        
        System.out.println();        
        return (double)(arrayList[(len - 1) / 2] + arrayList[len / 2]) / 2.0;
    }
}
