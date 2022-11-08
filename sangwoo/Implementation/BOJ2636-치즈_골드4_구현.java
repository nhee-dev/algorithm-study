import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] open;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static List<Point> cheese;
	static int prev;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new ArrayList<>();
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cheese.add(new Point(i, j));
				}
			}
		}
		prev = cheese.size();
		
		int count = 0;
		while(!cheese.isEmpty()) {
			bfs();
			meltCheck();
			doMelt();
			count++;
		}
		
		System.out.println(count);
		System.out.println(prev);
	}
	
	public static void bfs() {
		open = new boolean[N][M];
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		
		qx.offer(0);
		qy.offer(0);
		open[0][0] = true;
		
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			for(int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx < 0 || cx >= N || cy < 0 || cy >= M) {
					continue;
				}
				if(open[cx][cy]) {
					continue;
				}
				if(map[cx][cy] == 1) {
					continue;
				}
				open[cx][cy] = true;
				qx.offer(cx);
				qy.offer(cy);
			}
		}
	}
	
	public static void meltCheck() {
		prev = cheese.size();
		for(int i = cheese.size() - 1; i >= 0; i--) {
			Point c = cheese.get(i);
			int count = 0;
			for(int j = 0; j < 4; j++) {
				int x = c.x + dx[j];
				int y = c.y + dy[j];
				
				if(x < 0 || x >= N || y < 0 || y >= M) {
					continue;
				}
				
				if(map[x][y] == 0 && open[x][y]) {
					count++;
					break;
				}
			}
			if(count > 0) {
				c.isMelt = true;
			}
		}
	}
	
	public static void doMelt() {
		for(int i = cheese.size() - 1; i >= 0; i--) {
			Point c = cheese.get(i);
			if(c.isMelt) {
				map[c.x][c.y] = 0;
				cheese.remove(i);
			}
		}
	}

	static class Point {
		int x, y;
		boolean isMelt;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.isMelt = false;
		}
		
		@Override
		public String toString() {
			return String.format("x: %d, y: %d", x, y);
		}
	}
}
