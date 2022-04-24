package com.saveforgreen.datastructures.problem.tree;

import com.saveforgreen.datastructures.vo.TreeNode;

public class CheckBinarySearchTree {
	public boolean helper(TreeNode node, Integer lower, Integer upper) {
	    if (node == null) return true;

	    int val = node.val;
	    if ((lower != null && val <= lower) || (upper != null && val >= upper)) return false;

	    if (! helper(node.right, val, upper)) return false;
	    if (! helper(node.left, lower, val)) return false;
	    return true;
	  }

	  public boolean isValidBST(TreeNode root) {
	    return helper(root, null, null);
	  }

}