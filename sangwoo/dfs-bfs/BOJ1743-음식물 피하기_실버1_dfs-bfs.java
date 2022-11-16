import java.util.*;
import java.io.*;

public class BOJ_1743 {
	static int N, M, K, max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		init();
		solution();
		result();
	}
	
	static void result() {
		System.out.println(max);
	}

	static void solution() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j]) {
					continue;
				}
				if(map[i][j] == 0) {
					continue;
				}
				bfs(i, j);
			}
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.offer(x);
		qy.offer(y);
		visited[x][y] = true;
		int count = 1;
		
		while(!qx.isEmpty()) {
			int cx = qx.poll();
			int cy = qy.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = cx + dx[i];
				int ty = cy + dy[i];
				
				if(tx < 0 || tx >= N || ty < 0 || ty >= M) {
					continue;
				}
				if(map[tx][ty] == 0) {
					continue;
				}
				if(visited[tx][ty]) {
					continue;
				}
				
				qx.offer(tx);
				qy.offer(ty);
				visited[tx][ty] = true;
				count++;
			}
		}
		
		if(max < count) {
			max = count;
		}
	}

	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		max = Integer.MIN_VALUE;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = 1;
		}
	}

}
