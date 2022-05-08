package com.saveforgreen.datastructures.pattern.p8.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.saveforgreen.datastructures.vo.TreeNode;

public class DFSAllPathsForASum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		//System.out.println(root);
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		allPathForASum(root, 7, currentPath, allPaths);
		
		System.out.println(allPaths);
	}

	private static void allPathForASum(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
		if (root == null) {
			return;
		}
		currentPath.add(root.val);
		
		//System.out.println("visit="+currentPath);
		// check if it is the leaf noce
		if (root.left == null && root.right == null && root.val == sum) {
			allPaths.add(new ArrayList<>(currentPath));
		} else {
			// discover left node
			allPathForASum(root.left, sum-root.val, currentPath, allPaths);
			
			// discover right node
			allPathForASum(root.right, sum-root.val, currentPath, allPaths);
		}
		
		// backtrack currentpath by one element to visit the other side of the node
		currentPath.remove(currentPath.size()-1);
	}

}
