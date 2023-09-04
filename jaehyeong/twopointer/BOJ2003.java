package com.al.twopointer;

import java.util.*;
import java.io.*;

public class BOJ2003 { // 수들의 합 2 / S4 / twopointer

	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, M;
	static int[] arr;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		int answer = 0;
		int sum = arr[0];
		
		for(int L = 0, R = 0; L < N; L++) {
			if(L>R) {
				R++; sum+=arr[R];
			}
			
			while(R < N-1 && sum < M) {
				R++; sum+=arr[R];
			}
			
			if(sum == M) {
				answer++;
			}
			
			sum-=arr[L];
		}
		
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
주어진 수열에서, 연석된 원소의 합이 M이 되는 경우의 수는?

각 원소마다 원소 하나~끝까지 더해본다. ... 시간 초과

자연수이므로, 원소를 더하면 반드시 커진다.
따라서 sum < M이면 R 증가
sum==M이면 answer++ R 증가
sum > M이면 L 증가
sum < M이면 R 증가
15
16 16 16 16 15

11
21 L>R R++

*/