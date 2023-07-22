package com.al.main;

import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.io.*;

public class BOJ16236 {
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, sY, sX, size, cnt, time;
	static boolean isFind;
	static int[][] map, dist;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	
	static void input () throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		dist = new int [N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 상어 위치 표시 // 빈공간으로 전환
				if(map[i][j] == 9) {
					sY = i; sX = j;
					map[i][j] = 0;
				}
			}
		}
		
		size = 2; cnt = 0; time = 0; isFind = false;
	}
	
	static void solve() {
		
		// 처음은 항상 수행 / 상어를 찾았으면 진행
		do {
			// 상어 찾음 Flag 초기화
			isFind = false;
			
			// visited 초기화
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < N; j ++) {
					dist[i][j] = 0; 
				}
			}
			
			// 가까운 물고기 위치 찾아서 상어를 이동 시킴
			bfs();
		} while (isFind);
		
		// 상어가 버틴 시간 출력
		System.out.println(time);
	}
	
	static void bfs() {
		// Q 생성 후, 현재 상어 위치 넣기
		Queue<Integer> Q = new LinkedList<>();
		Q.add(sY); Q.add(sX);
		// 방문 처리
		dist[sY][sX] = 1;
		
		//먹을 수 있는 가장 가까운 상어를 찾을 때 까지 반복
		while(!Q.isEmpty()) {
			// Q에서 하나의 노드를 뽑음
			int y = Q.poll();
			int x = Q.poll();

			// 물고기 찾음 map ij < size
			if(map[y][x] != 0 && map[y][x] < size) {
				// 찾음 상태 변경
				sharkStateUpdate(y, x);
				// Q를 모두 뽑는다.
				while(!Q.isEmpty()) {
					int oy = Q.poll();
					int ox = Q.poll();
					// dist가 y,x와 같으면 비교한다.
					if(dist[oy][ox] != dist[y][x] || map[oy][ox] == 0 || map[oy][ox] >= size) continue;
					// Y가 더 작으면 변경, Y가 같고 X가 더 작으면 변경1
					if(sY == oy) {
						if(ox < sX) {
							sY = oy; sX = ox;
						}
					} else if(oy < sY) {
						sY = oy; sX = ox;
					}
				}
				
				// 물고기 먹음 처리
				map[sY][sX] = 0;
				// 사이즈 변경
				if(cnt == size) {
					size++;
					cnt = 0;
				}

				// 이미 찾았으니 진행할 필요 없다.
				break;
			}
			
			// 사방 탐색
			for(int i = 0; i < 4; i ++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];

				// valid false, visited true, map ij 크면 conitnue
				if(!validCheck(ny, nx)) continue;
				if(dist[ny][nx] != 0) continue;
				if(map[ny][nx] > size) continue;
				
				// 방문한다. / Q에 넣고 / dist + 1
				Q.add(ny); Q.add(nx);
				dist[ny][nx] = dist[y][x] +1;
			}
			
		}
	}
	
	static boolean validCheck(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x <N;
	}

	static void sharkStateUpdate(int y, int x) {
		// 상어 위치 변경, 상어 사이즈 조정, time-1 +, isFind true
		sY = y; sX = x;
		
		cnt++;
		
		time += dist[y][x]-1;

		isFind = true;
	}
	
	public static void main(String[] args) throws IOException{
		input();
		solve();
	}

}

/*
1. 접근
	상어가 크기가 더  작은 물고기를 먹으러 다닌다.
	현재 가장 가까운 것(거리 가깝고, 위, 왼쪽)부터 먹으러 다닌다.
		먹을 때 마다 누적, 현재 크기와 먹은 수가 같으면 크기가 +1 된다.
	         먹을 때 마다 다음 가장 가까운 물고기를 구한다.
	얼마나 오래 버틸 수 있는가?
	
	물고기 수 만큼, 가장 가까운 거리를 구하는 가중치 동일한 문제이다. BFS 풀자.
	공간 : 20*20  시간 : 20*20 * 4 * 20 * 20 ... 충분

	BFS 할 때 마다 모든 칸에 표기 하는 것은 비효율적이다.
		1. 한칸 움직일 때마다, 모든 칸을 업데이트한다? 더 비효율적
		2. 가장 가까운 것을 찾으면 탐색 중지?
			왼쪽, 위, 부터는 어떻게?
			BFS를 하는데, 만일 먹을 수 있는 물고기가 있으면
				flag = true로 두고, 더이상 Queue에 넣지 않는다.
				현재 Y, X를 가지고 있고, 다음 얻은 것의 Y를 비교한다.
					Y가 같다면 X를 비교하여 하나만 남긴다.
				이동할 위치, 걸린 시간을 입력한다.
	첫 위치(상어 위치) -> BFS -> 가장 가까운 위치 찾음 -> 상어 위치 변경, 크기+1, 시간 추가 -> 반복 Bfs 

2. 정답의 최대치
	매번 모든 칸 이동 = 400 * 400
3. 구현 -> 주석으로 처음부터 대체하면 더 빠를 듯? 가끔 빼먹는게 있는 거 같으니..
	아기 상어 크기 2, 상하 좌우 이동
	더이상 먹을 수 있는 물고기가 없을 때 까지 반복한다.
		첫 위치에서, BFS를 시작한다. find false
			상하좌우로 움직인다. visited에 가중치 +1하며 움직인다.
			상어 크기 보다 크면 방문하지 않는다.
			상어크기와 작거나 같으면 방문한다.
				상어크기보다 작으면 찾았다!
				0이 아닌, 작은 위치를 찾으면 현재 가중치 중 위, 왼쪽을 찾는다. //todo 빠르게 안 떠오르면 걍 비효율 ㄱㄱ
				-> 	물고기를 찾으면, 이동할 X, Y 값을 입력해둔다. (다음 BFS 위치)
				->  현재 Queue의 모든 요소를 뽑아서, 가중치가 같은 위치면 X와 Y를 비교한다.
					Y가 작으면 교체한다, Y가 같으면 X가 작은 것으로 교체한다.
				-> 	Queue를 모두 뽑았으므로 while 종료될 것이다.
				->  상어 크기 + 1, visited 초기화(대신, 현재 값 보다 크거나 같으면 방문 X // 나중에), 가중치를 시간에 +
				-> Find true
			BFS를 종료한다.
		새로운 위치에서 BFS를 시작한다.
		(find true인 동안)
				
	


*/