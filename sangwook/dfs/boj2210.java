package com.example.lib.java.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj2210 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr = new char[5][5];
    static HashSet<String> answer = new HashSet<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 1, String.valueOf(arr[i][j]));
            }
        }

        System.out.println(answer.size());
    }

    private static void dfs(int x, int y, int cnt, String str) {

        if (cnt == 6) {
            answer.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(nx, ny, cnt + 1, str + arr[nx][ny]);
            }

        }

    }

}
