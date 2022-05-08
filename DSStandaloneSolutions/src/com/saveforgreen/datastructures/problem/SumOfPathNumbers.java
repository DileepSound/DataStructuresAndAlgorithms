package com.saveforgreen.datastructures.problem;
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class SumOfPathNumbers {
  public static int findSumOfPathNumbers(TreeNode root) {
    // TODO: Write your code here

    // use a String buffer to concatenate the numbers in the order they are visited.
	List<Integer> sumOfPaths = new ArrayList<>();
	StringBuffer pathNum = new StringBuffer();
	calculateSum(root, pathNum, sumOfPaths);
	int result = 0;
	for (Integer val : sumOfPaths) {
		result += val;
	}
	return result;
  }

  public static void calculateSum(TreeNode node, StringBuffer pathNum, List<Integer> sumOfPaths) {
    if (node == null) {
      return;
    }
    // running path num generator
    pathNum.append(node.val);

    if (node.left == null && node.right == null) {
      sumOfPaths.add(Integer.parseInt(pathNum.toString()));
      System.out.println("sumOfPaths = " + sumOfPaths);
    } else {
      //discover left side
      calculateSum(node.left, pathNum, sumOfPaths);

      //discover right side
      calculateSum(node.right, pathNum, sumOfPaths);
    }

    pathNum.delete(pathNum.length()-1, pathNum.length());
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}
