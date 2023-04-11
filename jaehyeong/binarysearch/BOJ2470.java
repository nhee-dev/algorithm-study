package com.al.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2470 { // 두 용액 / G5 / 이분 탐색

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int N;
	static int[] arr;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static int A;
	static int B;
	static int minAbs;
	static void solve() {
		A = 0;
		B = 0;
		minAbs = Integer.MAX_VALUE;
		
		Arrays.sort(arr, 1, N+1);
		
		for(int i = 1; i <= N; i ++) {
			int idx = binary(arr, i+1, N, -arr[i]); // i 이후 부터 N 까지 중 절대값의 합이 0에 가장 가까운 원소 중 가운데 인덱스를 반환
			if(idx-1 > i && Math.abs(arr[i] + arr[idx-1]) < minAbs) {
				updateResult(i, idx-1);
			}
			if(idx <= N && Math.abs(arr[i] + arr[idx]) < minAbs) {
				updateResult(i, idx);
			}
			if(idx+1 <= N && Math.abs(arr[i] + arr[idx+1]) < minAbs) {
				updateResult(i, idx+1);
			}
		}
		
		sb = new StringBuilder();
		sb.append(A).append(" ").append(B);
		System.out.print(sb);
	}
	
	static int binary(int[] arr, int L, int R, int X) {
		int result = R+1;
		
		while(L <= R) {
			int mid = (L+R)/2;
			if(arr[mid] == X) {
				result = mid;
				break;
			}
			if(arr[mid] < X) {
				L = mid+1;
				result = mid;
			} else {
				R = mid-1;
				result = mid;
			}
		}
		
		return result;
	}
	
	static void updateResult(int i, int idx) {
		A = arr[i];
		B = arr[idx];
		minAbs = Math.abs(arr[i] + arr[idx]);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
