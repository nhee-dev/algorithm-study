package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11728 { // 배열합치기 S5 정렬
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int N;
	static int M;
	static int[] arr;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = N; i < N+M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		Arrays.sort((arr));
		for(int i = 0; i < N+M; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
