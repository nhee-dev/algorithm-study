package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BOJ_17086 {
	
	static int N,M;
	static int[][] map;
	static int[] dx = { 1,-1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,-1,-1,-1,1,-1,1};
	static int answer;
	
	static Queue<Point> queue;
	static int visited[][];
	
	static void bfs() {
		
		while(!queue.isEmpty()){
			Point cur = queue.poll();
			
			for(int i=0;i<8;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(isIn(nx,ny)) {
					if(visited[nx][ny]>visited[cur.x][cur.y]+1) {
						visited[nx][ny]=visited[cur.x][cur.y]+1;
						answer = Math.max(answer, visited[nx][ny]);
						queue.offer(new Point(nx,ny));
					}
					
				}
				
			}
		}
		
	}
	
	static boolean isIn(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		queue = new LinkedList<>();
		visited = new int[N][M];
		answer = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j]=Integer.MAX_VALUE;
				if(map[i][j]==1) {
					queue.offer(new Point(i,j));
					visited[i][j]=0;
				}
			}
		}
		bfs();
		
		System.out.println(answer);
		
	}

}
