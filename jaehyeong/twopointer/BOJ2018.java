package com.al.twopointer;

import java.util.*;
import java.io.*;

public class BOJ2018 { // 수들의 합 5 / S5 / twopointer
	
	static BufferedReader br;
	static int N;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	}
	
	static void solve() {
		int answer = 0;
		int sum = 1;
		for(int L = 1, R = 1; L <= N; L++) {
			System.out.println(L + " L : R " + R);
			while(R < N && sum < N) {
				R++;
				sum += R;
			}
			
			if(sum == N) {
				answer++;
				System.out.println("N=sum " + L + " L : R " + R);
			}
			
			sum -= L;
		}
		
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
1. 접근
연속된 자연수들로 N을 나타내는 경우의 수는?
- DP
	5, 1 4, 2 3 ... N/2 까지 -1 하며 구한다.
	이때 앞 * 뒤 이며, DP로 기록한다.
	depth가 500만 까지 갈 수 있다.
	bottom up은 500만 크기의 배열 필요...
	
- 투포인터
	1 2 3 4 5 ...
	L = 1, R = 1
	1 12 123 1234 ... 합 >= N 이면 L++ / 합 < N 이면 R++
	합이 작아지려면 L을 하나 줄여야한다. (합-L)
	합이 커지려면 R을 하나 늘려야한다. (합+R)
	시간 복잡도 : 2N ... 2천만

2. 구현
L=1, R=1, sum = 1

R부터 < N 까지 증가 시킨다. sum+R (L..R(sum) < N일 때 까지)
L..R == N : answer++
L++, sum-L


      
*/
