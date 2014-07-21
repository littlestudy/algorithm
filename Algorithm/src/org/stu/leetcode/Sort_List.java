package org.stu.leetcode;

/**
 * 题目：Sort a linked list in O(n log n) time using constant space complexity.
 * 使用归并方法排序
 * @author yaomin
 *
 */
public class Sort_List {

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
 
	public class Solution {
		public ListNode sortList(ListNode head) {
			if (head == null || head.next == null)
				return head;
			
			ListNode mid = getMid(head);
			ListNode l1 = head;
			ListNode l2 = mid.next;
			mid.next = null;
			ListNode p1 = sortList(l1);
			ListNode p2 = sortList(l2);
			
			return merge(p1, p2);
		}
	
	
		public ListNode getMid(ListNode head){
			if (head == null || head.next == null)
				return head;
			
			ListNode slow = head;
			ListNode fast = head.next;
			
			while (fast != null && fast.next != null){
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}
		
		public ListNode merge(ListNode p1, ListNode p2){			
			ListNode t = new ListNode(0);
			ListNode newHead = t;
			
			while (p1 != null && p2 != null){
				if (p1.val > p2.val){
					t.next = p2;
					p2 = p2.next;
				} else {
					t.next = p1;
					p1 = p1.next;
				}
				t = t.next;
			}
			
			if (p1 != null){
				t.next = p1;
			} else {
				t.next = p2;
			}
			
			return newHead.next;
		}
	}
	
	public static void main(String[] args) {
		Sort_List s = new Sort_List();
		Solution so = s.new Solution();			
		
		ListNode a = s.new ListNode(3);
		ListNode b = s.new ListNode(2);
		ListNode c = s.new ListNode(4);
		a.next = b;
		b.next = c;
		
		ListNode sortedList = so.sortList(a);
		while (sortedList != null){
			System.out.print(sortedList.val + ",");
			sortedList = sortedList.next;
		}
	}
	
}




































