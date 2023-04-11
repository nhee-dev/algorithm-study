package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1431 {
	
	static class Elem implements Comparable<Elem> {
		String g;
		
		@Override
		public int compareTo(Elem o) {
			if(g.length() != o.g.length()) return g.length() - o.g.length();
			
			int gSum = 0;
			int oSum = 0;
			for(int i = 0; i < g.length(); i++) {
				if(g.charAt(i) - '0' < 10) gSum += g.charAt(i) - '0';
				if(o.g.charAt(i) - '0' < 10) oSum += o.g.charAt(i) - '0';
			}
			
			if(gSum != oSum) return gSum - oSum;
			
			return g.compareTo(o.g);
		}
	}
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N;
	static Elem[] gArr;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		gArr = new Elem[N];
		
		for(int i = 0; i < N; i ++) {
			gArr[i] = new Elem();
			gArr[i].g = br.readLine();
		}
		
	}
	
	static void solve() {
		Arrays.sort(gArr);
		for(int i = 0; i < N; i++) {
			sb.append(gArr[i].g).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws IOException { // 시리얼번호 S3 정렬
		input();
		solve();
	}

}
