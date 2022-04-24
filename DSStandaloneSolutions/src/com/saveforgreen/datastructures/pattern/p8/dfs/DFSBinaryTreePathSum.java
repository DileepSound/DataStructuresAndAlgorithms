package com.saveforgreen.datastructures.pattern.p8.dfs;

import com.saveforgreen.datastructures.vo.TreeNode;

/**
 * @author dileep
 *
 */
public class DFSBinaryTreePathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(root);

		System.out.println(hasTreePathSum(root, 10));
	}

	public static boolean hasTreePathSum(TreeNode root, int sum) {

		if (root == null)
			return false;

		if (root.left == null && root.right == null && root.val == sum) {
			System.out.println(root.val);

			return true;
		}
		return hasTreePathSum(root.left, (sum-root.val)) || hasTreePathSum(root.right, (sum-root.val));

	}

}