package com.al.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class State { // 정점, A B C 상태 값 저장  
	// a, b, c 변수로 사용할 수 있으니 배열이 출력하기 유리할 듯... 공간은?
	int[] bowls;
	
	State(int[] _bowls) { // State 값 받아서 초기화
		bowls = new int[3];
		for(int i = 0; i < 3; i ++) {
			bowls[i] = _bowls[i];
		}
	}
	
	// 물을 from에서 to로 이동시킨 후 변화한 상태 값을 반환한다.
	public State move(int from, int to, int[] limit) {
		int[] newBowls = new int[] {bowls[0], bowls[1], bowls[2]};
		if(bowls[from] + bowls[to] > limit[to]) {
			newBowls[from] -= limit[to] - newBowls[to];
			newBowls[to] = limit[to];
		} else {
			newBowls[to] += newBowls[from];
			newBowls[from] = 0;
		}
		return new State(newBowls);
	}
	
}

public class BOJ2251S {
	
	static BufferedReader br;
	static StringTokenizer st;

	static StringBuilder sb = new StringBuilder();
	
	static int[] limit; // 각 볼의 최대 용량 ... 각 변수로도 가능
	static boolean[][][] visited; // 해당 상태 방문했는지 체크 할 베열
	static boolean[] possible; // C가 해당 크기를 가질 수 있는지 체크할 배열
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		limit = new int[3];
		for(int i = 0; i < 3; i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[201][201][201];
		possible = new boolean[201];
	}
	
	static void bfs(int a, int b, int c) {
		Queue<State> Q = new LinkedList<>();
		
		Q.add(new State(new int[] {a, b, c}));
		visited[a][b][b] = true;
		
		while(!Q.isEmpty()) {
			State st = Q.poll();
			if(st.bowls[0] == 0) {
				possible[st.bowls[2]] = true;
			}
			
			// 변수를 명시적으로
			for(int from = 0; from < 3; from ++) {
				for(int to = 0; to < 3; to++) {
					if(from == to) continue;
					
					State nst = st.move(from, to, limit);
					
					if(visited[nst.bowls[0]][nst.bowls[1]][nst.bowls[2]]) continue;
					
					Q.add(nst);
					visited[nst.bowls[0]][nst.bowls[1]][nst.bowls[2]] = true;
				}
			}
			
		}
	}
	
	static void solve() {
		bfs(0, 0, limit[2]);
		
		for(int i = 0; i < 201; i ++) {
			if(possible[i]) sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
 