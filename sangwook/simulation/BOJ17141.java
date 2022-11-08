package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17141 {

    static int n,m;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visit;
    static ArrayList<Point> emptyList = new ArrayList<>();
    static Point[] virusArr;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean flag = false;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        virusArr = new Point[m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    emptyList.add(new Point(i,j));
                }
            }
        }

        comb(0,0);
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(min);
        }



    }
    private static void comb(int cur, int start) {

        if(cur == m) {
            copyMap();
            spreadVirus();
            check();

            return;
        }

        for(int i = start; i < emptyList.size(); i++) {
            virusArr[cur] = emptyList.get(i);
            comb(cur+1,i+1);
        }

    }

    private static void check() {


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(copyMap[i][j] != 1 && !visit[i][j] ) {
                    return;

                }
            }
        }

        int max = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(copyMap[i][j] > max) {
                    max = copyMap[i][j];
                }
            }
        }

        if(min > max) {
            min = max;
        }



    }
    private static void copyMap() {
        copyMap = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 2) {
                    copyMap[i][j] = 0;
                }else {
                    copyMap[i][j]= map[i][j];
                }

            }
        }


        for (Point point : virusArr) {
            copyMap[point.x][point.y] = 2;
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(copyMap[i][j] == 1){
                    cnt++;
                }
            }
        }

        if(cnt == n*n-m){
            min = 0;
        }

        for (Point point : virusArr) {
            copyMap[point.x][point.y] = 0;
        }


    }


    private static void spreadVirus() {

        Queue<Point> q = new LinkedList<>();
        visit = new boolean[n][n];
        for(int i  = 0; i < virusArr.length; i++) {

            visit[virusArr[i].x][virusArr[i].y] = true;
            q.offer(virusArr[i]);

        }

        while(!q.isEmpty()) {

            Point p = q.poll();
            int x = p.x;
            int y = p.y;



            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(map[nx][ny] != 1 && !visit[nx][ny]) {
                        copyMap[nx][ny] = copyMap[x][y] + 1;
                        visit[nx][ny] = true;
                        q.offer(new Point(nx,ny));
                    }
                }
            }


        }



    }
}

class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}