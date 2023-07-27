package com.al.bfs;

import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

import java.io.*;

public class BOJ14502R { // 연구소 / G4 / BFS,DFS
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, M;
	static int minVirus, blankCnt; // blank - 3(설치할 벽)
	static int[][] map;
	static ArrayList<Integer> blanks, viruses;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		blanks = new ArrayList<>();
		viruses = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 빈 칸 이면 
				if(map[i][j] == 0) {
					blanks.add(i); blanks.add(j);
				}
				// 바이러스 이면
				if(map[i][j] == 2) {
					viruses.add(i); viruses.add(j);
				}
			}
		}
		visited = new boolean[N][M];
		
		minVirus = 64; 
		blankCnt = blanks.size() / 2;
		
	}
	
	static void solve() {
		// 조합해서 맵에 벽 3개를 두고 바이러스 수를 구한다.
		permutation(0, 0);
		
		// blankCnt - maxVirus - 3을 출력한다.
		System.out.println(blankCnt - minVirus - 3);
	}
	
	
	static void permutation(int depth, int start) {
		// depth가 3이면 bfs를 한다.
		if(depth == 3) {
			bfs();
			return;
		}
		
		// blanks의 각 원소를 선택하거나, 선택하지 않는다.
		for(int i = start; i < blanks.size(); i+=2) {
			// 선택하면 visited의 해당 위치를 방문처리한다. -> Viruns가 방문하지 못해서 퍼지지 않을 것
			// -> 매번 BFS 시 초기화 해야해서 ... visited가 아닌, map에 표기한다.
			map[blanks.get(i)][blanks.get(i+1)] = 1;
			permutation(depth+1, i+2);
			// 선택 안함 처리
			map[blanks.get(i)][blanks.get(i+1)] = 0;
		}
	}
	
	// 바이러스를 퍼뜨리고, 퍼뜨린 바이러스 수를 센다.
	static void bfs() {
		System.out.println();
		// visited를  초기화 한다.
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = false;
			}
		}

		// Q를 만든다. 바이러스를 넣고(바이러스 배열), 방문 처리 한다.
		Queue<Integer> Q = new LinkedList<>();
		for(int i = 0; i < viruses.size(); i+=2) {
			int y = viruses.get(i); int x = viruses.get(i+1);
			Q.add(y); Q.add(x);
			visited[y][x] = true;
		}

		// 바이러스가 남은 동안 반복
		int nowV = 0;
		while(!Q.isEmpty()) {
			// 바이러스를 하나 뽑는다.
			int y = Q.poll(); int x = Q.poll();
//			System.out.println("방문 " + y + " " + x);
			for(int i = 0; i < 4; i ++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				// 범위 내, 방문 X, 0이면 방문한다.
				if(!validCheck(ny, nx)) continue;
				if(visited[ny][nx]) continue; // 이미 바이러스가 있음
				if(map[ny][nx] != 0) continue; // 빈 칸으로만 감
				// Q에 넣고
				// visit체크한다.
				Q.add(ny); Q.add(nx);
				visited[ny][nx] = true;
				// 이번 바이러스 수를 증가 시킨다.
				nowV++;
			}
		}
		
		System.out.println("map");
		for(int i = 0; i <N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		System.out.println("virus");
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		// maxV와 비교해서 더 적으면 업데이트 한다.
//		minVirus = (minVirus > nowV) ? nowV : minVirus;
		minVirus = Math.min(minVirus, nowV);
	}
	
	static boolean validCheck(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < M;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
1. 접근
	맵에 벽 3개를 두고, DFS나 BFS로 바이러스를 퍼뜨린다.
		조합
			최대 64개의 공간에 두거나, 두지 않거나로 3개를 선택한다.
			순서가 없고 중복이 불가능하므로, 64 63 62 = 200000 20만 정도
		BFS
			방문한 곳은 가지 않으므로 64가 최대이다. 20만번 반복 ... 충분하다.
	남은 영역의 수를 구한다.
2. 정답의 최대치 : 64
3. 구현
	(반복)
	맵에 벽 3개를 둔다.(조합한다.)
		-> 조합을 어떻게 할까?
			1. 0,0 부터 i,j를 하나씩 증가 시킴
			2. 다음 선택은 해당 ij 이후 부터 하게 함 (이전 선택 안 건드림)
			-> 시간 복잡도는 64 * 63 * 62 정도
		-> 다른 방법은?
			1. 방문 가능한 배열 64개 (0인 노드들)를 만든다.
			2. 각 배열을 선택하거나, 선택하지 않는다.
			-> 시간 복잡도는 비슷할 듯
			-> 빈칸의 개수도 만들어 진다.
			-> 공간 복잡도는 증가함
		조합 후 BFS로 바이러스를 퍼뜨린다.
		-> 바이러스를 찾아서 Q에 넣는다.
			4방향 탐색해서, valid, !visit, "0"이면 방문한다.
				visit 처리는 어떻게 할 것인가?
					바이러스는 0인 곳만  이동한다.
					visit을 매번 초기화 하면, 0중, 이미 방문한 곳을 가지 않을 것이다.
			바이러스를 1 증가 시킨다.(BFS 전역)
		바이러스 수가 MinViruns 보다  작으면 update
	바이러스와 벽을 초기화한다.
*/
