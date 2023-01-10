package src.main.kotlin.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj1005 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] time = new int[N + 1];
            int[] inDegree = new int[N + 1];
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            ArrayList<ArrayList<Integer>> fromList = new ArrayList<>();
            boolean[] visit = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                list.add(new ArrayList<>());
                fromList.add(new ArrayList<>());
            }

            list.add(new ArrayList<>());
            fromList.add(new ArrayList<>());

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                fromList.get(e).add(s);
                list.get(s).add(e);
                inDegree[e]++;
            }

            int W = Integer.parseInt(br.readLine());

            bfs(time, inDegree, fromList, list, visit);

            System.out.println(time[W]);

        }

    }

    private static void bfs(int[] time, int[] inDegree, ArrayList<ArrayList<Integer>> fromList, ArrayList<ArrayList<Integer>> list, boolean[] visit) {

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> time[o1] - time[o2]);

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {

            int cur = q.poll();

            visit[cur] = true;

            for (int next : list.get(cur)) {
                boolean flag = true;
                for (int pre : fromList.get(next)) {
                    if (!visit[pre]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    time[next] += time[cur];
                }

                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }

        }

    }
}
