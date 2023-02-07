import java.util.Scanner;

public class Main {
	static int H, W;
	static char[][] cloud;
	static int[][] time;

	public static void main(String[] args) {
		initData();
		solution();
		output();
	}

	static void initData() {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		
		cloud = new char[H][W];
		time = new int[H][W];

		for (int i = 0; i < H; i++) {
			String str = sc.next();
			for (int j = 0; j < W; j++) {
				cloud[i][j] = str.charAt(j);
				time[i][j] = -1;
			}
		}
	}
	
	static void solution() {
		int minutes = 0;
		while (minutes < W) {
			checkCloudLocation(minutes);
			moveCloudLocation();
			minutes++;
		}
	}

	static void checkCloudLocation(int minutes) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (cloud[i][j] == 'c' & time[i][j] == -1) {
					time[i][j] = minutes;
				}
			}
		}
	}

	static void moveCloudLocation() {
		for (int i = 0; i < H; i++) {
			for (int j = W - 2; j >= 0; j--) {
				if (cloud[i][j] == 'c') {
					cloud[i][j + 1] = 'c';
					cloud[i][j] = '.';
				}
			}
		}
	}

	static void output() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(time[i][j] + " ");
			}
			System.out.println();
		}
	}
}
