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
	int broken; //부쉈는지 아닌지
	int dis; //이동거리
	
	Point(int x, int y, int broken, int dis){
		this.x = x;
		this.y = y;
		this.broken = broken;
		this.dis = dis;
	}
}

public class BOJ_2206 {

	static int N,M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1,1,0,0 };
	static int[] dy = { 0,0,-1,1 };
	
	static boolean isIn(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) return false;
		return true;
	}
	
	
	static int bfs() {
		
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(0,0,0,1));
		visited[0][0][0]=true; //방문check
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if(cur.x==N-1&&cur.y==M-1) { //목적지 만나면 dis 반환
				return cur.dis;
			}
			
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(!isIn(nx,ny)||visited[cur.broken][nx][ny]) continue; //map 이탈
				
				visited[cur.broken][nx][ny]=true;
				if(map[nx][ny]==0) {
					queue.add(new Point(nx,ny,cur.broken,cur.dis+1));
				}
				else if(map[nx][ny]==1&&cur.broken==0) {
					queue.add(new Point(nx,ny,1,cur.dis+1));
				}

			}
		}
		return -1;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[2][N][M]; //0일때는 안부수면서 이동, 1은 부수면서 이동
		
		for(int i=0;i<N;i++) {
			String[] tmp = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		int answer = bfs();
		
		System.out.println(answer);
	}

}
