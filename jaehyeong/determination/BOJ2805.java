package com.al.determination;

import java.io.*;
import java.util.*;

public class BOJ2805 { // 나무 자르기 / S2 / 매개변수 탐색 - 이분 탐색
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int M; // 목표길이
	static int N; // 나무의 수
	static int[] trees; // 나무들
	static int MIN_HEIGHT = 0; // 나무의 최소 높이
	static int MAX_HEIGHT = 2000000000; // 나무의 최대 높이
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new int [N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i ++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		// 나무 배열을 정렬한다.
		Arrays.sort(trees, 1, N+1);
		
		// 이분 탐색을 하여 최대 H를 찾는다.
		int ans = binary(MIN_HEIGHT, MAX_HEIGHT);
		
		// H를 출력한다.
		System.out.print(ans);
	}
	
	static int binary(int L, int R) {
		
		int result = L-1;
		
		// 0 ~ 20억 을 이분 탐색으로 탐색한다.
		while(L <= R) {
			int mid = (int) (L+R) / 2; // int 값 넘어서 long 된 후 int로 변환
			
			// determination으로 해당 H가 M을 만족하면 L+1, 아니면 R+1로 갱신한다.
			if(determination(mid)) {
				result = mid;
				L = mid+1;
			} else {
				R = mid-1;
			}		
		}
	
		// L 최대값을 H로 반환한다.
		return result;
	}
	
	// H로 나무들을 잘라 얻은 합이 M보다 크거나 같은지 확인한다.
	static boolean determination(int H) {
		long sum = 0;
		
		for(int i = 1; i <= N; i ++) {
			if(trees[i] > H) {
				sum += trees[i] - H;
			}
		}
		
		return sum >= M;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
