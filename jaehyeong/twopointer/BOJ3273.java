package com.al.twopointer;

import java.util.*;
import java.io.*;

public class BOJ3273 { // S3 / 두 수의 합 / Twopointer

	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, X;
	static int[] arr;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		X = Integer.parseInt(br.readLine());
	}
	
	static void solve() {
		Arrays.sort(arr);
		
		// L, R을 조정할 것이다.
		int answer = 0;
		int L = 0, R = N-1;
		while(L<R) {
			int sum = arr[L] + arr[R];
			if(sum == X) {
				answer++; L++; R--;
			}
			else if(sum < X) { // 값이 커져야 한다.
				L++;
			} else {// 값이 작아져야 한다.
				R--;
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
/*
최대 10만개의 1~100만 사이의 수가 주어진다.
1~200만 사이의 X가 주어진다.
i + j가 X가 되게하는 i,j 수를 구하라.

1. 간단한 접근
	각 요소마다 다른 요소를 모두 더해 본다.
	10만*10만
2. 이분 탐색
	각 요소마다 다른 요소 중 X가 되는 값을 찾는다.
	10만*log10만
3. 투 포인터
	i < j 이어야 한다. 그러나 i,j 위치가 바뀌어도 같다. 한 번만 계산하면 된다.
	따라서 정렬한다. 10만 log10만
	
	최소 + 최대 < X 이면 L++
	최소 + 최대 > X 이면 R--
	최소 + 최대 == X 이면 L++ R--
	L<R인 동안 진행

*/
