import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] n1 = {1, 2, 3, 4, 5};
        int[] n2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] n3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == n1[i%5]) {
                count[0]++;
            }
            if(answers[i] == n2[i%8]) {
                count[1]++;
            }
            if(answers[i] == n3[i%10]) {
                count[2]++;
            }
        }
        
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            if(count[i] > max) {
                max = count[i];
                list.clear();
                list.add(i + 1);
            } else if(count[i] == max) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}