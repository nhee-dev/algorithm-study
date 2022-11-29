import java.util.*;
import java.io.*;

public class BOJ_17086 {
	static int N, M, max;
	static int[][] map;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		init();
		solution();
		printResult();
	}

	static void bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		qx.offer(x);
		qy.offer(y);
		visited[x][y] = true;	

		int level = 0;
		boolean isFirst = false;
		while (!qx.isEmpty()) {
			int size = qx.size();
			for (int i = 0; i < size; i++) {
				int cx = qx.poll();
				int cy = qy.poll();
				if(map[cx][cy] == 1) {
					isFirst = true;
					break;
				}
								
				for(int j = 0; j < 8; j++) {
					int tx = cx + dx[j];
					int ty = cy + dy[j];
					if(tx < 0 || tx >= N || ty < 0 || ty >= M) {
						continue;
					}
					if(visited[tx][ty]) {
						continue;
					}
					visited[tx][ty] = true;
					qx.offer(tx);
					qy.offer(ty);
				}
			}

			if(isFirst) {
				break;
			}
			level++;
		}
		if(max < level) {
			max = level;
		}
	}

	static void solution() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					bfs(i, j);
				}
			}
		}
	}

	static void printResult() {
		System.out.println(max);
	}

	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
