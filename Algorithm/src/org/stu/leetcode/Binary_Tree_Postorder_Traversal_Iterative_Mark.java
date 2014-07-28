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
 *  解题方法三：不破坏输入的树的结构，使用标记来判断本节点的子树是否已被遍历
 *  解法
 *  每次记录一个preNode和top，top表示当前节点，preNode表示上次输出的节点(是上次输出的节点，不是上次访问的节点)
 *  如果pre正好是top的左子树或者右子树，那么就可以输出cur，否则，说明还有top的左子树或者右子树等待输出，也就是还没到top输出的时候。这是第一个可以让top输出的条件。
 *  另外可以可以让top输出的条件是，top是叶子节。
 *  
 * @author yaomin
 *
 */
public class Binary_Tree_Postorder_Traversal_Iterative_Mark {
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
	    	TreeNode preNode = null;
	    	TreeNode top = null;
	    	while (!stack.isEmpty()){
	    		top = stack.peek();
	    		if ((top.left == null && top.right == null)
	    				|| (preNode != null && (top.left == preNode || top.right == preNode))){
	    					
	    			list.add(top.val);
	    			stack.pop();
	    			preNode = top;
	    			}  else {
	    		
	    		if (top.right != null)
	    			stack.push(top.right);
	    		if (top.left != null)
	    			stack.push(top.left);
	    			}
	    	}
	        return list;
	    }
	}
	
	public static void main(String[] args) {
	}
}
