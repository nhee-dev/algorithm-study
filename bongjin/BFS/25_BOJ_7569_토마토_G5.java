import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 25_BOJ_7569_토마토_G5 {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, 0, -1, 0};
    static int[] dz = {0, 0, 0, 1, 0, -1};
    
    public static class Node {
        int x;
        int y;
        int z;
    
        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[H][N][M];
        Queue<Node> q = new LinkedList<>();
        boolean[][][] v = new boolean[H][N][M];

        int cnt = H * N * M;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        q.add(new Node(i, j, k));
                        v[i][j][k] = true;
                        cnt--;
                    } else if (arr[i][j][k] == -1) {
                        cnt--;
                    }
                }
            }
        }

        int result = 0;

        while (!q.isEmpty()) {
            if (cnt == 0) {
                System.out.println(result);
                return;
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                for (int k = 0; k < 6; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];
                    int nz = cur.z + dz[k];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= H || ny >= N || nz >= M) continue;
                    if (v[nx][ny][nz] || arr[nx][ny][nz] == -1) continue;

                    q.add(new Node(nx, ny, nz));
                    v[nx][ny][nz] = true;
                    cnt--;
                }
            }

            result++;
        }

        System.out.println(-1);
    }


}