import java.net.StandardSocketOptions;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1012{

	static int[][] map;
	static boolean[][] visited;
	static int result;
	static int m;
	static int n;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int tc = 1; tc <= testCase; tc ++) {
			result = 0;
			m = sc.nextInt();
			n = sc.nextInt();
			int cNums = sc.nextInt();
			
			map = new int[n][m];
			
			
			
			visited = new boolean[n][m];
			
			for(int i = 0; i < cNums; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				map[y][x] = 1;
			}
			
			
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 1 && visited[i][j] == false) {
						result++;
						dfs(i, j);
					}		
				}
			}	
			
			System.out.println(result);
		} 
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i ++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			
			if(validCheck(newY, newX) == false || map[newY][newX] == 0 || visited[newY][newX] == true) {
				continue;
			} else {
				dfs(newY, newX);
			}
		}
		
	}
	
	static boolean validCheck(int y, int x) {
		if(y < 0 || x < 0 || y >= n || x >= m) {
			return false;
		} else {
			return true;
		}
	}

}
