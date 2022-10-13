import java.util.*;
import java.io.*;

// 백준 1913 달팽이
public class BOJ_1913 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
		int x = 0, y = 0, dir = 0, a = 0, b = 0;

		for (int i = N * N; i >= 1; i--) {
			map[x][y] = i;
			if(i == M) {
				a = x;
				b = y;
			}
			if(i == 1) {
				break;
			}
			
			int nX = x + dx[dir], nY = y + dy[dir];
			if(nX < 0 || nX >= N || nY < 0 || nY >= N) {
				dir++;
				if(dir == 4) {
					dir = 0;
				}
				x += dx[dir];
				y += dy[dir];
				continue;
			}
			
			if(map[nX][nY] != 0) {
				dir++;
				if(dir == 4) {
					dir = 0;
				}
				x += dx[dir];
				y += dy[dir];
				continue;
			}
			x = nX;
			y = nY;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bw.write(map[i][j] + " ");
			}
			bw.write('\n');
		}
		bw.write(String.format("%d %d\n",a + 1, b + 1));
		bw.flush();
		bw.close();
	}

}
