package org.stu;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("helloworld");
		String a = "-12";
		String regx = "(-{1}[0-9]+)|([0-9]*)";
		System.out.println(a.matches("(-{1}\\d+)|(\\d*)"));
		System.out.println(Integer.parseInt("-100"));
		System.out.println(((int)Math.sqrt(1 * 8 + 1) + 1) / 2);
		System.out.println(Integer.MIN_VALUE);
	}

}
