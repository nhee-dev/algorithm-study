package com.al.twopointer;

import java.util.*;
import java.io.*;

public class BOJ13144 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int[] arr;
	static boolean[] visited;
	static int N;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[100001];
//		System.out.println(Arrays.toString(arr));
	}
	
	static void solve() {
		long answer = 0;
		
		// twopointer
		int R = 0;
		// for 1 N L을 결정한다.
		for(int L = 0; L < N; L++) {
			// R을 가능한 만큼 옮긴다.
			while(R < N && !visited[arr[R]]) {
				// N < && hashset에 없으면, set에 넣고 R++
				visited[arr[R]] = true;
				R++;
			}
			
			// 중복된 것을 발견해서 R을 증가 시킬 수 없으면
			// L~R을 answer에 더한다.
			answer += R - L;
			
			// L을 하나 증가 시키고, arr(L)을 Set에서 제거한다. -> L이 증가한다.
			visited[arr[L]] = false;
		}
		
		// print answer
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
수열의 연속된 요소 들 중에서, 1개 이상 선택한다.
같은 수가 없는 경우의 수를 구해야 한다.

1 2 4 3 4 5

L를 정한다. (0~N-1)
R을 정한다. (요소가 같지 않은 동안 증가)
	요소가 같으면, 앞의 하나를 제거한다. 이전까지의 수를 + 한다. (마지막은?)
L, R < N인 동안 진행한다.

1. 시간 복잡도 
	N + N
2. 정답의 최대치
	10만...1 더하면 50억 정도, Long

*/