package src.main.kotlin.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] stuff = new int[N+1][K+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for(int j = 1; j < K+1; j++){
                if(j < w){
                    stuff[i][j] = stuff[i-1][j];
                }else{
                    stuff[i][j] = Math.max(stuff[i-1][j], stuff[i-1][j-w] + v);
                }
            }

        }

        System.out.println(stuff[N][K]);

    }
}
