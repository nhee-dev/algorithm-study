package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳_G4 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R,C;
	static char[][] arr;
	static boolean[] visited;
	static int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
	static int max,cnt;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		arr=new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		visited = new boolean [26];
		v = new boolean[R][C];
		max = Integer.MIN_VALUE;

		cnt = 1;
		dfs(0,0);
		System.out.println(max);
	}
	private static void dfs(int x, int y) {
		visited[arr[x][y] - 65] = true;
		v[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if (check(nx,ny)) {
				if(visited[arr[nx][ny] - 65] == false && v[nx][ny] == false) {
					cnt++;
					dfs(nx,ny);
				}
			}
		}
		max = max < cnt ? cnt : max;
		cnt--;
		visited[arr[x][y] - 65] = false;
		v[x][y] = false;
	}
	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

}