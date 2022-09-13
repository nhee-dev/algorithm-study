package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_5547 {
	
	static int W, H;
	static int[][] map;
	static int answer;
	
	static int[][] di = {{-1,-1,0,1,1,0},{-1,-1,0,1,1,0}};
	static int[][] dj = {{-1,0,1,0,-1,-1},{0,1,1,1,0,-1}};
	
	static boolean isBound(int x, int y) {
		if(x<0||x>H+1||y<0||y>W+1) return false;
		return true;
	}
	//건물이 있으면 1, 없으면 0, 외곽으로 증명되면 2
	static boolean search(int x, int y, int z) {
		
		if(x==0||x==H+1||y==0||y==W+1) {
			map[x][y]=2; //외곽
		}
		else {
			map[x][y]=-1; //방문 check
		}
		
		ArrayList<Integer> tmp = new ArrayList<>();
		
		for(int i=0;i<6;i++) {
			int cur_i = x + di[x%2][i];
			int cur_j = y + dj[x%2][i];
			
			if(!isBound(cur_i, cur_j)) continue;
			
			if(map[cur_i][cur_j]==1) {
				z++;
			}
			
			else if(map[cur_i][cur_j]==0) {
				tmp.add(i);
			}
			
			else if(map[cur_i][cur_j]==2) {
				map[x][y]=2;
			}
			
			else if(map[cur_i][cur_j]==-2) {
				return false;
			}
			
		}
		
		if(map[x][y]==2) {
			answer = answer+z;
			return true;
		}
		
		if(map[x][y]!=2) {
			
			for(int i=0;i<tmp.size();i++) {
				map[x][y]=-1;
				if(search(x + di[x%2][tmp.get(i)],y + dj[x%2][tmp.get(i)],z)) {
					map[x][y]=2;
					return true;
				}
				map[x][y]=0;
			}
		}
	
		map[x][y]=-2;
		return false;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		
		
		map = new int[H+2][W+2];
		answer = 0;
		
		for(int i=1;i<H+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<W+1;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());				
			}
		}
		
		//테두리에 0 하나씩 추가
		for(int i=0;i<W+2;i++) {
			map[0][i]=0;
			map[H+1][i]=0;
		}
		for(int i=0;i<H+2;i++) {
			map[i][0]=0;
			map[i][W+1]=0;
		}
		
		for(int i=0;i<H+2;i++) {
			for(int j=0;j<W+2;j++) {
				//6방향 탐색, visited를 만나거나  0이 있으면 개수 +1
				if(map[i][j]==0) {
					search(i,j,0);
				}
			}
		}
		
		System.out.println(answer);
//	
//		for(int[] x: map) {
//			for(int y:x) {
//				System.out.print(y+" ");
//				}
//			System.out.println();
//		}
	}

}
