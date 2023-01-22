package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N;
	static int[] pArr;
	static int[] solArr;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		pArr = new int[N];
		solArr = new int[N];
		for(int i = 0; i < N; i ++) {
			pArr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static int result;
	static void solve() {
		Arrays.sort(pArr);
		
		solArr[0] = pArr[0];
		for(int i = 1; i < N; i ++) {
			solArr[i] = solArr[i-1] + pArr[i];
		}
		
		for(int i = 0; i < N; i ++) {
			result += solArr[i];
		}
		System.out.println(result);
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
