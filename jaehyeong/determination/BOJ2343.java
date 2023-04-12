package com.al.determination;

import java.util.*;
import java.io.*;

public class BOJ2343 { // 기타레슨 / S1 / 이분탐색
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, M, sum; // 강의 수 , 블루레이 수
	static int[] lectures;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lectures = new int[N];
		
		if(N != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i ++) {
				lectures[i] = Integer.parseInt(st.nextToken());
			}	
		}
	}
	
	static void solve() {
		// L값을 구한다.
		long left = 0;
		for (int i = 0; i < N; i++) left = Math.max(left, lectures[i]);  

		// R값을 구한다.
		long sum = 0;
		for(int i : lectures) sum += i;
		
		// 이분 탐색으로 최솟 값을 찾는다.
		long answer = binary(left, sum);
		
		// 출력한다.
		System.out.println(answer);
	}
	
	static long binary(long L, long R) {
		long result = R;
				
		while(L <= R) {
			long mid = (L + R) / 2;
			System.out.println(mid);
			// mid 크기의 블루레이 M개에 강의를 모두 담을 수 있는가?
			if(determine(mid)) {
				R = mid - 1;
				result = mid;
			} else {
				L = mid + 1;
			}
		}
		
		return result;
	}
	
	static boolean determine(long X) {
		int m = 1; long nowX = X;
		for(int i : lectures) {
			if(nowX >= i) {
				nowX -= i;
			} else {
				m++;
				nowX = X;
				nowX -= i;
			}
			// 목표치 보다 크면 종료시킨다.
			if(m > M) break;
		}
		
		// 블루레이 수가 목표치 보다 작거나 같으면  넣을 수 있음
		return m <= M;
	}

	public static void main(String[] args) throws IOException  {
		input();
		solve();
	}

}

/*
 - 크기가 고정된 M개의 블루레이가 있다.
 - 블루레이 하나에는 N개의 강의가 들어 간다.
 - 강의의 길이 가 주어질 때, 블루레이의 크기 중 최소를 구하라.
 
 - 1 <= M, N <=10만
 - 강의 길이 1만 분 이하

1. 정답의 최대치 
	블루레이 크기 : 1개에 10만개, 전부 1만 분이면 ... long을 쓰자.
2. 간단한 접근
	강의를 다 더한 값을 최대 블루레이 크기로 보고, /M 한 블루레이에 다 들어가는지 확인해 본다.
	... 1억을 넘어가기 때문에 안된다.
3. 개선된 접근
	최솟값이므로 이분 탐색을 써보자.
	문제는 M개의 블루레이에 강의들을 ~분 까지 넣을 수 있을 때, 블루레이의 크기 중 최소는?
	블루레이 크기가 X일 때, M개의 블루레이에 강의를 모두 넣을 수 있는가?
	
	블루레이 크기가 클 수록 모두 넣을 수 있으므로 nonono yesyes 가 된다.
	따라서 블루레이 크기 1 <= 총합을 이분 탐색하여, 강의를 넣을 수 있는 블루레이 크기의 최솟값을 구하자.
4. 시간 복잡도
	결정하는데 N의 시간 복잡도
	이분탐색이 log1000000000 ... 충분해 보인다.
5. 예시
	M 1개, 강의가 10억 3개
	M 1개, 강의 0

*/
