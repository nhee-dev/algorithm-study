package com.example.lib.java.heap;

import java.util.*;

class PG42626 {
    public int solution(int[] scoville, int K) {

        int ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue();

        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while (true) {

            if (pq.size() == 1) {
                if (pq.peek() >= K) {
                    break;
                } else {
                    ans = -1;
                    break;
                }
            }

            if (pq.peek() >= K) break;

            int x = (int) pq.poll();
            int y = (int) pq.poll();

            int z = 2 * y + x;
            pq.offer(z);
            ans++;

        }


        return ans;
    }
}