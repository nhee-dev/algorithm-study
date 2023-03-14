import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[][] link;

    static int[] depth;
    static int count;
    
    public static void main(String args[]) throws IOException {
        input();
        solve();
        output();
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        link = new boolean[n + 1][n + 1];
        int a, b;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            link[a][b] = true;
            link[b][a] = true;
        }
    }
    
    static void solve() {
        initData();
        bfs(1);
    }
    
    static void initData() {
        depth = new int[n + 1];
    }

    static void bfs(int start) {
        int[] queue = new int[n];
        int front = -1, rear = -1;
        
        queue[++rear] = start;
        depth[start] = 1;

        int v;
        while (front < rear) {
            v = queue[++front];

            for (int w = 1; w <= n; w++) {
                if (link[v][w] && depth[w] == 0) {
                    queue[++rear] = w;
                    depth[w] = depth[v] + 1;
                    
                    if (depth[w] <= 3) {
                        count++;
                    }
                }
            }
        }
    }
    
    static void output() {
        System.out.println(count);
    }
}

