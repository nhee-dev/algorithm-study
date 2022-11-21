import java.util.*;
import java.io.*;

public class BOJ_16930 {
	static int N, M, K, min;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static Node start, end;

	public static void main(String[] args) throws Exception {
		init();
		solution();
		printResult();
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(start);
		map[start.x][start.y] = -1;

		boolean isFind = false;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.x == end.x && cur.y == end.y) {
				min = cur.depth;
				return;
			}

			for (int i = 0; i < 4; i++) {
				// 1부터 K까지 한 방향으로 탐색
				for (int j = 1; j <= K; j++) {
					int tx = cur.x + (dx[i] * j);
					int ty = cur.y + (dy[i] * j);

					// 범위 밖으로 나가면 더이상 탐색 X
					if (tx < 0 || tx >= N || ty < 0 || ty >= M) {
						break;
					}

					// 벽으로 막혀 있으면 더이상 탐색 X
					if (map[tx][ty] == -1) {
						break;
					}

					// 내가 가야 할 위치에 적혀있는 최소값 보다 지금 가는게 더 최소라면
					if (map[tx][ty] < cur.depth + 1) {
						break;
					}

					// 내가 가야 할 위치에 적혀있는 최소값과 지금 가는게 같다면 다음으로
					if (map[tx][ty] == cur.depth + 1) {
						continue;
					}

					q.offer(new Node(tx, ty, cur.depth + 1));
					map[tx][ty] = cur.depth + 1;
				}
				if (isFind) {
					break;
				}
			}
			if (isFind) {
				break;
			}
		}
	}

	static void solution() {
		bfs();
	}

	static void printResult() {
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
		K = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) == '.' ? Integer.MAX_VALUE : -1;
			}
		}
		st = new StringTokenizer(br.readLine());
		start = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
		end = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
	}

	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static class Node {
		int x, y, depth;

		public Node(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
}
