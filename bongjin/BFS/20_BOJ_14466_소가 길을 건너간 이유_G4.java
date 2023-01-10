import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 20_BOJ_14466_소가 길을 건너간 이유_G4 {

    private static int N;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N +1];

        ArrayList<Node>[][] con = new ArrayList[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                con[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            con[r1][c1].add(new Node(r2, c2));
            con[r2][c2].add(new Node(r1, c1));
        }

        List<Node> cows = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cows.add(new Node(x, y));
            map[x][y] = 1;
        }

        int result = 0;

        for (int t = 0; t < K; t++) {
            Node cow = cows.get(t);
            int count = 0;
            Queue<Node> q = new LinkedList<>();
            boolean[][] v = new boolean[N + 1][N + 1];
            boolean[][] meet = new boolean[K][K];

            q.offer(cow);
            v[cow.x][cow.y] = true;

            while (!q.isEmpty()) {
                Node node = q.poll();

                if (map[node.x][node.y] == 1) {
                    for (int j = t + 1; j < K; j++) {
                        Node nextCow = cows.get(j);

                        if (nextCow.x == node.x && nextCow.y == node.y) {
                            meet[t][j] = true;
                            break;
                        }
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    if (!check(nx, ny) || v[nx][ny]) {
                        continue;
                    }

                    if (con[node.x][node.y].contains(new Node(nx, ny))) {
                        continue;
                    }

                    v[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }

            for (int i = t + 1; i < K; i++) {
                if (!meet[t][i]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean check(int x, int y) {
        return x > 0 && y > 0 && x <= N && y <= N;
    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            return this.x == node.x && this.y == node.y;
        }
    }
}