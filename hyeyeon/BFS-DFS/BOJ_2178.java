package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
	int x, y;
	public Position(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BOJ_2178 {
	
	static int N,M;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};

	static void bfs() {
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(0,0));
		
		visited[0][0]=1; //추가한 노드 방문처리
		
		while(!queue.isEmpty()) {
			Position position = queue.poll();
			int x = position.x;
			int y = position.y;
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(!isBound(nx,ny)) {
					if(visited[nx][ny]==0&&map[nx][ny]==1) {
						queue.add(new Position(nx,ny));
						visited[nx][ny]=visited[x][y]+1;
					}
				}
		}
		}
		
	}
	static boolean isBound(int x, int y) {
		if(x<0||x>=N||y<0||y>=M) return true;
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited=new int[N][M];

		for(int i=0;i<N;i++) {
			String[] tmp = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		
		bfs();
		System.out.println(visited[N-1][M-1]);
	}

}
