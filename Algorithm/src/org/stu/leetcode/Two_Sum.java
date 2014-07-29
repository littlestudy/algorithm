package org.stu.leetcode;

import java.util.HashMap;
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
 */
public class Two_Sum {
	public class Solution {
	    public int[] twoSum(int[] numbers, int target) {
	    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    	for (int i = 0; i < numbers.length; i++)
	    		map.put(numbers[i], i);
	    	
	    	for (int i = 0; i < numbers.length; i++){
	    		int other_value = target - numbers[i];
	    		Integer op2 = map.get(other_value);
	    		if (op2 != null && op2 != i)
	    			return new int [] {i + 1, map.get(target - numbers[i]) + 1};
	    	}
	    	return null;
	    }
	}
	
	public static void main(String[] args) {
		Two_Sum t = new Two_Sum();
		Solution s = t.new Solution();
		int[] arr = new int [] {3,2,4};
		int [] result = s.twoSum(arr, 6);
		if (result != null)
			System.out.println(result[0] + "," + result[1]);
	}
}
