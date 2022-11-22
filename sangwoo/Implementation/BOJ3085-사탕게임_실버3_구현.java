import java.io.*;

public class BOJ_3085 {
	static char[][] map;
	static int N, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				swap(i, j, i, j + 1);
				checkVertical(j);
				checkVertical(j + 1);
				checkHorizental(i);
				swap(i, j, i, j + 1);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				swap(j, i, j + 1, i);
				checkVertical(i);				
				checkHorizental(j);				
				checkHorizental(j + 1);
				swap(j, i, j + 1, i);
			}
		}
		System.out.println(max);
	}

	static void checkHorizental(int x) {
		char prev = map[x][0];
		int count = 1;
		for (int i = 1; i < N; i++) {
			if (prev != map[x][i]) {
				prev = map[x][i];
				if (max < count) {
					max = count;
				}
				count = 1;
				continue;
			}
			count++;
		}
		if (max < count) {
			max = count;
		}
	}

	static void checkVertical(int y) {
		char prev = map[0][y];
		int count = 1;
		for (int i = 1; i < N; i++) {
			if (prev != map[i][y]) {
				prev = map[i][y];
				if (max < count) {
					max = count;
				}
				count = 1;
				continue;
			}
			count++;
		}
		if (max < count) {
			max = count;
		}
	}
	
	static void swap(int x1, int y1, int x2, int y2) {
		char temp = map[x1][y1];
		map[x1][y1] = map[x2][y2];
		map[x2][y2] = temp;
	}
}
