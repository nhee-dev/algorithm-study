import java.util.*;
import java.io.*;

// 백준 23290 마법사 상어와 복제
public class BOJ23290 {
	static List<Fish> map[][];
	static List<Fish> list, copy;
	static int[][] smell;
	static int M, S, N = 4;
	static Fish shark;
	static int[] fx = { 0, -1, -1, -1, 0, 1, 1, 1 }, fy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] sx = { -1, 0, 1, 0 }, sy = { 0, -1, 0, 1 };
	static int[] s_dir = { 1, 2, 3, 4 };
	static int[] output;
	static int max, min_dir;

	static class Fish {
		int x, y, d;

		public Fish(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		public Fish copy() {
			return new Fish(x, y, d);
		}

		public void move() {
			int n_x = 0, n_y = 0;
			for (int i = 0; i < 8; i++) {
				n_x = x + fx[d];
				n_y = y + fy[d];

				if (n_x < 0 || n_x >= N || n_y < 0 || n_y >= N) {
					chanageDir();
					continue;
				}
				if (n_x == shark.x && n_y == shark.y) {
					chanageDir();
					continue;
				}
				if (smell[n_x][n_y] > 0) {
					chanageDir();
					continue;
				}

				x = n_x;
				y = n_y;
				break;
			}
		}

		public void chanageDir() {
			d--;
			if (d < 0)
				d = 7;
		}

		@Override
		public String toString() {
			return String.format("Fish(x:%d,y:%d,d:%d)", x, y, d);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		copy = new ArrayList<>();
		smell = new int[N][N];
		map = new ArrayList[4][4];
		output = new int[3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			list.add(new Fish(x, y, d));
		}
		st = new StringTokenizer(br.readLine());
		shark = new Fish(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

		for (int i = 0; i < S; i++) {
			// 1. 물고기 복제
			copyFish();
			// 2. 물고기 이동
			moveFish();
			addMap();
			// 3. 상어 이동
			moveShark();
			// 4. 냄새 제거
			removeSmell();
			// 5. 복제 완료
			completeCopy();
			init();
		}
		bw.write(String.valueOf(list.size()));
		bw.flush();
		bw.close();
	}

	static void copyFish() {
		for (int i = 0; i < list.size(); i++) {
			copy.add(list.get(i).copy());
		}
	}

	static void moveFish() {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).move();
		}
	}

	static void addMap() {
		for (int i = 0; i < list.size(); i++) {
			Fish fish = list.get(i);
			map[fish.x][fish.y].add(fish);
		}
	}

	static void moveShark() {
		max = Integer.MIN_VALUE;
		min_dir = Integer.MAX_VALUE;
		per(0, 4, 3, shark.x, shark.y);

		int[] dir = new int[3];
		dir[0] = (int) (min_dir / 100) - 1;
		dir[1] = ((int) (min_dir / 10)) % 10 - 1;
		dir[2] = min_dir % 10 - 1;

		for (int i = 0; i < 3; i++) {
			shark.x += sx[dir[i]];
			shark.y += sy[dir[i]];
			eatFish();
		}
	}

	static void eatFish() {
		int value = map[shark.x][shark.y].size();
		if (value > 0) {
			smell[shark.x][shark.y] = 3;
			map[shark.x][shark.y].clear();
		}
	}

	static void per(int depth, int n, int r, int x, int y) {
		if (depth == r) {
			countFish();
			return;
		}
		for (int i = 0; i < n; i++) {
			int n_x = x + sx[s_dir[i] - 1];
			int n_y = y + sy[s_dir[i] - 1];
			if (n_x < 0 || n_x >= N || n_y < 0 || n_y >= N) {
				continue;
			}
			output[depth] = s_dir[i];
			per(depth + 1, n, r, n_x, n_y);
		}
	}

	static void countFish() {
		boolean[][] visited = new boolean[4][4];
		int x = shark.x;
		int y = shark.y;
		int sum = 0;

		for (int i = 0; i < 3; i++) {
			x += sx[output[i] - 1];
			y += sy[output[i] - 1];
			if (!visited[x][y]) {
				sum += map[x][y].size();
			}
			visited[x][y] = true;
		}
		int res = (100 * output[0]) + (10 * output[1]) + output[2];
		if (max < sum) {
			max = sum;
			min_dir = res;
		}
		if (max == sum) {
			if (min_dir > res) {
				min_dir = res;
			}
		}
	}

	static void removeSmell() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (smell[i][j] > 0) {
					smell[i][j]--;
				}
			}
		}
	}

	static void completeCopy() {
		for (int i = 0; i < copy.size(); i++) {
			Fish fish = copy.get(i);
			map[fish.x][fish.y].add(fish);
		}
	}

	static void init() {
		list.clear();
		copy.clear();
		max = Integer.MIN_VALUE;
		min_dir = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			output[i] = 0;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for(int k = 0; k < map[i][j].size(); k++) {
					list.add(map[i][j].get(k));
				}
				map[i][j].clear();
			}
		}
	}
}
