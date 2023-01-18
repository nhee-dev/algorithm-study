import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 21_BOJ_18428_감시피하기_G5 {
    static int N;
    static ArrayList<Pair> teachers;
    static int dy[] = { 1, -1, 0, 0 };
    static int dx[] = { 0, 0, 1, -1 };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        teachers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);

                if (map[i][j] == 'T') {
                    teachers.add(new Pair(i, j));
                }
            }
        }
        boolean result = dfs(0, 0, map);
        System.out.println(result ? "YES" : "NO");

    }

    private static boolean dfs(int n, int cnt, char[][] map) {
        if (n == N * N)
            return false;
        if (cnt == 3 && isPossible(map)) {
            return true;
        }

        if (cnt == 3) {
            return false;
        }
        int y = n / N;
        int x = n % N;

        if (map[y][x] == 'X') {
            map[y][x] = 'O';
            if (dfs(n + 1, cnt + 1, map)) {
                return true;
            }
            map[y][x] = 'X';
            if (dfs(n + 1, cnt, map)) {
                return true;
            }
        } else {
            if (dfs(n + 1, cnt, map))
                return true;
        }

        return false;
    }


    private static boolean isPossible(char[][] map) {
        for (Pair t : teachers) {
            if (check(map, t)) {
                return false;
            }
        }
        return true;
    }

    private static boolean check(char[][] map, Pair t) {
        for (int d = 0; d < 4; d++) {
            int ny = t.y;
            int nx = t.x;
            while (true) {
                ny = ny + dy[d];
                nx = nx + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                    break;
                if (map[ny][nx] == 'O' || map[ny][nx] == 'T')
                    break;
                if (map[ny][nx] == 'S')
                    return true;
            }
        }
        return false;
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }
    }
}