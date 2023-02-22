package com.al.determination;

import java.util.*;
import java.io.*;

public class BOJ2110 { // 공유기 설치 / G4 / 이분 탐색 - 매개변수 탐색

	static BufferedReader br;
	static StringTokenizer st;
	static int N; // 집의 수
	static int C; // 공유기 수
	static int[] houses;
	static int MIN_DISTANCE = 1; // 공유기 사이 거리는 0이 될 수 없다!
	static int MAX_DISTANCE = 1000000000;
	
	static void input () throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		houses = new int[N+1];
		for(int i = 1; i <= N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
	}
	
	static void solve() {
		Arrays.sort(houses, 1, N+1);
		
		// 이분 탐색으로 가장 가까운 공유기 사이 거리의 최대 값을 얻는다.
		int ans = binary(MIN_DISTANCE, MAX_DISTANCE);
		
		System.out.print(ans);
	}
	
	static int binary(int L, int R) {
		// 답은 나오 겠지만, 못찾으면 -1을 리턴한다.
		int result = L-1;
		
		while(L <= R) {
			int mid = (L + R) / 2;
			
			// mid 만큼의 거리를 둘 때, 설치 가능한가?
			if(determination(mid)) {
				result = mid;
				L = mid+1;
			} else {
				R = mid-1;
			}
		}
		
		return result;
	}
	
	static boolean determination (int D) {
		
		boolean result = false;

		int cnt = 1;
		int last = houses[1];
		for(int i = 2; i <= N; i++) {
			if(cnt == C) {
				result = true;
				break;
			}
			
			if(houses[i] - last >= D) {
				last = houses[i];
				cnt++;
			}
		}
				
		return result;
	}
	
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
