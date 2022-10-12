import java.io.;
import java.util.;

 백준 23291 어항 정리
public class BOJ_23291 {
	static int N, K;
	static int[][] fish;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		fish = new int[25][N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i  N; i++) {
			fish[24][i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		while(true) {
			sum++;				
			
			addFish();	
			stackFish();
			divideFish();
			downFish();
			foldFish();
			divideFish();
			downFish();			
			
			 어항안의 물고기 최대, 최소 비교
			int max = -1;
			int min = 10001;			
			for(int i = 0; iN; i++) {
				if(fish[24][i]  min) {
					min = fish[24][i];
				}
				if(fish[24][i]  max) {
					max = fish[24][i];
				}
			}
			if(max - min = K) {
				break;
			}
		}
		 System.out.println(sum);
	}

	static void addFish() {
		int min = 10001;
		ListInteger mins = new ArrayList();
		for (int i = 0; i  N; i++) {
			if (fish[24][i]  min) {
				min = fish[24][i];
				mins.clear();
				mins.add(i);
				continue;
			}
			if (fish[24][i] == min) {
				mins.add(i);
			}
		}

		for (int i = 0; i  mins.size(); i++) {
			fish[24][mins.get(i)]++;
		}
	}

	static void stackFish() {
		 가장 왼쪽 어항 1개 바로 오른쪽 위에 쌓기
		fish[23][1] = fish[24][0];
		fish[24][0] = 0;

		while (true) {
			boolean isFirst = true;
			int start = 0, end = 0;
			for (int i = 0; i  N; i++) {
				if (fish[23][i] == 0) {
					if (!isFirst) {
						break;
					}
					continue;
				}

				if (fish[23][i] != 0) {
					if (isFirst) {
						isFirst = false;
						start = i;
					}
					end = i;
					continue;
				}
			}

			int length = end - start + 1;
			int height = 1;
			for (int i = 24; i = 0; i--) {
				if (fish[i][start] == 0) {
					height = 24 - i;
					break;
				}
			}

			if (height  N - 1 - end) {
				break;
			}

			for (int i = 25 - height; i  25; i++) {
				for (int j = start; j = end; j++) {
					fish[24 - length + (j - start)][end + height - (i - 25 + height)] = fish[i][j];
					fish[i][j] = 0;
				}
			}		
		}
	}

	static void divideFish() {
		boolean[][] visited = new boolean[25][N];
		int[][] temp = new int[25][N];
		for (int i = 0; i  25; i++) {
			for (int j = 0; j  N; j++) {
				visited[i][j] = fish[i][j] == 0  true  false;
			}
		}

		QueuePoint q = new LinkedList();
		q.offer(new Point(24, N - 1));
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (visited[p.x][p.y]) {
				continue;
			}
			visited[p.x][p.y] = true;
			for (int i = 0; i  4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (x = 0 && x  25 && y = 0 && y  N) {
					if (!visited[x][y]) {
						q.offer(new Point(x, y));

						if (Math.abs(fish[p.x][p.y] - fish[x][y])  5) {
							continue;
						}

						if (fish[p.x][p.y]  fish[x][y]) {
							int d = (int) ((fish[x][y] - fish[p.x][p.y])  5);
							temp[x][y] -= d;
							temp[p.x][p.y] += d;
						}

						if (fish[p.x][p.y]  fish[x][y]) {
							int d = (int) ((fish[p.x][p.y] - fish[x][y])  5);
							temp[p.x][p.y] -= d;
							temp[x][y] += d;
						}
					}
				}
			}
		}

		for (int i = 0; i  25; i++) {
			for (int j = 0; j  N; j++) {
				fish[i][j] += temp[i][j];
			}
		}
	}
	
	static void downFish() {
		ListInteger line = new ArrayList();
		for(int i = 0; i N; i++) {
			for(int j = 24; j = 0; j--) {
				if(fish[j][i] != 0) {
					line.add(fish[j][i]);
					fish[j][i] = 0;
				}
			}
		}
		
		for(int i = 0; iN; i++) {
			fish[24][i] = line.get(i);
		}
	}
	
	static void foldFish() {
		int center = N  2;
		for(int i = 0; i  center; i++) {
			fish[23][N - 1 - i] = fish[24][i];
			fish[24][i] = 0;
		}
		
		int start = center;
		center = start + (N - center)  2;
		
		for(int i = 23; i  25; i++) {
			for(int j = start; j  center; j++) {
				fish[22 - (i - 23)][N - 1 - (j - start)] = fish[i][j];
				fish[i][j] = 0;
			}
		}
		
	}	
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
