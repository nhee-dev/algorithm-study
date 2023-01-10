package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10814 { // 나이순 정렬 S5
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static class Elem implements Comparable<Elem> {
		String name;
		int age;
		int signIdx;
		
		@Override
		public int compareTo(Elem o) {
			
			if(age != o.age) return age - o.age;
			return signIdx - o.signIdx;
		}
	}
	
	static int pN;
	static Elem[] e;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int pN = Integer.parseInt(br.readLine());
		e = new Elem[pN];
		for(int i = 0; i < pN; i ++) {
			st = new StringTokenizer(br.readLine());
			e[i] = new Elem();
			e[i].age = Integer.parseInt(st.nextToken());
			e[i].name = st.nextToken();
			e[i].signIdx = i;
		}
	}
	
	static void solve() {
		Arrays.sort(e);
		for(int i = 0; i < e.length; i ++) {
			sb.append(e[i].age).append(" ").append(e[i].name).append("\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
