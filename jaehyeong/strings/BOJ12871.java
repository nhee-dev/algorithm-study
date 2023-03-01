package com.al.string;

import java.io.*;
import java.util.*;

public class BOJ12871 { // 무한 문자열 / S5 / 문자열, 최소공배수 - Math

	static BufferedReader br;
	static StringBuilder sb1, sb2;
	
	static String s1, s2;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb1 = new StringBuilder();
		sb2 = new StringBuilder();
		
		s1 = br.readLine();
		s2 = br.readLine();
	}
	
	static void solve() {
		int gcd = gcd(Math.max(s1.length(), s2.length()),
				Math.min(s1.length(), s2.length()));
		int lcm = lcm(s1.length(),s2.length(), gcd);
		
		for(int i = 0; i < lcm/s1.length(); i++) {
			sb1.append(s1);
		}
		
		for(int i = 0; i < lcm/s2.length(); i++) {
			sb2.append(s2);
		} 
		
		int result = 0;
		if(sb1.toString().equals(sb2.toString())) result = 1;
		System.out.println(result);
	}
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		
		return gcd(b, a%b);
	}
	
	static int lcm(int a, int b, int gcd) {
		return (a*b)/gcd;
	}
	
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
