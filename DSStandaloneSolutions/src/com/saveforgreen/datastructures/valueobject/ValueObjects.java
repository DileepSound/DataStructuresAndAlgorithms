package com.saveforgreen.datastructures.valueobject;

public class ValueObjects {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int valParam) {
			this.val = valParam;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}



	}

}

