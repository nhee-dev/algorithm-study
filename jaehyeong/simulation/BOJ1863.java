package com.al.main;

import java.io.*;
import java.util.*;

public class BOJ1863 { // 스카이라인 쉬운거 // G5 // 구현
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, ans;
	static Queue<Integer> mapQ;
	static boolean visited[];
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		mapQ = new LinkedList<Integer>();
		visited = new boolean[500001];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
//			mapQ.add(Integer.parseInt(st.nextToken())); y만
			mapQ.add(Integer.parseInt(st.nextToken()));
		}
		
	}

	static void solve() {
		
		int last = 0;
		while(!mapQ.isEmpty()) {
			int y = mapQ.poll();
			
			if(y == 0) {
				visited = new boolean[500001];
				continue;
			}

			if(y < last) {

				resetVisited2(y);

			}
			if(visited[y]) continue;

			ans ++;
			last = y;
			visited[y] = true;
		}
	}
	
	static void resetVisited(int idx) {
		boolean[] temp = new boolean[500001];
		System.arraycopy(visited, 0, temp, 0, 3);
		visited = temp;
		temp = null;
	}
	
	static void resetVisited2(int idx) { // ... 메모리초과 안나네? 50만 * 50만 = 
		for(int i = idx +1; i < 500001; i++) {
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(ans);
	}

}

/*

1 <= n <= 5만
1 <= x <= 100만
1 <= y <= 50만

스카이라인만 보고 건물이 최소 몇 채인지 알아보자.
- 건물은 모두 직사각형이다.
- 첫 지점은 항상 1

간단히 생각하자.
2차원 좌표가 주어진다. 이 선 내부가 건물이라고 가정 할 때,
가로 또는 세로로 긴 직 사각형으로 선을 채울 수 있다.

고도가 바뀌는 지점으로 맵이 주어지므로, 이를 이용해보자.
연결된 지점(0을 만나면 리셋)마다 visited Hieght 배열을 갖는다.
특정 고도를 만나면, 해당 고도를 visited한다.? (visited)이면 넘어간다.

구현은 Queue에 x,y를 다 넣는 것. 하나씩 꺼내서 체크한다.

1. 최대치
	y가 50만일때 50만개가 최대이다.
2. 시간 복잡도
	매 위치마다 점이 바뀔 때, 100만번 체크할 것이다.
3. 케이스
	건물이 없는 경우
	1
	1 0
	건물이 띄엄 띄엄 있는 경우
	3
	1 1
	2 0
	3 1
	마지막에 건물이 있는 경우
	1
	1000000 500000
	중간에 낮아지는 경우
	5
	1 1
	3 3
	5 1
	7 3
	9 0
*/