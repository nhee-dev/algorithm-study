package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11004 { // K번째수 S5 정렬
	static BufferedReader br;
	static StringTokenizer st;
	
	static int numN;
	static int target;
	static int[] nums;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		numN = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		nums = new int[numN];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < numN; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		Arrays.sort(nums);
		

		System.out.print(nums[target-1]);
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
