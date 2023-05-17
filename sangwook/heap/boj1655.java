package src.main.kotlin.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int a = Integer.parseInt(br.readLine());

            if (maxHeap.size() == minHeap.size()) {
                maxHeap.offer(a);
            } else {
                minHeap.offer(a);
            }

            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int tmp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(tmp);

                }
            }
            sb.append(maxHeap.peek()).append(' ');

        }

        System.out.println(sb);

    }
}
