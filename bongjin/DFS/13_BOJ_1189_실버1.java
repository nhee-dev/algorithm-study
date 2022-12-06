import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 13_BOJ_1189_실버1 {

    static int R, C, K;
    static char[][] map;
    static int[][] v;
    static int result;

    static int[] arrR = {1, -1, 0, 0};
    static int[] arrC = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        R = Integer.parseInt(s.split(" ")[0]);
        C = Integer.parseInt(s.split(" ")[1]);
        K = Integer.parseInt(s.split(" ")[2]);
        map = new char[R][C];
        v = new int[R][C];

        for(int i=0; i<R; i++) {
            String a = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = a.charAt(j);
            }
        }

        v[R-1][0] = 1;
        dfs(R-1, 0, 1);

        System.out.println(result);

    }

    static void dfs(int r, int c, int m) {
        if(r == 0 && c == C - 1) {
            if(m == K)
                result++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nR = r + arrR[i];
            int nC = c + arrC[i];
            if(nR < 0 || nR >= R || nC < 0 ||nC >= C)
                continue;
            if(v[nR][nC] == 1 || map[nR][nC] == 'T')
                continue;
            v[nR][nC] = 1;
            dfs(nR, nC, m + 1);
            v[nR][nC] = 0;

        }

    }

}