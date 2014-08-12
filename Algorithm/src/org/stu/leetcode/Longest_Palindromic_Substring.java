package org.stu.leetcode;

/**
 * 题目：Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 求最长回文子串
 * @author ym
 * 方法：遍历每个字符，1）以这个字符为中心，向两边检测；2）以这个字符和它右边的字符为起始向两边检查
 * 				找到最长回文子串
 */
public class Longest_Palindromic_Substring {
	public class Solution {
	    public String longestPalindrome(String s) {	    		    	
	    	String p = "";
	    	for (int i = 0; i < s.length(); i++){
	    		String s1 = getPalindrome(s, i, i); // 从同一个字符开始向两边检查
	    		String s2 = getPalindrome(s, i, i + 1); // 从相邻两个字符开始向两边检查
	    		if (s1.length() > p.length())
	    			p = s1;
	    		if (s2.length() > p.length())
	    			p = s2;
	    	}
	    	
	        return p;
	    }
	    
	    public String  getPalindrome(String s, int posl, int posr){	    	
	    	while (posl >= 0 && posr < s.length()){
	    		if (s.charAt(posl) != s.charAt(posr)){
	    			break;
	    		}
	    		posl--;
	    		posr++;
	    	}
	    	
	    	return s.substring(posl + 1, posr);
	    }
	}
	
	public static void main(String[] args) {
		Longest_Palindromic_Substring l = new Longest_Palindromic_Substring();
		Solution s = l.new Solution();
		String str = "cdaba";
		System.out.println(s.longestPalindrome(str));
	}
}
