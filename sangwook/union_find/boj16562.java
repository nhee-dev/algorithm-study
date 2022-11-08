package union_find;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj16562 {
    static int n, m, k;
    static int[] cost;
    static int[] parent;
    static boolean[] check;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        cost = new int[n + 1];
        parent = new int[n + 1];
        check = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            union(first, second);

        }
        int min=0;
        for(int i=1; i<=n; i++) {
            int now = cost[i];
            if(check[i]) continue;
            for(int j=1; j<=n; j++) {
                if(find(i)==find(j)) {
                    now = Math.min(now, cost[j]);
                    check[j] = true;
                }
            }
            min += now;
            check[i] = true;
        }
        System.out.println((min <= k)? min : "Oh no");

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);


    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
                if (a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }
}
