import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int last, result = -1;
    static boolean[] v;
    static ArrayList<ArrayList<Integer>> graph;
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        v = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        last = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        dfs(first, 0);
        System.out.println(result);
    }

    private static void dfs(int point, int cnt) {
        v[point] = true;
        for (int x : graph.get(point)) {
            if (!v[x]) {
                if (x == last) {
                    result = cnt + 1;
                    return;
                }
                dfs(x, cnt + 1);
            }
        }
    }
}