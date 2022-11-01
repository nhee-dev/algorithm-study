import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int U = 0, R = 1, D = 2, L = 3;
	static int N, M;
	static int[][] map, copy;
	static int[] arr = { 1, 2, 3, 4 };
	static int[] output;
	 상 우 하 좌
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int[] dir = { 0, 4, 2, 4, 4, 1 };


	static ListCCTV cctv;
	static int count = 0;  cctv개수
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		cctv = new ArrayList();
		min = Integer.MAX_VALUE;

		for (int i = 0; i  N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j  M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new CCTV(i, j, map[i][j]));
					count++;
				}
			}
		}

		output = new int[count];
		perm(0, 4, count);
		System.out.println(min);
	}

	public static void perm(int depth, int n, int r) {
		if (depth == r) {
			 check();
			return;
		}
		for (int i = 0; i  n; i++) {
			output[depth] = arr[i];
			perm(depth + 1, n, r);
		}
	}

	public static void check() {
		 output - cctv 방향 1 ~ 4 {4, 4, 4}
		 cctv - cctv 번호 1 ~ 5 ex) {1, 2, 1}
		 dir - cctv별 방향 1 ~ 4 {4, 2}

		 cctv의 타입보다 방향이 많으면 가지치기
		for (int i = 0; i  count; i++) {
			if (dir[cctv.get(i).type]  output[i]) {
				return;
			}
		}
		
		initMap();
		
		for (int i = 0; i  count; i++) {
			cctv.get(i).camera(output[i]);
		}
		
		int sum = 0;
		for (int i = 0; i  N; i++) {
			for (int j = 0; j  M; j++) {
				if(copy[i][j] == 0) {
					sum++;
				}
			}
		}
		if(min  sum) {
			min = sum;
		}		
	}
	
	public static void initMap() {
		for (int i = 0; i  N; i++) {
			for (int j = 0; j  M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

	public static void printMap() {
		for (int i = 0; i  N; i++) {
			for (int j = 0; j  M; j++) {
				System.out.print(map[i][j] +  );
			}
			System.out.println();
		}
	}

	static class CCTV {
		int x, y, type;

		public CCTV(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}

		@Override
		public String toString() {
			return type  + type;
		}
		
		public void go(int cx, int cy, int d) {
			while(true) {
				cx += dx[d];
				cy += dy[d];
				if(cx  0  cx = N  cy  0  cy = M) {
					break;
				}
				if(copy[cx][cy] == 6) {
					break;
				}
				copy[cx][cy] = -1;
			}				
		}
		
		public void camera(int d) {
			switch(type) {
			case 1
				go(x, y, d - 1);				
				break;
			case 2
				if(d == 1) {
					go(x, y, 0);
					go(x, y, 2);				
				} 
				else if(d == 2) {
					go(x, y, 1);
					go(x, y, 3);	
				}	
				break;
			case 3
				if(d == 1) {
					go(x, y, 0);
					go(x, y, 1);					
				} else if(d == 2) {
					go(x, y, 1);
					go(x, y, 2);	
				} else if(d == 3) {
					go(x, y, 2);
					go(x, y, 3);	
				} else if(d == 4) {
					go(x, y, 3);
					go(x, y, 0);	
				}	
				break;
			case 4
				if(d == 1) {
					go(x, y, 0);
					go(x, y, 1);
					go(x, y, 2);					
				} else if(d == 2) {
					go(x, y, 1);
					go(x, y, 2);
					go(x, y, 3);		
				} else if(d == 3) {
					go(x, y, 2);
					go(x, y, 3);
					go(x, y, 0);		
				} else if(d == 4) {
					go(x, y, 3);
					go(x, y, 0);
					go(x, y, 1);	
				}		
				break;
			case 5
				go(x, y, 0);
				go(x, y, 1);	
				go(x, y, 2);
				go(x, y, 3);	
				break;
			}
		}
	}
}
