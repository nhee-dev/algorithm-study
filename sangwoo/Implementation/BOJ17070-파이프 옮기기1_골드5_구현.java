import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070 {
	static int N, count = 0;
	static int[][] map;
	static boolean[][] visited;
	// 오른쪽, 대각선 오른쪽 아래, 아래
	static int[] dx = { 0, 1, 1 }, dy = { 1, 1, 0 };
	static int RIGHT = 0, RIGHT_DOWN = 1, DOWN = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0][0] = true;
		visited[0][1] = true;
		dfs(new Point(0, 1, 0));
		System.out.println(count);
	}

	static void dfs(Point p) {
		if(p.dir == RIGHT) {
			for(int i = RIGHT; i <= RIGHT_DOWN; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];
				if (outOfRange(cx, cy)) {
					continue;
				}
				if (visited[cx][cy]) {
					continue;
				}
				if (map[cx][cy] == 1) {
					continue;
				}
				if(i == RIGHT_DOWN) {
					int lx = p.x + dx[0], ly = p.y + dy[0];
					int rx = p.x + dx[2], ry = p.y + dy[2];
					
					if(!outOfRange(lx, ly)) {
						if(map[lx][ly] == 1) {
							continue;
						}
					}
					if(!outOfRange(rx, ry)) {
						if(map[rx][ry] == 1) {
							continue;
						}
					}			
				}
				if(cx == N - 1 && cy == N - 1) {
					count++;
					continue;
				}
				visited[cx][cy] = true;
				dfs(new Point(cx, cy, i));
				visited[cx][cy] = false;				
			}
			
		} else if(p.dir == RIGHT_DOWN) {
			for(int i = RIGHT; i <= DOWN; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];
				if (outOfRange(cx, cy)) {
					continue;
				}
				if (visited[cx][cy]) {
					continue;
				}
				if (map[cx][cy] == 1) {
					continue;
				}
				if(i == RIGHT_DOWN) {
					int lx = p.x + dx[0], ly = p.y + dy[0];
					int rx = p.x + dx[2], ry = p.y + dy[2];
					
					if(!outOfRange(lx, ly)) {
						if(map[lx][ly] == 1) {
							continue;
						}
					}
					if(!outOfRange(rx, ry)) {
						if(map[rx][ry] == 1) {
							continue;
						}
					}			
				}
				if(cx == N - 1 && cy == N - 1) {
					count++;
					continue;
				}
				visited[cx][cy] = true;
				dfs(new Point(cx, cy, i));
				visited[cx][cy] = false;				
			}			
		} else if(p.dir == DOWN) {
			for(int i = RIGHT_DOWN; i <= DOWN; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];
				if (outOfRange(cx, cy)) {
					continue;
				}
				if (visited[cx][cy]) {
					continue;
				}
				if (map[cx][cy] == 1) {
					continue;
				}
				if(i == RIGHT_DOWN) {
					int lx = p.x + dx[0], ly = p.y + dy[0];
					int rx = p.x + dx[2], ry = p.y + dy[2];
					
					if(!outOfRange(lx, ly)) {
						if(map[lx][ly] == 1) {
							continue;
						}
					}
					if(!outOfRange(rx, ry)) {
						if(map[rx][ry] == 1) {
							continue;
						}
					}			
				}
				if(cx == N - 1 && cy == N - 1) {
					count++;
					continue;
				}
				visited[cx][cy] = true;
				dfs(new Point(cx, cy, i));
				visited[cx][cy] = false;				
			}
		}
	}
	
	static boolean outOfRange(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int x, y, dir;
		public Point(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return String.format("x: %d, y: %d, dir: %d", x, y, dir);
		}
	}
}