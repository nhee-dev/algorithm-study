import java.util.*;
import java.io.*;

public class BOJ_2667 {
	static int N, count;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Integer> pq;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		init();
		solution();
		printResult();
	}

	static void solution() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;
				if (visited[i][j])
					continue;
				count++;
				pq.add(bfs(i, j));
			}
		}
	}

	static int bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.offer(x);
		qy.offer(y);
		visited[x][y] = true;
	
		int sum = 0;
		while(!qx.isEmpty()) {
			int cx = qx.poll();
			int cy = qy.poll();
			sum++;
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if(visited[nx][ny]) {
					continue;
				}
				if(map[nx][ny] == 0) {
					continue;
				}

				visited[nx][ny] = true;
				qx.offer(nx);
				qy.offer(ny);
			}
		}
		
		return sum;
	}
	

	static void printResult() throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(count));
		bw.write('\n');
		while (!pq.isEmpty()) {
			bw.write(String.valueOf(pq.poll()));
			bw.write('\n');
		}
		bw.close();
	}

	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 0;
		map = new int[N][N];
		visited = new boolean[N][N];
		pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
	}
}
