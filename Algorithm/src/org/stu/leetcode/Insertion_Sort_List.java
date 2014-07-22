package org.stu.leetcode;
/**
 * 题目：Sort a linked list using insertion sort.
 * @author yaomin
 *
 */
public class Insertion_Sort_List {

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
		public ListNode insertionSortList(ListNode head) {
			if (head == null || head.next == null)
				return head;
			
			ListNode sortedList = new ListNode(Integer.MIN_VALUE);
			sortedList.next = head;					
			ListNode originalList = head.next;
			sortedList.next.next = null;
			ListNode p;	
			ListNode q;
			while (originalList != null){
				p = sortedList;
				q = originalList;				
				originalList = originalList.next;
				q.next = null;
				while (true){
					if (p.next == null || p.next.val > q.val ){
						ListNode tmp = p.next;
						p.next = q;
						q.next = tmp;
						break;
					} else {
						p = p.next;
					}
				}
			}
			
			return sortedList.next;
		}
	}
	
	public static void main(String[] args) {
		Insertion_Sort_List i = new Insertion_Sort_List();
		Solution s = i.new Solution();
		
		ListNode a = i.new ListNode(1);
		ListNode b = i.new ListNode(1);
		a.next = b;
		
		ListNode t = s.insertionSortList(a);
		while (t != null){
			System.out.print(t.val + ",");
			t = t.next;
		}
	}
}

































