package com.al.permutationN;

import java.io.*;
import java.util.*;

public class BOJ15665 {
	
	static BufferedReader br;
	static StringTokenizer st;

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		nums = new int[N+1];
		for(int i = 1; i <= N; i ++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		selected = new int[M+1];
		visited = new boolean[N+1];
		
	}

	
	static int N, M;
	static int[] nums, selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	static void solve() {
		Arrays.sort(nums, 1, N+1);
		
		rec_func(1);
		
		System.out.println(sb);
	}
	
	static void rec_func(int depth) {
		if(depth == M+1) {
			print();
			return;
		}
		
		int last = -1;
		for(int i = 1; i <= N; i++) {
			if(last == nums[i]) continue;
			
			last = nums[i];
			selected[depth] = nums[i];
			rec_func(depth+1);
		}
	}
	
	static void print() {
		for(int i = 1; i <= M; i++) {
			sb.append(selected[i]).append(" ");
		}
		sb.append("\n");
	}
	
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
