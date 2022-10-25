import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue();
 
        for(int i = 0; i < scoville.length; i++) {
            heap.offer(scoville[i]);
        }
        
        int answer = 0;
        while(true) {
            int temp = heap.peek();
            if(temp >= K) {
                break;
            }
            if(heap.size() < 2) {
                answer = -1;
                break;
            }
            answer++;
            
            int n1 = heap.poll();
            int n2 = heap.poll();
            heap.offer(n1 + 2*n2);
        }
        
        return answer;
    }
}