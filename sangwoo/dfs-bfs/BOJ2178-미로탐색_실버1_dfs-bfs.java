import java.util.*;
import java.io.*;

public class BOJ_2178 {

	static int N, M, min;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		init();
		solution();
		printResult();
	}

	static void solution() {
		//bfs_level();
		bfs_node();
	}
	
	static void bfs_node() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 1));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.x == N - 1 && cur.y == M - 1) {
				min = cur.depth;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int tx = cur.x + dx[i];
				int ty = cur.y + dy[i];

				if (outOfRange(tx, ty)) {
					continue;
				}
				if (visited[tx][ty]) {
					continue;
				}
				if (map[tx][ty] == 0) {
					continue;
				}
				q.offer(new Node(tx, ty, cur.depth + 1));
				visited[tx][ty] = true;
			}
		}
	}

	static void bfs_level() {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.offer(0);
		qy.offer(0);
		visited[0][0] = true;
		boolean isArrive = false;

		while (!qx.isEmpty() && !isArrive) {
			int size = qx.size();

			for (int i = 0; i < size; i++) {
				int cx = qx.poll();
				int cy = qy.poll();
				
				if(cx == N - 1 && cy == M - 1) {
					isArrive = true;
					break;
				}

				for (int j = 0; j < 4; j++) {
					int tx = cx + dx[j];
					int ty = cy + dy[j];

					if (outOfRange(tx, ty)) {
						continue;
					}
					if (visited[tx][ty]) {
						continue;
					}
					if (map[tx][ty] == 0) {
						continue;
					}
					
					qx.offer(tx);
					qy.offer(ty);
					visited[tx][ty] = true;
				}
			}
			min++;
		}
	}

	static boolean outOfRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
	}

	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
	}

	static void printResult() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(min));
		bw.flush();
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
