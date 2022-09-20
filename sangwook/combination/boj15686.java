package com.example.lib.java.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15686 {

    static int N;
    static int M;
    static int ans = Integer.MAX_VALUE;

    static int[][] map;
    static boolean[] visit;

    static ArrayList<int[]> chicken;
    static ArrayList<int[]> home;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        chicken = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        visit = new boolean[chicken.size()];

        comb(0, chicken.size(), M);

        System.out.println(ans);

    }

    private static void comb(int start, int n, int r) {

        ArrayList<int[]> tmpList = new ArrayList<>();
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();

        if (r == 0) {
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    tmpList.add(chicken.get(i));
                }
            }
            list.add(tmpList);

            for (int i = 0; i < list.size(); i++) {
                ans = Math.min(getDistance(list.get(i)),ans);
            }
        }

        for(int i = start; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                comb(i+1,n,r-1);
                visit[i] = false;

            }
        }

    }

    private static int getDistance(ArrayList<int[]> chickenList) {

        int res = 0;

        for(int i = 0; i < home.size(); i++){
            int tmp = Integer.MAX_VALUE;
            int x = 0;
            int y = 0;

            for(int j = 0; j < chickenList.size();j++){
                x = Math.abs(chickenList.get(j)[0] - home.get(i)[0]);
                y = Math.abs(chickenList.get(j)[1] - home.get(i)[1]);

                tmp = Math.min(tmp,x+y);
            }
            res += tmp;
        }

        return res;
    }

}
