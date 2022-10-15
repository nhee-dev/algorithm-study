import java.util.*;
import java.io.*;

// 백준 23288 주사위 굴리기2
public class BOJ_23288 {
	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dice = { { 0, 2, 0 }, { 4, 1, 3 }, { 0, 5, 0 }, { 0, 6, 0 } };
	static int sum;
	static int DOWN_X = 3, DOWN_Y = 1;
	// 상 우 하 좌
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// K 만큼 이동
		int dir = 1;
		int x = 0, y = 0;
		for (int i = 0; i < K; i++) {
			// 주사위 한칸 이동
			int n_x = x + dx[dir];
			int n_y = y + dy[dir];
			if (outOfRange(n_x, n_y)) {
				dir = (dir + 2) % 4;
				n_x = x + dx[dir];
				n_y = y + dy[dir];
			}

			// 상 우 하 좌
			// 방향에 맞춰 전개도 변경
			if (dir == 0) {
				int temp = dice[0][1];
				for (int j = 0; j < 3; j++) {
					dice[j][1] = dice[j + 1][1];
				}
				dice[3][1] = temp;
			} else if (dir == 1) {
				int temp = dice[1][2];
				dice[1][2] = dice[1][1];
				dice[1][1] = dice[1][0];
				dice[1][0] = dice[3][1];
				dice[3][1] = temp;
			} else if (dir == 2) {
				int temp = dice[3][1];
				for (int j = 3; j > 0; j--) {
					dice[j][1] = dice[j - 1][1];
				}
				dice[0][1] = temp;
			} else if (dir == 3) {
				int temp = dice[1][0];
				dice[1][0] = dice[1][1];
				dice[1][1] = dice[1][2];
				dice[1][2] = dice[3][1];
				dice[3][1] = temp;
			}

			// 점수 획득
			int B = map[n_x][n_y];
			initVisited();
			int C = dfs(n_x, n_y, B);
			sum += B * C;

			// 이동방향 결정
			int A = dice[DOWN_X][DOWN_Y];
			if(A > B) {
				dir++;
				if(dir == 4) {
					dir  = 0;
				}
			} else if(A < B) {
				dir--;
				if(dir < 0) {
					dir  = 3;
				}
			}
			x = n_x;
			y = n_y;
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}

	static int dfs(int x, int y, int B) {		
		visited[x][y] = true;
		
		int res = 0;
		for(int i = 0; i < 4; i++) {
			int n_x = x + dx[i];
			int n_y = y + dy[i];
			if(outOfRange(n_x, n_y)) {
				continue;
			}
			if(map[n_x][n_y] != B) {
				continue;
			}
			if(visited[n_x][n_y]) {
				continue;
			}
			res += dfs(n_x, n_y, B);
		}
		return res + 1;
	}

	static void initVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = false;
			}
		}
	}

	static boolean outOfRange(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M) {
			return true;
		}
		return false;
	}
}
