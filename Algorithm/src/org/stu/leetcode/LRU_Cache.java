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
			
		}

		public void set(int key, int value) {
			if (capacity == 0)
				return;
			
			Node n = map.get(key);
			if (n != null){
				moveToHead(n);
				return ;
			}
			
			Node node = new Node(key, value);
			if (currentCount >= capacity){
				removeTail();
				currentCount--;
			}
			insertToHead(node);
			currentCount++;
		}

		private void insertToHead(Node node) {
			// TODO Auto-generated method stub
			
		}

		private void removeTail() {
			// TODO Auto-generated method stub
			
		}
	}
}
