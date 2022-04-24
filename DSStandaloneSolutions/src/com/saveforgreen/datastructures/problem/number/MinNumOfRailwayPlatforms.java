package com.saveforgreen.datastructures.problem.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinNumOfRailwayPlatforms {

	public static void main(String[] args) {
		// {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
		// {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
		Scanner in = new Scanner(System.in);
		int numoftestcases = in.nextInt();
		List<int[][]> testcases = new ArrayList<>();
		int i = 1;
		while (i <= numoftestcases) {
			int numoftrains = in.nextInt();
			in.nextLine();
			String arrivaltimestr = in.nextLine();
			System.out.println(" arrivaltimestr = " + arrivaltimestr);

			String depttimestr = in.nextLine();
			System.out.println(" depttimestr = " + depttimestr);
			in.reset();

			int[] arrivaltimes = Arrays.stream(arrivaltimestr.split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] departtimes = Arrays.stream(depttimestr.split(" ")).mapToInt(Integer::parseInt).toArray();

			int[][] arrDepartTimes = new int [numoftrains][2];
			int index = 0;
			while (index < numoftrains) {
				arrDepartTimes[index][0] = arrivaltimes[index];
				arrDepartTimes[index][1] = departtimes[index];
				index++;
			}
			testcases.add(arrDepartTimes);
			i++;
		}
		in.close();

		MinNumOfRailwayPlatforms obj = new MinNumOfRailwayPlatforms();
		for (int[][] testcase : testcases) {
			System.out.println("No. of platforms needed = " + obj.findOverlap(testcase));
		}
		// int[][] input = new int[][] {{900, 910}, {940, 1200}, {1500, 1900}, {950, 1120}, {1100, 1130}, {1800, 2000}};
		// MinNumOfRailwayPlatforms obj = new MinNumOfRailwayPlatforms();
		// System.out.println("No. of platforms needed = " + obj.findOverlap(input));
	}

	public int findOverlap(int[][] arrDepartTime) {
		Arrays.sort(arrDepartTime, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
		int numOfIntervals = arrDepartTime.length;
		int current = 0, next = 1;
		int overlapcount = 0;
		while (next < numOfIntervals) {
			System.out.println(arrDepartTime[current][0]);
			if ((arrDepartTime[current][1] > arrDepartTime[next][0])) {
				overlapcount++;
			}
			current++;
			next++;
		}
		System.out.println(arrDepartTime[current][0]);
		if (overlapcount == 0)
			return 1; // at least one platform needed
		return overlapcount;
	}
}
