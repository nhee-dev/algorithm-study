import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303 {
	static int N, M, wSum, bSum;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		init();
		solution();
		printResult();
	}
	
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		wSum = 0;
		bSum = 0;
		
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) == 'W' ? 1 : 0;
			}
		}
	}
	
	public static void solution() {
		for(int i = 0; i < M; i ++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				
				bfs(i, j);
			}
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.offer(x);
		qy.offer(y);
		visited[x][y] = true;
		int count = 1;
		int type = map[x][y];
		
		while(!qx.isEmpty()) {
			int cx = qx.poll();
			int cy = qy.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = cx + dx[i];
				int ty = cy + dy[i];
				
				if(outOfRange(tx, ty)) {
					continue;
				}				
				if(visited[tx][ty]) {
					continue;
				}
				if(map[tx][ty] != type) {
					continue;
				}
				
				qx.offer(tx);
				qy.offer(ty);
				visited[tx][ty] = true;
				count++;
			}
									
		}

		if(type == 1) {
			wSum += count * count;
		} else {
			bSum += count * count;
		}
	}
	
	public static boolean outOfRange(int x, int y) {
		return x < 0 || x >= M || y < 0 || y >= N;
	}
	
	public static void printResult() {
		System.out.println(wSum);
		System.out.println(bSum);		
	}
}
