package com.al.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ3273 { // 두 수의 합 / S3 / 이분 탐색
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N+1];
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		X = Integer.parseInt(br.readLine());
	}
	
	
	static int N, X;
	static int[] nums;
	
	static void solve()	{
		Arrays.sort(nums, 1, N+1);
		
		int ans = 0;
		for(int i = 1; i <= N; i ++) {
			
			// i+1 ~ N 사이의 값 중  nums[i]와 더하여 X가 나오는 값이 있는지 찾는다.
			if(binary(nums, i+1, N, X - nums[i])) ans++;
		}
		
		System.out.print(ans);
	}
	
	static boolean binary(int[] A, int L, int R, int X) {
		boolean result = false;
		
		int mid = 0;
		while(L <= R) {
			mid = (L+R) / 2;
			
			if(nums[mid] == X) {
				result = true;
				break;
			} else if(nums[mid] > X) {
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
