package com.al.main;

import java.io.*;
import java.util.*;

public class BOJ22251 { // 빌런 호석 / G5 / 완전탐색
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, K, P, X, ans;
	static boolean[][] num = { // 오히려 더 걸린듯 ...
			{true, true, true, true, true, true, false}, 
			{false, true, true, false, false, false, false}, 
			{true, true, false, true, true, false, true}, 
			{true, true, true, true, false, false, true}, 
			{false, true, true, false, false, true, true}, 
			{true, false, true, true, false, true, true}, 
			{true, false, true, true, true, true, true}, 
			{true, true, true, false, false, false, false}, 
			{true, true, true, true, true, true, true},
			{true, true, true, true, false, true, true}};
	static int[][] numTo;
	static int[] current, selected;
	static StringBuilder sb;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		numTo = new int[10][10];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				int dif = 0;
				for(int k = 0; k < 7; k++) {
					if(num[i][k] != num[j][k]) dif++;
				}
				numTo[i][j] = dif;
			}
		}
		
		current = new int[K];
		String s = X + "";
		for(int i = 0; i < s.length(); i++) {
			current[K-1-i] = (s.charAt(s.length()-1-i) - '0');
		}
		
		selected = new int[K];
	}
	
	static void solve() {
		rec_func(0, P);
		System.out.println(ans);
	}
	
	static void rec_func(int depth, int cnt) {
		if(depth == K) {
			// 만약 하나도 바꾸지 않았으면 리턴
			if(cnt == P) return;
			
			// selected => int
			int sNum = makeInt();
			
			// 만약 만들어진 수가 N보다 크면 리턴, 0이어도 리턴
			if(N < sNum || sNum == 0) return;
			
			ans ++;
			return;
		}
		
		for(int i = 0; i < 10; i ++) {
			int now = current[depth];
			if(numTo[now][i] > cnt) continue;
			
			selected[depth] = i;
			rec_func(depth+1, cnt-numTo[now][i]);
		}
	}
	
	static int makeInt() {
		int result = 0;
		
		sb = new StringBuilder();
		for(int i = 0; i < K; i++) {
			sb.append(selected[i]);
		}
		result = Integer.parseInt(sb.toString());
	
		return result;
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*

1 <= X 현재층 <= N 층수 < 10^k
1 <= K 자리수 <= 6
1 <= P 반전수 <= 42

N층 까지 이용 가능하며, K자리가 보인다.
- 수는 0으로 시작 가능
- 1~P개의 LED를 반전
- 반전 후 N이하의 숫자가 되어야 함

- X층에 멈췄을 때, 반전시킬 LED의 경우의 수는?

예제는 9층, 1자리, 2개 반전, 5층 이다.
5의 LED를 0, 1, 2개 바꾸면 4개를 만들 수 있을 것이다.

간단히 생각해서, 층 X가 주어지면 LED를 반전 시켜 각 자리를 다른 숫자로 만든다.
	특정 수에서 수로 바뀌는데 필요한 반전 수를 기록해두고 사용한다.
	앞에서 부터 다른 수로 바꿀지 말지 결정하고 반전 수를 감소 시킨다.
	모든 경우의 수를 조합해본다.
1. 시간 복잡도
100만층 일때, 층을 조합하는데 최대 100만의 경우의 수가 나올 것? 
따라서 각 자리가 변경 가능한 수를 선택하여 조합할 때, 그 이하가 나올 것이다.
2. 구현
	- 변화 : 2차원 배열로 기록?
	- 
3. 개선된 접근
	- 모든 경우의 수로 바꿀 수 있는지 확인? 100만 *6
	- 없는듯 5

*/