package com.al.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ11651 { // 좌표정렬하기 2

    public static void main(String[] args) {
    	 
        Scanner sc = new Scanner(System.in);
 
        int pointNums = sc.nextInt();
        int[][] arr = new int[pointNums][2];
        for (int i = 0; i < pointNums; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
 
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                if(x[1]==y[1]){
                    return Integer.compare(x[0], y[0]);
                }
                return Integer.compare(x[1], y[1]);
            }
        });
 
        for (int i = 0; i < pointNums; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }

}
