package org.stu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：Given a binary tree, return the postorder traversal of its nodes' values.
 *	For example:
 *	Given binary tree {1,#,2,3},
 *  1
 *    \
 *     2
 *    /
 *  3  
 *  return [3,2,1]. 
 *  Note: Recursive solution is trivial, could you do it iteratively?
 *  
 *  递归方法
 *  
 * @author yaomin
 *
 */
public class Binary_Tree_Postorder_Traversal_Recursive {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public class Solution {
		List<Integer> list = new ArrayList<Integer>();;
		
	    public List<Integer> postorderTraversal(TreeNode root) {
	    	if (root == null)
	    		return list;
	    	
	    	recursivePostorderTraversal(root);
	        return list;
	    }
	    
	    public void recursivePostorderTraversal(TreeNode root){
	    	if (root == null)
	    		return ;
	    	
	    	if (root.left != null)
	    		recursivePostorderTraversal(root.left);
	    	
	    	if (root.right != null){
	    		recursivePostorderTraversal(root.right);
	    	}
	    	
	    	list.add(root.val);
	   
	    }
	}
	
	public static void main(String[] args) {
	}
}
