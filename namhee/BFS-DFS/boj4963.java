import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int w, h, islands;
	static int[][] map = new int[50][50];
	static boolean[][] visited = new boolean[50][50];
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		while(true) {
			initData();
			if (isLastInput()) { break; }
			solution();
			System.out.println(islands);
		}
	}

	static void initData() throws IOException {
		String[] size = br.readLine().split(" ");
		w = Integer.parseInt(size[0]);
		h = Integer.parseInt(size[1]);
		
		for (int i = 0; i < h; i++) {
			String[] mapInfo = br.readLine().split(" ");

			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(mapInfo[j]);
				visited[i][j] = false;
			}
		}
		
		islands = 0;		
	}
	
	static boolean isLastInput() {
		return w == 0 && h == 0;
	}
	
	static void solution() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					// dfs(i, j);
					islands++;
				}
			}
		}
	}

  // 실행시간 : 188ms
	static void bfs(int y, int x) {
		int[] queueX = new int[w * h];
		int[] queueY = new int[w * h];
		int rear = -1, front = -1;
		
		queueX[++rear] = x;
		queueY[rear] = y;
		visited[y][x] = true;
	
		int nx, ny;
		while (front != rear) {
			x = queueX[++front];
			y = queueY[front];
			
			for (int i = 0; i < 8; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (!isWall(nx, ny) && !visited[ny][nx] && map[ny][nx] == 1) {
					queueX[++rear] = nx;
					queueY[rear] = ny;
					visited[ny][nx] = true;								
				}
			}
		}
	}

  // 실행시간 : 220ms
	static void dfs(int y, int x) {
		int[] stackX = new int[w * h * 8];
		int[] stackY = new int[w * h * 8];
		int top = -1;

		stackX[++top] = x;
		stackY[top] = y;

		int nx, ny;
		while (top > -1) {
			x = stackX[top];
			y = stackY[top--];
			
			if (!visited[y][x]) {
				visited[y][x] = true;
				for (int i = 0; i < 8; i++) {
					nx = x + dx[i];
					ny = y + dy[i];
					
					if (!isWall(nx, ny) && !visited[ny][nx] && map[ny][nx] == 1) {
						stackX[++top] = nx;
						stackY[top] = ny;
					}
				}
			}
		}
	}

	static boolean isWall(int x, int y) {
		return x < 0 || x >= w || y < 0 || y >= h;
	}
}
