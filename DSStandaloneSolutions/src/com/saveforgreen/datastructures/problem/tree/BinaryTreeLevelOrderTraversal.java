package com.saveforgreen.datastructures.problem.tree;

import java.util.ArrayList;
import java.util.List;

import com.saveforgreen.datastructures.vo.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	int index = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	TreeNode currentNode = root;
    	
    	while (currentNode.left != null || currentNode.right != null) {
    		if (currentNode.left != null) {
    			//result.add(currentNode.left.val);
    			levelOrder(currentNode.left);
    		}
    		if (currentNode.right != null) {
    			levelOrder(currentNode.right);
    		}
    		
    	}
    	
    	return result;        
    }	

}

