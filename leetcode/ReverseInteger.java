package leetcode;

import java.util.Scanner;

public class ReverseInteger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solve(n));
		sc.close();
	}
	
	static int solve(int n) {										
		long rev = 0;
		
		while(n != 0) {
			rev = rev * 10 + (n%10);
			n /= 10;
		}
		
		if(rev > Integer.MAX_VALUE) return 0;
		
		return (int)rev;
	}

}
