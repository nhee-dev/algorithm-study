package com.al.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ10816S { // 숫자카드 2 / S4 / 이분 탐색
	
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static int[] nArr;
	static int[] mArr;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		nArr = new int[N+1];
		for(int i = 1; i <= N; i ++) { 
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		mArr = new int[M+1];
		for(int i = 1; i <= M; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static StringBuilder sb;
	static void solve()	{
		sb = new StringBuilder();
		
		Arrays.sort(nArr, 1, N+1);
		
		// 원소 M개 만큼 반복한다.
		for(int i = 1; i <= M; i++) {
			int ans = 0;
			// 이분탐색으로 X와 같거나 큰 최소 idx를 반환한다.
			int minIdx = lower_binary(nArr, 1, N, mArr[i]);
			// 이분탐색으로 X보다 큰 최소 idx를 반환한다.
			int maxIdx = upper_binary(nArr, 1, N, mArr[i]);
			
			// X와 같은 값이 없으면 0일 것이다.
			ans += maxIdx - minIdx;
			
			sb.append(ans).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static int lower_binary(int[] A, int L, int R, int X) {
		// 있겠지만, 없으면 0을 반환 할 것이다.
		int result = R+1;
		
		while(L <= R) {
			int mid = (L+R)/2;
			if(A[mid] >= X) {
				result = mid;
				R = mid-1;
			} else {
				L = mid+1;
			}
		}
		
		return result;
	}
	
	static int upper_binary(int[] A, int L, int R, int X) {
		// 있겠지만, 없으면 0을 반환 할 것이다.
		int result = R+1;
		
		while(L <= R) {
			int mid = (L+R)/2;
			if(A[mid] > X) {
				result = mid;
				R = mid-1;
			} else {
				L = mid+1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
