package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class SWEA_2117 {
	
	static class Node {
		int x, y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static Queue<Node> q;
	static int answer;
	
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	
	static void bfs(int r, int c) {
		
		
		q.offer(new Node(r,c));
		visited[r][c]=true;
		
		int K = 1;
		int house = map[r][c]==1?1:0; //1이면1, 아니면 0
		
		if(getCost(K)<=house*M) {
			//비용이 걷은 비용보다 작으면 즉, 이득이면
			answer = K>answer ? K:answer;
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			K++;
			
			for(int i=0;i<size;i++) {
				Node cur = q.poll();
				
				for(int d=0;d<4;d++) {
					int nx = cur.x+dir[d][0];
					int ny = cur.y+dir[d][1];
					
					if(nx<0||nx>=N||ny<0||ny>=N||visited[nx][ny]) continue;
					
					if(map[nx][ny]==1) house++;
					
					q.offer(new Node(nx,ny));
					visited[nx][ny]=true;
				}
			}
			
			if(getCost(K)<=house*M) {
				answer = house > answer ? house : answer;
			}
			
		}
	}
	
	static int getCost(int k) {
		return k*k+(k-1)*(k-1);
	}
	
	static void init() {
		q.clear();
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				visited[r][c]=false;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 1;
//		int T = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			q = new LinkedList<>();
			
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					map[r][c]=Integer.parseInt(st.nextToken());
					
				}
			}
			
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					init();
					bfs(r,c);
				}
			}
			
			System.out.println(answer);
		}
	}

}
