package com.al.permutationN;

import java.io.*;
import java.util.*;

public class BOJ15664 { // N과 M (10) / S2 / 수열  // 개선된 방법을 사용해 보자.

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
	}
	
	
	static int N, M;
	static int[] nums, selected;
	static StringBuilder sb = new StringBuilder();
	
	static void solve() {
		Arrays.sort(nums, 1, N+1);
		
		rec_func(1, 1);
		
		System.out.print(sb);
	}
	
	static void rec_func(int start, int k) {
		if(k == M+1) {
			print();
			return;
		}
		
		int last = -1;
		for(int i = start; i <= N; i ++) {
			if(last == nums[i]) continue;
			
			last = nums[i];
			selected[k] = nums[i];
			rec_func(i+1, k+1);
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
