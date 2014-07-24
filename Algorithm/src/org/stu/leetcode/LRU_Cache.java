package org.stu.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.stu.leetcode.LRU_Cache.LRUCache.Node;

/**
 * 题目： Design and implement a data structure for Least Recently Used (LRU) cache. 
 *  	It should support the following operations: get and set.
 *		get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *
 *		set(key, value) - Set or insert the value if the key is not already present. 
 *			When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * 双向链表 + map
 * @author yaomin
 *
 */
public class LRU_Cache {
	public class LRUCache {		
		class Node {
			public int value;
			public int key;
			public Node(int key, int value){
				this.value = value;
				this.key = key;
				next = null;
				pre = null;
			}
			public Node next;
			public Node pre;
		}
		
		private int capacity;
		private int currentCount;
		private Node head;
		private Node tail;
		private Map<Integer, Node> map;
		public LRUCache(int capacity) {
			this.capacity = capacity;
			head = new Node(Integer.MIN_VALUE, -1);
			tail = null;
			currentCount = 0;
			map = new HashMap<Integer, LRU_Cache.LRUCache.Node>();
		}
    
		public int get(int key) {
			if (capacity == 0)
				return -1;
			
			Node n = map.get(key);
			if (n != null){
				moveToHead(n);
				return n.value;
			}
			
			return -1;
		}
    
		private void moveToHead(Node n) {
			if (currentCount == 1)
				return ;
			
			if (tail.key == n.key){
				tail = tail.pre;
				tail.next.pre = null;
				tail.next = null;
			} else {			
				n.pre.next = n.next;
				n.next.pre = n.pre;
			}
			
			n.next = head.next;
			head.next.pre = n;
			head.next = n;
			n.pre = head;			 
		}

		public void set(int key, int value) {
			if (capacity == 0)
				return;
			
			Node n = map.get(key);
			if (n != null){
				moveToHead(n);
				n.value = value;
				map.put(key, n);
				return ;
			}
			
			Node node = new Node(key, value);
			if (currentCount >= capacity){
				int k =removeTail();
				map.remove(k);
				currentCount--;				
			}
			insertToHead(node);
			map.put(key, node);
			currentCount++;
		}

		private void insertToHead(Node node) {
			if (currentCount == 0){
				head.next = node;
				node.pre = head;
				tail = node;
				return;
			}
			node.next = head.next;
			head.next.pre = node;
			head.next = node;
			node.pre = head;
		}

		private int removeTail() {
			int k = tail.key;
			if (currentCount == 1){				
				tail = null;
				head.next.pre = null;
				head.next = null;
				return k;
			}
			
			tail = tail.pre;
			tail.next.pre = null;
			tail.next = null;
			return k;
		}
	}
	
	public static void main(String[] args) {
		LRU_Cache l = new LRU_Cache();
		LRUCache lc = l.new LRUCache(2);
		lc.set(2, 1);
		lc.set(3, 2);
		lc.get(3);
		lc.get(2);
		lc.set(4, 3);
		//System.out.println(lc.map);
		lc.get(2);
		lc.get(3);
		lc.get(4);
		System.out.println(lc.get(2));
	}
}

