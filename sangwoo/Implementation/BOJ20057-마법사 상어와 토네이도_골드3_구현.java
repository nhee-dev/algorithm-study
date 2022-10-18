import java.util.;
import java.io.;

 백준 20057 마법사 상어와 토네이도
public class BOJ_20057 {
	static int[][] map;
	static int N, sum;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	 좌, 하, 우, 상
	 5, 10(1), 10(2), 7(1), 7(2), 2(1), 2(2), 1(1), 1(2) - 9개
	static int[][] px = { { 0, -1, 1, -1, 1, -2, 2, -1, 1 }, { 2, 1, 1, 0, 0, 0, 0, -1, -1 },
			{ 0, -1, 1, -1, 1, -2, 2, -1, 1 }, { -2, -1, -1, 0, 0, 0, 0, 1, 1 } };
	static int[][] py = { { -2, -1, -1, 0, 0, 0, 0, 1, 1 }, { 0, -1, 1, -1, 1, -2, 2, -1, 1 },
			{ 2, 1, 1, 0, 0, 0, 0, -1, -1 }, { 0, -1, 1, -1, 1, -2, 2, -1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		sum = 0;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i  N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j  N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x = N  2, y = N  2;
		int dir = 0, mCnt = 0, rCnt = 0, change = 1;
		for (int i = 1; i  N  N; i++) {
			x += dx[dir];
			y += dy[dir];
			moveDust(dir, x, y);

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
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}

	public static void moveDust(int dir, int x, int y) {
		 dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
		 좌, 하, 우, 상
		 (0,-1), (1, 0), (0, 1), (-1, 0)

		if (map[x][y] == 0) {
			return;
		}

		 모래가 %로 확산되지 않을 경우
		if (map[x][y]  10) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			 밖으로 밀려난 경우
			if (outOfRange(nextX, nextY)) {
				sum += map[x][y];
				map[x][y] = 0;
				return;
			}
			map[nextX][nextY] += map[x][y];
			map[x][y] = 0;
			return;
		}
		 모래가 확산되는 경우
		 10, 15, 20, 50, 100
		 좌, 하, 우, 상
		 5, 10(1), 10(2), 7(1), 7(2), 2(1), 2(2), 1(1), 1(2) - 9개
		int t_x = 0, t_y = 0;
		int valueSum = 0, value = 0;
		for (int i = 0; i  9; i++) {
			switch (i) {
			case 0
				value = (int) (map[x][y]  5  100);
				break;
			case 1
			case 2
				value = (int) (map[x][y]  10  100);
				break;
			case 3
			case 4
				value = (int) (map[x][y]  7  100);
				break;
			case 5
			case 6
				value = (int) (map[x][y]  2  100);
				break;
			case 7
			case 8
				value = (int) (map[x][y]  1  100);
				break;
			}

			if (value  1) {
				continue;
			}
			valueSum += value;
			t_x = x + px[dir][i];
			t_y = y + py[dir][i];
			if (outOfRange(t_x, t_y)) {
				sum += value;
			} else {
				map[t_x][t_y] += value;
			}
		}
		map[x][y] -= valueSum;

		int a_x = x + dx[dir];
		int a_y = y + dy[dir];
		 밖으로 밀려난 경우
		if (outOfRange(a_x, a_y)) {
			sum += map[x][y];
			map[x][y] = 0;
			return;
		}
		map[a_x][a_y] += map[x][y];
		map[x][y] = 0;
	}

	public static boolean outOfRange(int x, int y) {
		if (x  0  x = N  y  0  y = N) {
			return true;
		}
		return false;
	}
}
