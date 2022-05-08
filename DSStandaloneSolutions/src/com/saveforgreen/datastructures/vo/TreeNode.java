package com.saveforgreen.datastructures.vo;

/**
 * Definition for a binary tree node. **/
  public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      
	@Override
	public String toString() {
		//return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		return "TreeNode [val=" + val + "\n, left=" + left + "\t\t, right=" + right + "]";
	}
      
      
  }