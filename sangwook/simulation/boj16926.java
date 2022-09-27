package com.example.lib.java.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16926 {
    static int N,M,R;
    static int cnt;
    static int[][] matrix;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = Math.min(N,M) / 2;

        roll();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void roll() {

        for(int i = 0; i < R; i++){
            for(int j = 0; j < cnt; j++){
                int tmp = matrix[j][j];

                //위
                for(int k = j; k < M-1-j; k++){
                    matrix[j][k] = matrix[j][k+1];
                }

                //오른쪽
                for(int k = j; k < N-1-j; k++){
                    matrix[k][M-1-j] = matrix[k+1][M-1-j];
                }

                //아래
                for(int k = M-1-j; k > j; k--){
                    matrix[N-1-j][k] = matrix[N-1-j][k-1];
                }

                //왼쪽
                for(int k = N-1-j; k > j+1; k--){
                    matrix[k][j] = matrix[k-1][j];
                }

                matrix[j+1][j] = tmp;

            }
        }

    }
}
