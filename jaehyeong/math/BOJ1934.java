package com.al.math;

import java.io.*;
import java.util.*;

public class BOJ1934 { // 최소공배수 // B1 // 최소공배수 - Math

	static BufferedReader br;
	static StringTokenizer st;
	
	static int T, A, B;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			solve();
		}
	}
	
	static StringBuilder sb;
	static void solve() {		
		int gcd = gcd(A, B);
		int lcm = lcm(A, B, gcd);
		
		sb.append(lcm).append("\n");
	}
	
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	
	static int lcm(int a, int b, int gcd) {
		return (a*b) / gcd;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(sb);
	}

}
