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
 * 方法：先将两个输入链表各自转成字符串，各个位向加，注意进位
 */
public class Add_Two_Numbers2 {
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
	        String v1 = listToString(l1);
	        String v2 = listToString(l2);
	        
	        if (v1.length() < v2.length()) // 保证短的字符串在参数的第一个位置
	        	return add(v1, v2);
	        else 
	        	return add(v2, v1);
	    }
	    
	    public String listToString(ListNode l){
	    	StringBuilder sb = new StringBuilder();
	    	while (l != null){	    		
	    		sb.append(String.valueOf(l.val));
	    		l = l.next;
	    	}
	    	
	    	return sb.toString();
	    }
	    
	    public ListNode add(String s1, String s2){ //  保证短的字符串在参数的第一个位置
	    	ListNode head = new ListNode(-1);
	    	ListNode tail = head;
	    	int r = 0;
	    	for (int i = 0; i < s1.length(); i++){
	    		r += (((s1.charAt(i) - '0') & 0xff) + ((s2.charAt(i) - '0') & 0xff)); 
	    		ListNode node = new ListNode(r % 10);
	    		tail.next = node;
	    		tail = node;
	    		r /= 10;
	    	}
	    	
	    	for (int i = s1.length(); i < s2.length(); i++){
	    		r += ((s2.charAt(i) - '0') & 0xff);
	    		ListNode node = new ListNode(r % 10);
	    		tail.next = node;
	    		tail = node;
	    		r /= 10;
	    	}
	    	if (r == 1){ // 最后要判断下是否有进位，有进位需要插节点
	    		ListNode node = new ListNode(r % 10);
	    		tail.next = node;
	    		tail = node;
	    	}
	    	return head.next;
	    }	    
	}
	
	public static void main(String[] args) {
		//  	{9}, {1,9,9,9,9,9,9,9,9,9}
		Add_Two_Numbers2 a = new Add_Two_Numbers2();
		ListNode n1 = a.new ListNode(9);
		ListNode n2 = a.new ListNode(1);
		ListNode n3 = n2;
		for (int i = 0; i < 9; i++){
			ListNode node = a.new ListNode(9);
			n3.next = node;
			n3 = node;
		}
		Solution s = a.new Solution();
		String v1 = s.listToString(n1);
		String v2 = s.listToString(n2);
		System.out.println(v1 + " + " + v2);
		ListNode node = s.add(v1, v2);
		while (node != null){
			System.out.print(node.val + ",");
			node = node.next;
		}
	}
}
