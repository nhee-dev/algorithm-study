import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	static final int MAX_COMPLEX_NUM = 313;
	static int N, totalComplexNum;
	static int[] houseNum = new int[MAX_COMPLEX_NUM + 1];
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		inputData();
		initData();

		solution();
		
		outputAnswer();
	}
	
	static void inputData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] strArr = br.readLine().split("");
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(strArr[j]);
			}
		}
	}

	static void initData() {
		totalComplexNum = 0;
		visited = new boolean[N][N];
	}
	
	static void solution() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					totalComplexNum++;
					dfs(i, j);
				}
			}
		}		

		sortHouseNum();
	}
	
	static void dfs(int y, int x) {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int[] stackX = new int[N * N];
		int[] stackY = new int[N * N];
		int top = -1;

		stackX[++top] = x;
		stackY[top] = y;

		while (top > -1) {
			x = stackX[top];
			y = stackY[top--];
			
			if (!visited[y][x]) {
				visited[y][x] = true;
				houseNum[totalComplexNum]++;
				
				for (int i = 0; i < 4; i++) {
					if (!isWall(x+dx[i], y+dy[i]) && map[y+dy[i]][x+dx[i]] == 1 && !visited[y+dy[i]][x+dx[i]]) {
						stackX[++top] = x+dx[i];
						stackY[top] = y+dy[i];
					}
				}
			}
		}
	}
	
	static boolean isWall(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N; 
	}
	
	static void sortHouseNum() {
		Arrays.sort(houseNum, 1, totalComplexNum + 1);
	}

	static void outputAnswer() {
		System.out.println(totalComplexNum);
		for (int i = 1; i <= totalComplexNum; i++) {
			System.out.println(houseNum[i]);
		}
	}
}

/* 문제 조건
 * 제한 : 1초, 128MB
 * 정사각형 모양 지도 : 1 - 집, 0 - 집X (입력이 값이 1, 0인 테이블 형태로 주어질 것)
 * 5 <= N <= 25
 * 단지 : 상하좌우로 연결된 집의 집합. 대각선X (4방 탐색)
 
 * 답 : 단지 수 & 단지에 속하는 집의 수를 오름차순으로 정렬
 */

/* 문제 설계
 * N*N = 5^4 <= 625 -> 충분히 전체 탐색 가능한 크기
 * Table이 주어지고, 상하좌우로 연결된 덩어리를 탐색하는 문제이므로.
    DFS/BFS로 풀 수 있는 문제라고 판단했다.
    탐색하면서, 단지 번호에 해당하는 집 개수도 함께 세아리자.
 
    1. 변수 입력 및 초기화
      (1) 총 단지 개수 int total = 0, int num[최대 단지 번호] 선언
	-> 최대 단지 번호는 N*N/2의 가우스식.(인데 편의상 625/2 + 1 = 313으로 둘까 싶기도)
      (2) N 입력 받고, table N*N 크기만큼 메모리 할당 후, 값 입력 받기
      (3) 방문했다는 의미의 boolean table visited N*N만큼 할당.
    2. DFS or BFS table로 탐색하기
      for i : 0 ~ N-1
	for j : 0 ~ N-1
	  현재 위치에 집이 없거나, 이미 방문했다면 continue;
	  있고, 미방문이라면 DFS, BFS 탐색 시작.
    3. DFS 탐색 시작 시,
	4방 탐색으로, (범위 밖 제외)
	미방문이고, 집이 있는 위치를 찾은 다음에
		현재 위치를 stack에 push 하고,
		미방문인 위치로 이동.
	만약 주변에 그런 곳이 없다면,
		stack을 pop하고, pop한 정점은 탐색 위치로 변경
		stack이 공백이 되면, dfs 종료.
    4. 단지를 모두 찾은 다음, 단지 개수만큼 단지내 집 개수 오름차순 정렬
    5. 출력 : 총 단지 개수\n오름차순된 단지 집 개수1\n\개수2\n ...
 */
