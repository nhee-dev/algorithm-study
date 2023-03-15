package com.al.string;

import java.io.*;
import java.util.*;

public class BOJ1120R { // 문자열 // S4 // 문자열
	static BufferedReader br;
	static StringTokenizer st;
	
	static String A, B;
	static int min;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = st.nextToken();
	}
	
	static void solve() {
		min = 51;
		// B 배열의 각 위치에 A 배열을 위치 시킨다./ A와 B의 차이를 계산한다. / 최솟값을 갱신한다.
		for(int loc = 0; loc <= (B.length() - A.length()); loc++) {
			int dif = 0;
			for(int i = 0; i < A.length(); i++) {
				if(A.charAt(i) == B.charAt(i+loc)) continue;
				dif++;

			}
			min = Math.min(min,dif);
		}
		
		System.out.println(min);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
