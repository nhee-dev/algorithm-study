import java.util.*;
import java.io.*;

// 백준 21611 마법사 상어와 블리자드
public class BOJ_21611 {
	static int[][] map, copy;
	static int N, M;
	static int[] d, s;
	static int[] destory = { 1, 2, 3, 4 }; // 상 하 좌 우
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static int[] ball = { 0, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		d = new int[M];
		s = new int[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			d[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			// 1. 구슬 파괴
			destroyBall(i);
			// 2. 구슬 당기기
			pullBall();
			// 3. 구슬 폭발 (폭발할 수 없을 때까지 반복) -> 구슬마다 기록하기
			explodeBall();
			// 4. 구슬 변화
			changeBall();
			copyMap();
			initMap(copy);
		}

		int sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += ball[i] * (i + 1);
		}
		//System.out.println(sum);
		bw.write(String.valueOf(sum));
		bw.flush();
	}

	static void destroyBall(int idx) {
		// destory = {1, 2, 3, 4}; // 상 하 좌 우
		int centerX = N / 2, centerY = N / 2;
		if (d[idx] == 1) {
			for (int i = 0; i < s[idx]; i++) {
				map[--centerX][centerY] = 0;
			}
		} else if (d[idx] == 2) {
			for (int i = 0; i < s[idx]; i++) {
				map[++centerX][centerY] = 0;
			}
		} else if (d[idx] == 3) {
			for (int i = 0; i < s[idx]; i++) {
				map[centerX][--centerY] = 0;
			}
		} else if (d[idx] == 4) {
			for (int i = 0; i < s[idx]; i++) {
				map[centerX][++centerY] = 0;
			}
		}
	}

	static void pullBall() {
		int x = N / 2, y = N / 2;
		int dir = 0, mCnt = 0, rCnt = 0, change = 1;

		int m_x = x, m_y = y;
		int m_dir = 0, m_mCnt = 0, m_rCnt = 0, m_change = 1;

		for (int i = 1; i < N * N; i++) {
			m_x += dx[m_dir];
			m_y += dy[m_dir];

			m_mCnt++;
			if (m_mCnt == m_change) {
				m_mCnt = 0;
				m_dir++;
				if (m_dir == 4) {
					m_dir = 0;
				}
				m_rCnt++;
				if (m_rCnt == 2) {
					m_rCnt = 0;
					m_change++;
				}
			}

			if (map[m_x][m_y] == 0) {
				continue;
			}

			x += dx[dir];
			y += dy[dir];

			mCnt++;
			if (mCnt == change) {
				mCnt = 0;
				dir++;
				if (dir == 4) {
					dir = 0;
				}
				rCnt++;
				if (rCnt == 2) {
					rCnt = 0;
					change++;
				}
			}
			int temp = map[m_x][m_y];
			map[m_x][m_y] = 0;
			map[x][y] = temp;
		}
	}

	static void explodeBall() {
		while (true) {
			int totalCount = 0;
			int x = N / 2, y = N / 2;
			int dir = 0, mCnt = 0, rCnt = 0, change = 1;
			int r_x = 0, r_y = 0, r_dir = 0, r_mCnt = 0, r_rCnt = 0, r_change = 1;
			int prev = map[x][y], count = 0;

			for (int i = 1; i < N * N; i++) {
				x += dx[dir];
				y += dy[dir];

				mCnt++;
				if (mCnt == change) {
					mCnt = 0;
					dir++;
					if (dir == 4) {
						dir = 0;
					}
					rCnt++;
					if (rCnt == 2) {
						rCnt = 0;
						change++;
					}
				}

				if (prev == map[x][y]) {
					count++;
				} else if (prev != map[x][y]) {
					// 폭발 조건 만족 시
					if (count >= 4) {
						ball[prev - 1] += count;
						totalCount++;
						map[r_x][r_y] = 0;
						for (int j = 1; j < count; j++) {
							r_x += dx[r_dir];
							r_y += dy[r_dir];
							map[r_x][r_y] = 0;

							r_mCnt++;
							if (r_mCnt == r_change) {
								r_mCnt = 0;
								r_dir++;
								if (r_dir == 4) {
									r_dir = 0;
								}
								r_rCnt++;
								if (r_rCnt == 2) {
									r_rCnt = 0;
									r_change++;
								}
							}
						}
					}
					count = 1;
					r_x = x;
					r_y = y;
					r_dir = dir;
					r_mCnt = mCnt;
					r_rCnt = rCnt;
					r_change = change;
				}
				prev = map[x][y];
			}

			if (totalCount == 0) {
				break;
			}
			pullBall();
		}
	}

	static void changeBall() {
		initMap(copy);
		int x = N / 2, y = N / 2;
		int dir = 0, mCnt = 0, rCnt = 0, change = 1;

		int c_x = N / 2, c_y = N / 2;
		int c_dir = 0, c_mCnt = 0, c_rCnt = 0, c_change = 1;

		int prev = map[x][y], count = 1, copyMove = 0;
		for (int i = 1; i < N * N; i++) {
			x += dx[dir];
			y += dy[dir];

			mCnt++;
			if (mCnt == change) {
				mCnt = 0;
				dir++;
				if (dir == 4) {
					dir = 0;
				}
				rCnt++;
				if (rCnt == 2) {
					rCnt = 0;
					change++;
				}
			}

			if (i == 1) {
				prev = map[x][y];
				continue;
			}

			if (prev == map[x][y]) {
				count++;
			} else {
				for (int j = 0; j < 2; j++) {
					c_x += dx[c_dir];
					c_y += dy[c_dir];

					c_mCnt++;
					if (c_mCnt == c_change) {
						c_mCnt = 0;
						c_dir++;
						if (c_dir == 4) {
							c_dir = 0;
						}
						c_rCnt++;
						if (c_rCnt == 2) {
							c_rCnt = 0;
							c_change++;
						}
					}

					if (j == 0) {
						copy[c_x][c_y] = count;
					} else if (j == 1) {
						copy[c_x][c_y] = prev;
					}

					copyMove++;
					if (copyMove >= N * N - 1) {
						return;
					}
				}

				count = 1;
			}

			prev = map[x][y];
		}

	}

	static void initMap(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 0;
			}
		}
	}

	static void copyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}

	static void printMap(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
