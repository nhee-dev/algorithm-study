package com.al.bfs;

import java.util.*;
import java.io.*;

public class BOJ2251R { // 시간 복잡도 개선
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] limits;
	static boolean[] answer;
	static boolean[][][] visited;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		limits = new int[3];
		for(int i = 0; i < 3; i++) {
			limits[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = new boolean[201];
		visited = new boolean[201][201][201];
	}
	
	static void solve() {
		//bfs로 결과를 얻는다.
		bfs();
		//출력
		for(int i = 0; i < 201; i++) {
			if(answer[i]) sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		// 시작 상태 설정
		Queue<State> Q = new LinkedList<>();
		Q.add(new State(new int[] {0, 0, limits[2]}));
		visited[0][0][limits[2]] = true;
		
		while(!Q.isEmpty()) {
			// Q.에서 하나 뽑는다.
			State st = Q.poll();
			System.out.println(st.bowls[0] + " " + st.bowls[1] + " " + st.bowls[2]);
			
			// A == 0 -> answer.add C
			if(st.bowls[0] == 0) {
				answer[st.bowls[2]] = true;
			}
			
			// 6가지 경우로 move 해본다.
			for(int i = 0; i < 3; i ++) {
				for(int j = 0; j < 3; j ++) {
					if(i==j) continue;
					
					State nst = st.move(i, j);
					
					// move 결과가 방문한 상태면 continue
					if(visited[nst.bowls[0]][nst.bowls[1]][nst.bowls[2]]) continue;
					
					System.out.println("move " + nst.bowls[0] + " " + nst.bowls[1] + " " + nst.bowls[2]);

					// 아니면 방문하고 Q에 넣는다.
					Q.add(nst);
					visited[nst.bowls[0]][nst.bowls[1]][nst.bowls[2]] = true;
				}
			}
		}
	}

	static class State {
		int[] bowls;
		
		State(int[] bowl) {
			bowls = bowl.clone();
		}
		
		public State move(int from, int to) {
			int[] newBowls = {bowls[0], bowls[1], bowls[2]};
			// to의 빈 자리
			int left = limits[to] - bowls[to];
			// to의 빈 자리 보다 옮겨질 물이 작거나 같다면, 모두 옮긴다.
			if(left >= bowls[from]) {
				newBowls[to] = bowls[to] + bowls[from];
				newBowls[from] = 0;
			} else { // 옮겨질 물이더 많으면 빈자리 만큼 옮기고, 남긴다.
				newBowls[to] = bowls[to] + left;
				newBowls[from] = bowls[from] - left;
			}
			
			return new State(newBowls);
		}
	}
	

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}


}


/*
1. 접근
	정점이 A,B,C State, 간선이 6가지 인 그래프 탐색.
	정점의 수 : 200 200 200 = 800만
	시간 복잡도 : 4800만 정도
2. 구현
	State에 a,b,c와 move 함수를 만든다.
		move는 새로운 State를 반환한다.
	BFS로 첫 상태 부터 탐색한다.
		poll 시 A가 0이면 정답 Arr에 C 추가
	Move 시켜서 새로운 State가 visited 아니면 Q에 추가
		visited는 StringSet으로 확인 // 3차원 배열과 시간 복잡도 확인
*/