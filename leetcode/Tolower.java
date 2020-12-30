package leetcode;

import java.util.Scanner;

public class Tolower {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		System.out.println(helper(n));
		sc.close();
	}
	
	static String helper(String s) {
//		char ch[] = s.toCharArray();
//		char s2[] = new char[ch.length];
//		for (int i = 0; i < ch.length; i++)
//		{
//		s2[i]=ch[i].toLowerCase();
//		 
//		}
//		return ch.toString();
		return s.toLowerCase();
	}

}
