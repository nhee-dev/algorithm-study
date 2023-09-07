package com.al.twopointer;

import java.util.*;
import java.io.*;

public class BOJ2470 {
	
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] arr;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
	}
/*
	정렬한다.
	L = 0, R = N-1
	L+R과 0을 비교한다.
	L < R 동안
	0이면 종료
	<0이면 가장 작은 용액의 최적값을 minAnswer과 비교한다. L++
	>0이면 가장 큰 용약의 최적값을 minAnser와 비교한다. R--
*/	
	static void solve() {
		// 정렬
		Arrays.sort(arr);
		
		int A = 0; int B = 0; int min = Integer.MAX_VALUE;
		// L, R 결정
		int L = 0; int R = N-1;
		// L < R 동안
		while(L<R) {
			int sum = arr[L] + arr[R];
			System.out.println(L + " L + R " + R + " sum " + sum);

			if(sum == 0) { // 0이면 최적이니 종료
				System.out.println(arr[L] + " A : B " + arr[R]);
				A = arr[L]; B = arr[R];
				break;
			}
			// -105 -15 7 15 100
			if(Math.abs(sum) < min) {
				System.out.println(arr[L] + " A : B " + arr[R]);
				A = arr[L]; B = arr[R];
				min = Math.abs(sum);
			}
			
			if(sum < 0) { // 최소 + 최대 가 커져야하므로 최대는 현재가 끝
				L++;
			} else { // 최소 + 최대가 작아져야 하므로 최소는 현재가 끝
				R--;
			}
		}
		
		System.out.println(A + " " +  B);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
용액값이 주어진다. 더해서 0에 가장 가까운 두 용액을 찾자.

- 이분 탐색 : 각 용액에 대해, 0에 가장 가까운 값을 찾는다.
			N * lonN + NLogN(정렬)

- 투 포인터 : 가장 작은 용액과 가장 큰 용액을 비교한다.
			합이 0 : 정답이다.
			합 < 0 : 값이 커져야 한다. 가장 작은 용액의 0에 가장 가까운 값은 가장 큰 용액이다.
			합 > 0 : 값이 작아져야 한다. 가장 큰 용약의 0에 가장 가까운 갑은 가장 작은 용약이다.
			NLogN + N + N ... 좀 더 낫다.
			
정렬한다.
L = 0, R = N-1
L+R과 0을 비교한다.
L < R 동안
0이면 종료
<0이면 가장 작은 용액의 최적값을 minAnswer과 비교한다. L++
>0이면 가장 큰 용약의 최적값을 minAnser와 비교한다. R--

*/