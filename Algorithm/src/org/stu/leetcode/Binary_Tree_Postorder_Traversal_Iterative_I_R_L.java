package org.stu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
 *  迭代方法
 *  解题方法二：不破坏输入的树的结构，先序遍历的变种 + 反转
 *  后序遍历的规则：左子树 --> 右子树 --> 自己
 *  解法
 *  1)使用先序遍历的变种，先采用"自己 --> 右子树 --> 左子树"的顺序遍历，得到遍历序列 
 *  2)将1)中得到的序列反转，即是所求的后续遍历的结果
 *  
 * @author yaomin
 *
 */
public class Binary_Tree_Postorder_Traversal_Iterative_I_R_L {
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
	    	Stack<TreeNode> stack = new Stack<>();
	    	stack.push(root);
	    	while (!stack.isEmpty()){
	    		TreeNode top = stack.pop();
	    		list.add(top.val);
	    		
	    		if (top.left != null)
	    			stack.push(top.left);
	    		
	    		if (top.right != null)
	    			stack.push(top.right);
	    			
	    	}
	    	Collections.reverse(list);
	        return list;
	    }
	}
	
	public static void main(String[] args) {
	}
}
