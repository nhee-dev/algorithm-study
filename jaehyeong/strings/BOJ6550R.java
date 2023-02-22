package com.al.string;

import java.util.*;
import java.io.*;

public class BOJ6550R { // 부분 문자열 / S5 / 문자열 ... 투포인터? // 다시 풀기 .. 문자열 어렵다

	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static String s1;
	static String s2;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if(s.equals("")) break;
			
			st = new StringTokenizer(s);
			s1 = st.nextToken();
			s2 = st.nextToken();
			
			solve();
		}
	}
	
	static void solve() {
		 int s1Idx = 0;
         int s2Idx = 0;
         while (s1Idx < s1.length()) {
             while (s2Idx < s2.length() && s2.charAt(s2Idx) != s1.charAt(s1Idx)) s2Idx++;
             if (s2Idx < s2.length() && s1.charAt(s1Idx) == s2.charAt(s2Idx)) { 
            	 s1Idx++; s2Idx++; 
            }
             else break;
         }
         sb.append(s1Idx == s1.length() ? "Yes\n" : "No\n");
	}
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.print(sb);
	}

}
