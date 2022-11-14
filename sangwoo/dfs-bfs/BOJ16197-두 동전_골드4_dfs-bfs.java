import java.util.*;
import java.io.*;

public class BOJ_16197 {
	static int N, M, min;
	static int[][] map;
	static Coin[] coins;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		init();
		solution();
		result();
	}

	static void result() {
		System.out.println(min);
	}

	static void solution() {
		Queue<Coin> q1 = new LinkedList<>();
		Queue<Coin> q2 = new LinkedList<>();
		q1.offer(coins[0]);
		q2.offer(coins[1]);
		int level = 0;
		boolean isEnd = false;
		while(!q1.isEmpty()) {
			int size = q1.size();
			for(int i = 0; i < size; i++) {
				Coin c1 = q1.poll();
				Coin c2 = q2.poll();

				// 4방탐색
				for(int j = 0; j < 4; j++) {
					int tx1 = c1.x + dx[j];
					int ty1 = c1.y + dy[j];
					int tx2 = c2.x + dx[j];
					int ty2 = c2.y + dy[j];
					
					// 둘 다 밖으로 나가는 경우 continue
					if(outOfRange(tx1, ty1) && outOfRange(tx2, ty2)) {
						continue;
					}
					
					// 둘 중 하나만 밖인 경우 break;
					if((outOfRange(tx1, ty1) && !outOfRange(tx2, ty2)) 
							|| (!outOfRange(tx1, ty1) && outOfRange(tx2, ty2))) {
						isEnd = true;	
						break;
					}
					
					// 둘 다 벽인 경우 continue
					if(map[tx1][ty1] == 1 && map[tx2][ty2] == 1) {
						continue;
					}
					
					if(map[tx1][ty1] == 1) {
						q1.offer(c1);
					} else {
						q1.offer(new Coin(tx1, ty1));
					}
					
					if(map[tx2][ty2] == 1) {
						q2.offer(c2);
					} else {
						q2.offer(new Coin(tx2, ty2));	
					}									
				}
				if(isEnd) {
					break;
				}
			}
			level++;
			if(level > 10) {
				break;
			}
			if(isEnd) {
				min = level;
				break;
			}
		}
	}

	static boolean outOfRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
	}

	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		coins = new Coin[2];
		min = -1;
		for (int i = 0, k = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				if (line.charAt(j) == 'o') {
					coins[k++] = new Coin(i, j);
					map[i][j] = 0;
				} else if (line.charAt(j) == '.') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}
	}

	static class Coin {
		int x, y;

		public Coin(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
