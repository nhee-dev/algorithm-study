package com.example.lib.java.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1743 {
    static int N, M, K;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visit;
    static int max = -1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = 1;

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    int size = bfs(i, j);

                    if (max < size) {
                        max = size;
                    }
                }

            }
        }

        System.out.println(max);

    }

    private static int bfs(int x, int y) {

        visit[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        int size = 1;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {

            int[] cp = q.poll();
            int cx = cp[0];
            int cy = cp[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visit[nx][ny] && map[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        size++;
                    }
                }

            }

        }
        return size;

    }

}
