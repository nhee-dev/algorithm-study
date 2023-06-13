package com.example.lib.kotlin.kakao.dijkstra;

import java.util.*;

public class pg87694 {
    int[][] map;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[101][101];

        for (int[] arr : rectangle) {
            int x1 = arr[0];
            int y1 = arr[1];
            int x2 = arr[2];
            int y2 = arr[3];

            checkOutLine(x1 * 2, y1 * 2, x2 * 2, y2 * 2);
        }

        for (int[] arr : rectangle) {
            int x1 = arr[0];
            int y1 = arr[1];
            int x2 = arr[2];
            int y2 = arr[3];

            fillIn(x1 * 2, y1 * 2, x2 * 2, y2 * 2);
        }


        boolean[][] visit = new boolean[101][101];
        answer = bfs(characterX*2,characterY*2,itemX*2,itemY*2,visit);

        return answer;
    }

    public int bfs(int sx, int sy, int tx, int ty, boolean[][] visit) {

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[2] - o2[2]);

        pq.offer(new int[]{sx,sy,0});
        visit[sx][sy] = true;

        while(!pq.isEmpty()){

            int[] cur = pq.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if(cx == tx && cy == ty){
                return dist / 2;
            }

            for(int i = 0; i < 4; i++){

                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(!(nx >= 0 && nx < 101 && ny >= 0 && ny < 101)) continue;
                if(visit[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;

                visit[nx][ny] = true;
                pq.offer(new int[]{nx,ny,dist+1});

            }

        }
        return 0;

    }

    public void checkOutLine(int x1, int y1, int x2, int y2){

        for(int i = x1; i <= x2; i++){
            map[i][y1] = 1;
            map[i][y2] = 1;
        }

        for(int i = y1; i <= y2; i++){
            map[x1][i] = 1;
            map[x2][i] = 1;
        }
    }

    public void fillIn(int x1, int y1, int x2, int y2){

        for(int i = x1+1; i < x2; i++){
            for(int j = y1+1; j < y2; j++){
                map[i][j] = 0;
            }

        }


    }
}
