package src.main.kotlin.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2138 {

    static boolean[] targetArr;

    static int n;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String origin = br.readLine();
        String target = br.readLine();

        boolean[] arr = new boolean[n];
        boolean[] arr1 = new boolean[n];
        targetArr = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = origin.charAt(i) == '0';
            targetArr[i] = target.charAt(i) == '0';
        }

        arr1 = arr.clone();

        light(1, 0, arr);

        arr1[0] = !arr1[0];
        arr1[1] = !arr1[1];

        light(1, 1, arr1);

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);

    }

    private static void light(int idx, int cnt, boolean[] array) {

        if (idx == n) {
            if (array[idx - 1] != targetArr[idx - 1]) {
                return;
            }

            min = Math.min(min, cnt);
            return;
        }

        if (array[idx - 1] != targetArr[idx - 1]) {
            array[idx - 1] = !array[idx - 1];
            array[idx] = !array[idx];
            cnt++;
            if (idx != n - 1) {
                array[idx + 1] = !array[idx + 1];
            }
        }

        light(idx + 1, cnt, array);

    }


}
