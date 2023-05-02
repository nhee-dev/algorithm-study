package src.main.kotlin.greedy;

import java.util.Stack;

public class pg131704 {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stk = new Stack<>();
        int cur = 1;
        for (int o : order) {

            if (o == cur) {
                answer++;
                cur++;
                continue;
            }

            if (!stk.isEmpty() && stk.peek() == o) {
                answer++;
                stk.pop();
                continue;
            }

            if (cur > o) {
                break;
            }

            do {
                stk.push(cur);
                cur++;

            } while (cur != o);

            answer++;
            cur++;

        }

        return answer;
    }
}
