import java.util.*;
import java.io.*;

public class BOJ_14503 {
	static int N, M, count;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static Node robot;

	public static void main(String[] args) throws Exception {
		init();
		solution();
		printResult();
	}

	static void solution() {
		Queue<Node> q = new LinkedList<>();
		q.offer(robot);

		// 현재 위치 청소
		count++;
		// 청소한 위치 2로 표시
		map[robot.x][robot.y] = 2;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			boolean isFind = false;
			// 현재 위치 기준 왼쪽 방향부터 탐색 진행
			int dir = cur.dir;
			for (int i = 0; i < 4; i++) {
				// 왼쪽방향
				dir--;
				if (dir < 0) {
					dir = 3;
				}
				int x = cur.x + dx[dir];
				int y = cur.y + dy[dir];

				// 범위를 벗어나는 경우
				if (outOfRange(x, y)) {
					continue;
				}

				// 청소하지 않은 공간 있는 경우
				if (map[x][y] == 0) {
					map[x][y] = 2;
					count++;
					q.offer(new Node(x, y, dir));
					isFind = true;
					break;
				}

				// 청소할 공간이 없으면 회전
				if (map[x][y] == 1 || map[x][y] == 2) {
					continue;
				}
			}

			if (!isFind) {
				// 뒤쪽 방향이 벽이거나 범위를 벗어나지 않는 경우
				if (!(outOfRange(cur.x - dx[dir], cur.y - dy[dir])
						|| map[cur.x - dx[dir]][cur.y - dy[dir]] == 1)) {
					q.offer(new Node(cur.x - dx[dir], cur.y - dy[dir], dir));
				}
			}
		}
	}

	static boolean outOfRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
	}

	static void printResult() {
		System.out.println(count);
	}

	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = 0;
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		robot = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static class Node {
		int x, y, dir;

		public Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}
