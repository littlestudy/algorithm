package org.stu.leetcode;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author ym
 * 使用StringBuilder存放便利字符串时的子串，当出现重复元素后，判断长度，找到sb中相同元素的位置的下一个位置，sb的重建位置从该位置开始。
 */
public class Longest_Substring_Without_Repeating_Characters {

	public class Solution {
		public int lengthOfLongestSubstring(String s) {
			if (s == null || s.length() == 0)
				return 0;
			
			int len = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++){
				if(sb.toString().contains(s.substring(i, i + 1))){
					len = sb.toString().length() > len ? sb.toString().length() : len;
					int start = sb.toString().indexOf(s.substring(i, i + 1)) + 1; // 找到sb中相同元素的位置的下一个位置
					sb = new StringBuilder(sb.toString().substring(start));	// sb新建的时候是从原来sb中start位置的元素开始重建				
				}
				sb.append(s.substring(i, i + 1));				
			}
			
			len = sb.toString().length() > len ? sb.toString().length() : len; // 推出循环后要再比较一次长度
			
			return len;
		}
	}
	
	public static void main(String[] args) {
		Longest_Substring_Without_Repeating_Characters l = new Longest_Substring_Without_Repeating_Characters();
		Solution s = l.new Solution();
		String str = "qopubjguxhxdipfzwswybgfylqvjzhar";
		System.out.println(s.lengthOfLongestSubstring(str));
	}
}
