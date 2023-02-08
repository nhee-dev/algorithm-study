package com.al.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1920 { // 수 찾기 / S4/ 이분 탐색
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, M;
	static int[] A, B;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		st= new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		B = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() throws IOException {
		Arrays.sort(A, 1, N+1);
		
		
		int result = 0;
		for(int i = 1; i <= M; i++) {
			result = binary(B[i]); // 타겟이 있는지 확인 후 1,0 반환
			System.out.println(result);
		}
	}
	
	static int binary (int X) {
		int L = 1;
		int R = N;
		while(L <= R) {
			int mid = (L+R) / 2;
			if(A[mid] == X) return 1;
			if(A[mid] < X) L = mid + 1;
			if(A[mid] > X) R = mid - 1;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException { 
		input();
		solve();
	}

}

/*
N개의 정수 중 X가 존재하는 지 확인하는 문제이다.

1. 최댓값
존재 하는지, 아닌지 만 판단하므로 계산 값은 필요하지 않다.

2. 단순풀이
A 배열의 각 원소에 대해서, B 배열의 각 원소를 탐색해 존재하는지 확인한다.
시간 복잡도는 N*M = 100000 * 100000 이다. 당연히 시간초과다.

3. 이분 탐색
A 배열을 정렬하고, B배열의 원소마다 A 배열을 이분 탐색한다. 
시간 복잡도는 NlogN 100000log100000 = 170만
원소별 이분탐색은 MlogN 100000log100000 이다.
충분한 시간이므로 풀이를 할 수 있다.

- 입력
A 크기
A 배열 수
B 크기
B 배열 수
- 출력
존재 1
부존재 0
*/