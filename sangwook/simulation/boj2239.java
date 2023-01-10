package src.main.kotlin.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj2239 {

    static int[][] map = new int[9][9];
    static ArrayList<int[]> list = new ArrayList<>();
    static boolean flag = false;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = line.charAt(j) - '0';
                if (map[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        getNumber(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void getNumber(int depth) {

        if (depth == list.size()) {
            flag = true;

            return;
        }

        boolean[] visit = new boolean[10];

        int x = list.get(depth)[0];
        int y = list.get(depth)[1];
        for (int i = 0; i < 9; i++) {
            if (!visit[map[x][i]]) {
                visit[map[x][i]] = true;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (!visit[map[i][y]]) {
                visit[map[i][y]] = true;
            }
        }

        int a = x / 3 * 3;
        int b = y / 3 * 3;

        for (int i = a; i < a + 3; i++) {
            for (int j = b; j < b + 3; j++) {
                if (!visit[map[i][j]]) {
                    visit[map[i][j]] = true;
                }
            }
        }


        for (int i = 1; i < 10; i++) {
            if (!visit[i]) {
                map[x][y] = i;
                getNumber(depth + 1);
                if(flag){
                    return;
                }
                map[x][y] = 0;
            }
        }
    }


}
