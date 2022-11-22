import java.util.*;
import java.io.*;

public class BOJ_14502 {
	static int N, M, max;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static List<Point> empty, virus;
	static Point[] output;

	public static void main(String[] args) throws Exception {
		init();
		solution();
		printReuslt();
	}

	static void solution() {
		combi(0, 0, empty.size());
	}

	static void combi(int start, int depth, int n) {
		if (depth == 3) {
			bfs();
			return;
		}
		for (int i = start; i < n; i++) {
			output[depth] = empty.get(i);
			combi(i + 1, depth + 1, n);
		}
	}

	static void bfs() {
		int[][] map_copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map_copy[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < 3; i++) {
			map_copy[output[i].x][output[i].y] = 1;
		}

		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			q.offer(virus.get(i));
		}

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				if (map_copy[nx][ny] != 0) {
					continue;
				}
				map_copy[nx][ny] = 2;
				q.offer(new Point(nx, ny));
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map_copy[i][j] == 0) {
					count++;
				}
			}
		}
		if (max < count) {
			max = count;
		}
	}

	static void printReuslt() {
		System.out.println(max);
	}

	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;
		map = new int[N][M];
		empty = new ArrayList<>();
		virus = new ArrayList<>();
		output = new Point[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					empty.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					virus.add(new Point(i, j));
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
