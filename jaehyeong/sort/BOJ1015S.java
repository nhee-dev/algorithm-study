package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1015S { // 수열 정렬 S4
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static class Elem implements Comparable<Elem> {
		int num, idx;
		
		public int compareTo(Elem other) {
			if(num != other.num) return num - other.num;
			return idx - other.idx;
		}
	}
	
	static int arrN;
	static Elem[] a;
	static int[] p;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		arrN = Integer.parseInt(br.readLine());
		a = new Elem[arrN];
		p = new int[arrN];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < arrN; i++) {
			a[i] = new Elem();
			a[i].num = Integer.parseInt(st.nextToken());
			a[i].idx = i;
		}
	}
	
	
	static void solve() {
		Arrays.sort(a);
		for(int i = 0; i < a.length; i++) {
			p[a[i].idx] = i;
		}
		for(int i = 0; i < p.length; i++) {
			sb.append(p[i]).append(" ");
		}
		System.out.println(sb);
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
