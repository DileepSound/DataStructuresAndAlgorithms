package com.saveforgreen.datastructures.problem.array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
//      Scanner in = new Scanner(System.in);
//      System.out.print("Input: height = ");
//      String input = in.nextLine();
//      in.close();

//      int[] height = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
     int[] height = new int[] {1,8,6,2,5,4,8,3,7};
     ContainerWithMostWater s = new ContainerWithMostWater();
     System.out.println("�utput: " +  s.maxArea(height));

 }

 public int maxArea(int[] height) {
     int currentIndex = 0, nextIndex = 1;
     int interval = 0;
     int area = 0, maxArea = 0;
     while (nextIndex < height.length) {
         interval = nextIndex - currentIndex;
         area = Math.min(height[currentIndex], height[nextIndex]) * interval;
         if (area > maxArea) {
          maxArea = area;
         }
         nextIndex++;
         currentIndex++;
     }
     return area;
 }

}
