package org.stu.leetcode;

import java.util.ArrayList;
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
 *  解题方法一：破坏输入的树的结构：
 *  开一个Stack，由于root结点是最后访问的结点，所以我们先将root结点push到Stack中
 * 我们写一个while循环，while循环结束的条件是栈中没有任何结点。
 * 当栈中有结点的时候，我们将取出栈顶结点
	1、判断下它是否是叶子结点（left和right都为null）, 如果是叶子结点的话，那么不好意思，把它弹出栈，并把值add到ArrayList中，如果不是叶子结点的话，那么
	2、我们判断下它的left（node.left）是否为null,如果不为null，把它的左孩子结点push到栈中来，并把它的左孩子域设为null, 然后跳过此次循环剩下的部分
	3、如果它的left 为null, 把它的右孩子结点push到栈中来，并把它的右孩子域设为null，然后跳过此次循环剩下的部分！ 
 *  
 * @author yaomin
 *
 */
public class Binary_Tree_Postorder_Traversal_Iterative_breakTree {
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
	    		TreeNode top = stack.peek();
	    		if (top.left == null && top.right == null){
	    			list.add(top.val);
	    			stack.pop();
	    		}
	    		
	    		if (top.left != null){
	    			stack.push(top.left);
	    			top.left = null;
	    			continue;
	    		}
	    		
	    		if (top.right != null){
	    			stack.push(top.right);
	    			top.right = null;
	    			continue;
	    		}
	    			
	    	}
	        return list;
	    }
	}
	
	public static void main(String[] args) {
	}
}
