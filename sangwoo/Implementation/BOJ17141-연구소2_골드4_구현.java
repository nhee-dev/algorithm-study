import java.io.*;
import java.util.*;

// 백준 17141 연구소 2
public class BOJ_17141 {
	static int N, M, min, zeroCount;
	static int[][] map, copy_map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static List<Point> virus;
	static Point[] output;

	public static void main(String[] args) throws Exception {
		init();
		if (virus.size() == M && zeroCount == 0) {
			System.out.println(0);
			return;
		}
		solution();
		result();
	}

	static void solution() {
		combi(0, 0, virus.size(), M);
	}

	static void combi(int start, int depth, int n, int r) {
		if (depth == r) {
			initMap();
			bfs();
			return;
		}

		for (int i = start; i < n; i++) {
			output[depth] = virus.get(i);
			combi(i + 1, depth + 1, n, r);
		}
	}

	static void bfs() {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		for (int i = 0; i < output.length; i++) {
			qx.offer(output[i].x);
			qy.offer(output[i].y);
			visited[output[i].x][output[i].y] = true;
		}

		int max = Integer.MIN_VALUE;

		while (!qx.isEmpty()) {
			int cx = qx.poll();
			int cy = qy.poll();

			for (int i = 0; i < 4; i++) {
				int tx = cx + dx[i];
				int ty = cy + dy[i];

				if (tx < 0 || tx >= N || ty < 0 || ty >= N) {
					continue;
				}
				if (visited[tx][ty]) {
					continue;
				}

				qx.offer(tx);
				qy.offer(ty);
				visited[tx][ty] = true;
				copy_map[tx][ty] = copy_map[cx][cy] + 1;

				if (max < copy_map[tx][ty]) {
					max = copy_map[tx][ty];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					return;
				}
			}
		}

		if (min > max) {
			min = max;
		}
	}

	static void initMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy_map[i][j] = map[i][j];
				if (map[i][j] == 1) {
					visited[i][j] = true;
				} else {
					visited[i][j] = false;
				}
			}
		}
	}

	static void result() {
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		copy_map = new int[N][N];
		visited = new boolean[N][N];
		virus = new ArrayList<>();
		min = Integer.MAX_VALUE;
		output = new Point[M];
		zeroCount = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 2) {
					virus.add(new Point(i, j));
					map[i][j] = 0;
				} else if (n == 0) {
					zeroCount++;
				} else {
					map[i][j] = n;
				}
			}
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}