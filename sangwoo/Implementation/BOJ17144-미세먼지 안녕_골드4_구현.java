import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 백준 17144 미세먼지 안녕!
public class BOJ_17144 {
	public static int R, C, T;
	public static int[][] room, copy;
	public static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	public static int cleanX1, cleanX2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		copy = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 공기 청정기 위치
		for(int i = 0; i < R; i++) {
			if(room[i][0] == -1) {
				cleanX1 = i;
				cleanX2 = i+1;
				break;
			}
		}
		
		for(int i = 0; i < T; i++) {
			diffusion();
			clean();
		}
		System.out.println(countDust());
	}
	
	public static void diffusion() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				// 먼지가 없거나, 있어도 확산 안될양이거나, 공기청정기면 continue
				if(room[i][j] < 5) {
					continue;
				}
				
				int dust = room[i][j] / 5;
				int x= i, y = j;
				for(int k = 0; k < 4; k++) {
					x = i + dx[k];
					y = j + dy[k];
					if(x >= 0 && x < R && y >= 0 && y < C) {
						if(room[x][y] < 0) {
							continue;
						}
						copy[x][y] += dust;
						room[i][j] -= dust;
					}
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(room[i][j] < 0) {
					continue;
				}
				room[i][j] += copy[i][j];
				copy[i][j] = 0;
			}
		}
	}
	
	public static void clean() {
		// 공기 청정기 위, 반시계 방향
		int curX = cleanX1 - 1, curY = 0;		

		while(curX - 1 >= 0) {
			room[curX][curY] = room[curX - 1][curY];
			curX--;
		}
		
		while(curY + 1 < C) {
			room[curX][curY] = room[curX][curY + 1];
			curY++;
		}
		
		while(curX + 1 <= cleanX1) {
			room[curX][curY] = room[curX + 1][curY];
			curX++;
		}
		
		while(curY - 1 > 0) {
			room[curX][curY] = room[curX][curY - 1];
			curY--;
		}
		room[curX][curY] = 0;
		
		
		// 공기 청정기 아래, 시계 방향
		curX = cleanX2 + 1;
		curY = 0;
		
		while(curX + 1 < R) {
			room[curX][curY] = room[curX + 1][curY];
			curX++;
		}
		
		while(curY + 1 < C) {
			room[curX][curY] = room[curX][curY + 1];
			curY++;
		}
		
		while(curX - 1 >= cleanX2) {
			room[curX][curY] = room[curX - 1][curY];
			curX--;
		}
		
		while(curY - 1 > 0) {
			room[curX][curY] = room[curX][curY - 1];
			curY--;
		}
		room[curX][curY] = 0;
	}
	
	public static int countDust() {
		int sum = 2;		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sum += room[i][j];
			}
		}				
		return sum;
	}
}
