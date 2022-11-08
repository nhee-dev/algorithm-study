package simulation;

import java.util.*;

public class PG92342{

    int[] points = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] output;
    int N, r;
    int apeachPoint = 0;
    int max = -1;
    ArrayList<int[]> pointList = new ArrayList<>();

    public int[] solution(int n, int[] info) {
        int[] answer = {};

        for (int i = 0; i < info.length; i++) {
            apeachPoint += (10 - i) * info[i];
        }

        int cnt = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] == 1) {
                cnt++;
            } else {
                break;
            }
        }

        if (cnt == n) {
            return new int[]{-1};
        }

        N = 11;
        r = n;
        output = new int[n];

        combPoint(0, 0, info);

        return pointList.get(0);
    }

    void combPoint(int cur, int start, int[] info) {

        if (cur == r) {

            int[] lionArr = new int[N];

            for (int i = 0; i < output.length; i++) {
                lionArr[10 - output[i]] = lionArr[10 - output[i]] + 1;
            }

            getScore(lionArr, info);
            return;
        }

        for (int i = start; i < N; i++) {
            output[cur] = points[i];
            combPoint(cur + 1, i, info);
        }
    }

    void getScore(int[] lionArr, int[] info) {

        int apeach = 0;
        int lion = 0;

        for (int i = 0; i < N; i++) {
            if (lionArr[i] == 0 && info[i] == 0) {
                continue;
            }

            if (lionArr[i] > info[i]) {
                lion += (10 - i);
            } else if (lionArr[i] <= info[i]) {
                apeach += (10 - i);
            }
        }

        if (apeach >= lion) {
            return;
        }

        if (lion - apeach < max) {
            return;
        }

        if (max < lion - apeach) {
            pointList.clear();
            pointList.add(lionArr);
            max = lion - apeach;
        } else if (max == lion - apeach) {
            checkMin(lionArr);

        }


    }

    private void checkMin(int[] lionArr) {

        int[] first = pointList.get(0);

        System.out.println();
        for (int i = 10; i >= 0; i--) {
            if (first[i] > lionArr[i]) {
                return;
            }

            if (first[i] < lionArr[i]) {
                pointList.clear();
                pointList.add(lionArr);
                return;
            }


        }
    }
}