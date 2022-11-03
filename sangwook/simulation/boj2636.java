package com.example.lib.java.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2636 {

    static int n, m, prev, time, cnt;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }

        prev = cnt;
        while (cnt != 0){
            time++;
            melt(0,0);
            if(cnt != 0){
                prev = cnt;
            }
        }

        System.out.println(time);
        System.out.println(prev);
    }


    private static void melt(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        while (!q.isEmpty()) {
            int[] position = q.poll();
            int cx = position[0];
            int cy = position[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visit[nx][ny]){
                        if (map[nx][ny] == 1) {
                            map[nx][ny] = 0;
                            visit[nx][ny] = true;
                            cnt--;

                        }else{
                            visit[nx][ny] = true;
                            q.offer(new int[]{nx,ny});
                        }
                    }

                }
            }
        }

    }
}
