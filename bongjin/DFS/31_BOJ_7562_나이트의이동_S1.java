package boj;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 31_BOJ_7562_나이트의이동_S1 {
	
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
	static int[][] v;
	static int mx, my, px, py, size, result;
	
	static Queue<Point> q;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int T = 0; T < tc; T++)
		{
			size = sc.nextInt();
			mx = sc.nextInt();
			my = sc.nextInt();
			px = sc.nextInt();
			py = sc.nextInt();
			result = 0;
			q = new LinkedList<Point>();
			v = new int[size][size];

			dfs(mx, my);
			System.out.println(result - 1);
		}
		
	}
	
	static void dfs(int x, int y) {
		q.offer(new Point(x, y));
		v[x][y] = 1;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == px && p.y == py) {
				result = v[p.x][p.y];
				return;
			}			
			for(int d = 0; d < 8; d++) {
				Point np = new Point(p.x + dx[d], p.y + dy[d]);
				if(np.x < 0 || np.y < 0 || np.x >= size || np.y >= size) continue;
				if(v[np.x][np.y] == 0) {
					q.offer(np);
					v[np.x][np.y] = v[p.x][p.y] + 1;
				}
			}
		}
	}
	
	static class Point{
		private int x;
		private int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
