package org.stu.leetcode;

public class Evaluate_Reverse_Polish_Notation {
	public class Solution {
		public int evalRPN(String[] tokens) {
			
			int []stack = new int[tokens.length];
			int pos = 0;
			
			String regex = "(-{1}[0-9]+)|([0-9]*)"; // 
			String regex2 = "(-{1}\\d+)|(\\d*)";	// 两个正则表达式效果一样
			for (int i = 0; i < tokens.length; i++){
				
				if(tokens[i].matches(regex2)){
					stack[pos++] = Integer.parseInt(tokens[i]);					
				} else {
					int tmp = 0;
					switch (tokens[i]) {
					case "+":
						tmp = stack[pos - 2] + stack[pos - 1];
						break;
					case "-":
						tmp = stack[pos - 2] - stack[pos - 1];
						break;
					case "*":
						tmp = stack[pos - 2] * stack[pos - 1];
						break;
					case "/":
						tmp = stack[pos - 2] / stack[pos - 1];
						break;
					}
					pos--;
					stack[pos - 1] = tmp;
				}
			}
			return stack[0];
		}
	}
	
	public static void main(String[] args) {
		Evaluate_Reverse_Polish_Notation e = new Evaluate_Reverse_Polish_Notation();
		Solution s = e.new Solution();
		String [] str = {"3","-4","+"};
		int result = s.evalRPN(str);
		System.out.println(result);
	}
}
