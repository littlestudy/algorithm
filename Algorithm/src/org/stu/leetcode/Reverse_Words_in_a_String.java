package org.stu.leetcode;

public class Reverse_Words_in_a_String {

	public class Solution {
		public String reverseWords(String s) {
			if (s == null)
				return null;
			
			String [] arr = s.split(" ");
			if (arr.length == 0)
				return "";
							
			StringBuilder builder = new StringBuilder();
			
			for (int i = arr.length - 1; i >= 0; i--){
				builder.append(arr[i]);
				if (i > 0 && !arr[i - 1].equals(""))
					builder.append(" ");
			}
			return builder.toString();
		}
	}
	
	public static void main(String[] args) {
		Reverse_Words_in_a_String r = new Reverse_Words_in_a_String();
		Solution s = r.new Solution();
		String result = s.reverseWords("   1  2");
		System.out.println(result);
	}
}
