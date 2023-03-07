package com.al.backtracking;

import java.io.*;
import java.util.*;

public class BOJ1182 { // 부분 수열의 합 / S2 / 백트레킹
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N;
	static int S;
	static int[] nums;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N+1];
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static int ans;
	static void solve()	{
		ans = 0;
				
		permutation(1, 0, 1);
		
		if(S == 0) ans--;
		
		System.out.println(ans);
	}
	
	static void permutation(int depth, int sum, int start) {
		if(sum == S) ans++;
		if(depth == N+1) return;
		
		for(int i = start; i <= N; i++) {
				permutation(depth+1, sum+nums[i], i+1);

		}
		
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
