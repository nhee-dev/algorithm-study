import java.util.Scanner;

public class Main {
    static int N, M, start, end;
    static int[][] link;
    static int degree = -1;
    
    public static void main(String args[]) {
        initData();
        bfs();
        System.out.print(degree);
    }
    
    static void initData() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        link = new int[N+1][N+1];
        start = sc.nextInt();
        end = sc.nextInt();
        
        M = sc.nextInt();
        int x, y;
        for (int i = 0; i < M; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            link[x][y] = 1;
            link[y][x] = 1;
        }
    }
    
    static void bfs() {
        int[] queue = new int[M];
        int front = -1;
        int rear = -1;
        
        int[] depth = new int[N+1];
        for (int i = 1; i <= N; i++) {
            depth[i] = -1;
        }
        
        queue[++rear] = start;
        depth[start] = 0;

        int v;
        while (front != rear) {
            v = queue[++front];
            
            for (int w = 1; w <= N; w++) {
                if (link[v][w] == 1 && depth[w] == -1) {
                    depth[w] = depth[v] + 1;
                    if (w == end) {
                        degree = depth[w];
                        return;
                    }
                    queue[++rear] = w;
                }
            }
        }        
    }
}

/* 문제 조건
    시간 : 1초, 메모리 : 128MB
    입력 :
	N (1~100, 전체 사람 수)
	v1 v2 (촌수 계산해야 하는 노드 번호 2개)
	M (관계 정보 개수, 최대 10000)
	x y (각각 부모 자식 번호, M개 줄로...)
 */

/* 문제 설계
촌수는 두 사람 사이의 최단 연결 거리, Link 개수를 찾는 것과 같다.
즉, BFS 탐색으로 깊이가 어느 정도 되는지(연결된 선을 몇번 지났는지)를 알면 답을 구할 수 있다.

이 문제에서는 연결 관계를 어떻게 저장할 것인가를 정해야 한다. 일단 방향이 있는 그래프는 아니기 때문에 주어진 노드끼리는 양방향으로 연결되어 있다.

N이 100개까지니까 쉬운 구현 방법인 연결 배열을 활용하는 방법을 사용하겠다.

1. initData
 (1) N 초기화
   - N을 이용해 N+1*N+1 연결 정보 int 배열 초기화 (int가 빨라서)
 (2) n1, n2 초기화
 (3) M 초기화 (지역으로 처리, 이후 사용 X)
 (4) M번 연결 정보 1로 초기화
 (5) degree를 -1로 초기화 (못 찾으면 그대로 -1임)

2. solution
  (1) v1에서부터 bfs 탐색
  (2) bfs(start) 구현
	- N+1을 이용해 depth 배열 초기화
	- start를 queue에 넣고 depth 1로 초기화
	- queue에서 꺼내서 queue가 소진될 때까지 탐색
		- 만약 v2를 찾았다면 degree에 depth 넣고 return
	- return degree
3. output, degree 출력
*/
