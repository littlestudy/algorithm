package org.stu.leetcode;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 即：
 *    (2 -> 4 -> 3)
 *   +			
 *    (5 -> 6 -> 4)
 * -------------------------
 *     7 -> 0 -> 8
 * @author ym
 * 方法：先将两个输入链表各自转成数字，向加，再将加得的和转成结果链表
 */
public class Add_Two_Numbers {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        long v1 = listToNum(l1);
	        long v2 = listToNum(l2);	        
	        
	    	return numToList(v1 + v2);
	    }
	    
	    public long listToNum(ListNode l){
	    	long result = 0;
	    	long time = 1;
	    	while (l != null){	    		
	    		result = l.val * time + result;
	    		time *= 10;
	    		l = l.next;
	    	}
	    	
	    	return result;
	    }
	    
	    public ListNode numToList(long num){
	    	if (num == 0)
	    		return new ListNode(0);
	    	
	    	ListNode head = new ListNode(-1);
	    	ListNode tail = head;	    	
	    	while (num != 0){
	    		ListNode node = new ListNode((int)(num % 10)); // 注意类型转换
	    		tail.next = node;
	    		tail = node;
	    		num /= 10;
	    	}
	    	return head.next;
	    }
	}
	
	public static void main(String[] args) {
		//  	{9}, {1,9,9,9,9,9,9,9,9,9}
		Add_Two_Numbers a = new Add_Two_Numbers();
		ListNode n1 = a.new ListNode(9);
		ListNode n2 = a.new ListNode(1);
		ListNode n3 = n2;
		for (int i = 0; i < 9; i++){
			ListNode node = a.new ListNode(9);
			n3.next = node;
			n3 = node;
		}
		Solution s = a.new Solution();
		long v1 = s.listToNum(n1);
		long v2 = s.listToNum(n2);
		System.out.println(v1 + " + " + v2 + " = " + (v1 + v2));
		
	}
}
