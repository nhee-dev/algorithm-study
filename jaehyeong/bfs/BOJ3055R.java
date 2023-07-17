package com.al.bfs;

import java.util.*;
import java.io.*;

public class BOJ3055R { // 탈출 / G4 / BFS
	
	static BufferedReader br;
	static StringTokenizer st; 
	
	static int R, C;
	static int[][] visitedWater, visitedAnimal;
	static String[] map;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R];
		for(int i = 0; i < R; i ++) {
			map[i] = br.readLine();
			System.out.println(map[i]);
		}
		
		visitedWater = new int[R][C];
		visitedAnimal = new int[R][C];
	}
	
	static void solve() {
		//BFS로 물이 각 칸에 방문하는 시간을 구한다.
		waterBfs();
		//BFS로 고슴도치가 D에 도달할 시간을 구한다.
		animalBFS();
		//D의 시간을 출력한다. / 0이면 Kaktous
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i].charAt(j) == 'D') {
					if(visitedAnimal[i][j] == 0) {
						System.out.println("KAKTUS");
					} else {
						System.out.println(visitedAnimal[i][j]-1);
					}
				}
			}
		}
		
		for(int i = 0; i < R; i ++) {
			System.out.println("Watater" + Arrays.toString(visitedWater[i]));
		}
		for(int i = 0; i < R; i ++) {
			System.out.println("Animal" + Arrays.toString(visitedAnimal[i]));
		}
	}
	
	static void waterBfs() {
		// Q를 만든다.
		Queue<Integer> Q = new LinkedList<Integer>();
		// 맵을 돌며 Water를 넣는다. 방문 처리 한다.
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i].charAt(j) == '*') {
					Q.add(i); Q.add(j);
					visitedWater[i][j] = 1;
				}
			}
		}
		
		// Q가 남아있는 동안
		while(!Q.isEmpty()) {
			// Q를 꺼낸다.
			int y = Q.poll();
			int x = Q.poll();
			// 상하좌우가 valid이고, 방문하지 않았고, .이면 이동한다.
			for(int i = 0; i < 4; i++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				
				if(!validCheck(ny, nx)) continue;
				if(visitedWater[ny][nx] != 0) continue;
				if(map[ny].charAt(nx) != '.' && map[ny].charAt(nx) != 'S') continue;
				
				// Q에 넣고, 방문 처리 한다.(visited[now]+1)
				Q.add(ny); Q.add(nx);
				visitedWater[ny][nx] = visitedWater[y][x] + 1;
			}
			
		}
	
	}
	
	static void animalBFS() {
		// Q를 만든다.
		Queue<Integer> Q = new LinkedList<>();
		// 맵을 돌며 S를 넣는다. / 방문처리한다.
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i].charAt(j) == 'S') {
					Q.add(i); Q.add(j);
					visitedAnimal[i][j] = 1;
				}
			}
		}
		
		// Q가 남은 동안
		while(!Q.isEmpty()) {
			// Q를 꺼낸다.
			int y = Q.poll();
			int x = Q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				
				// 상하좌우가 vaild이고, X가 아니고, Animal.count < visitedWater, visitedAnimal false이면 이동한다.
				if(!validCheck(ny, nx)) continue;
				if(visitedAnimal[ny][nx] != 0) continue;
				if(visitedWater[ny][nx] != 0 && visitedWater[ny][nx] <= visitedAnimal[y][x] + 1) continue;
				if(map[ny].charAt(nx) == 'X') continue;
				
				// Q에 넣고, 방문처리 한다.(+1)
				Q.add(ny); Q.add(nx);
				visitedAnimal[ny][nx] = visitedAnimal[y][x] + 1;
			}
		}

	}
	
	static boolean validCheck(int y, int x) {
		return y >= 0 && x >= 0 && y < R && x < C;
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
1. 접근
	- S가 D에 도달할 수 있는 가장 빠른 시간, 도달 못하면 "Kaktus"
	- 가중치 없는 최단 시간 2차원 그래프 이므로 BFS 사용
	- 50*50 일때, 공간 : 2500, 시간 : 2500*4 ... 충분

2. 정답의 최대치
	- 2500

3. 구현
	- 물이 여러 개 주어질 수 있고, 물이 먼저 차야한다.
		Multi BFS에 물들을 넣고, 매 분 상하좌우로 확장하게 한다.(빈 공간)
	- 고슴도치가 그 다음 움직인다.
		상하좌우를 살피고, 물과 돌이 없으면 이동하게 한다.
		만약 D이면 종료
	- 물 방문 배열 visited를 2차원 Boolean 배열로 하면 1Byte 2500
		물이동 1번, 고슴도치 이동 1번 해야한다.
		고슴도치가 더이상 없거나, D에 도착할 때 까지 반복한다.
		-> BFS 중간에 끊기가 애매하다. -1 넣고, 만나면 -1 넣고 break;
	- 물 방문 배열을 int로 하면 ... 4Byte 2500
		BFS로 물이 1부터 +1  씩 빈 공간을 모두 채운다.
		BFS로 고슴도치가 1부터하여 +1씩 증가하며, 고슴도치 < 물이면 방문한다.
		고슴도치 Class 만들어서 1씩 증가하게 하거나, 고슴도치 visited를 따로 만든다.
		-> Class 만들면 고슴도치가 왔던길 돌아갈 수 있음
		-> 고슴도치 방문 배열 따로 만들어야 함

		
4. 케이스
	- S 바로 옆 D
	- D에 도달할 수 없음

*/
