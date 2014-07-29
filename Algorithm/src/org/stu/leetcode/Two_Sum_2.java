package org.stu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2 
 * @author ym
 *
 * 解法：
 * 1）先将数组的每一个值和对应位置下标放到Node类中，这个类还要实现Comparable接口，同时将每一个Node类放到list中
 * 2）对list排序
 * 3）遍历排好序的list：
 * 采用两个指针分别在list的前后。如果指针对应数的和大于target，则右边指针左移；反之左边指针右移，直到找到解为止（题目条件给出必然有解）。
 * 这样是一个时间复杂度为O(n)的操作，配合时间复杂度O(n log n)的排序，总共时间复杂度是O(n log n)。
 * 这里需要考虑排序前后数组序数的对应问题。
 */
public class Two_Sum_2 {
	public class Solution{
		class Node implements Comparable<Node>{
			public int value;
			public int pos;
			
			public Node (int value, int pos){
				this.value = value;
				this.pos = pos;
			}
			@Override
			public int compareTo(Node o) {
				return value - o.value;
			}

		}
	    public int[] twoSum(int[] numbers, int target) {
	    	
	    	List<Node> list = new  ArrayList<Node>();
	    	for (int i = 0; i < numbers.length; i++){
	    		list.add(new Node(numbers[i], i));
	    	}
	    	
	    	int index1 = 0;
	    	int index2 = list.size() - 1;
	    	Collections.sort(list);
	    	while (index1 < index2){
	    		Node a = list.get(index1);
	    		Node b = list.get(index2);
	    		if (a.value + b.value == target)
	    		{
	    			if (a.pos > b.pos)
	    				return new int [] {b.pos+ 1, a.pos + 1};
	    			else 
	    				return new int [] {a.pos+ 1, b.pos + 1};
	    		}
	    		else if (a.value + b.value > target)
	    			index2--;
	    		else 
	    			index1++;
	    	}
	    	return null;
	    }
	}
	
	public static void main(String[] args) {
		Two_Sum_2 t = new Two_Sum_2();
		Solution s = t.new Solution();
		int[] arr = new int [] {3,2,4};
		int [] result = s.twoSum(arr, 6);
		if (result != null)
			System.out.println(result[0] + "," + result[1]);
	}
}
