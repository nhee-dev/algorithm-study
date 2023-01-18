package src.main.kotlin.simulation;

import java.util.*;
import java.io.*;


public class st_1309 {
    static int N;

    static Person[] finalResult;
    static StringBuilder sb;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Person[] contest = new Person[N];
        finalResult = new Person[N];
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            finalResult[i] = new Person(i, 0);
        }

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int score = Integer.parseInt(st.nextToken());
                contest[j] = new Person(j, score);
                finalResult[j].score += score;
            }

            getRank(contest);

        }
        getRank(finalResult);

        System.out.println(sb.toString());
    }


    static void getRank(Person[] contest) {

        Arrays.sort(contest, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.score - o1.score;
            }
        });

        int[] ranks = new int[N];
        int rank = 1;
        int sideRank = 1;
        int pre = contest[0].score;
        ranks[contest[0].idx] = rank;

        for (int i = 1; i < contest.length; i++) {
            if (contest[i].score == pre) {
                ranks[contest[i].idx] = rank;
                sideRank++;
                continue;
            }
            sideRank++;
            ranks[contest[i].idx] = sideRank;
            rank = sideRank;
            pre = contest[i].score;
        }

        for (int i = 0; i < N; i++) {
            sb.append(ranks[i]).append(' ');
        }
        sb.append('\n');

    }

    static class Person {
        int idx;
        int score;

        Person(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

    }
}