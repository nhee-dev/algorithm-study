import java.util.ArrayList;
import java.util.Arrays;

class Solution {    

    public int[] solution(int l, int r) {        
    
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i = 1; i < 64; i++) {
            int num = Integer.parseInt(Integer.toString(i, 2)) * 5;
            if (l <= num && num <= r) {
                list.add(num);
            }
        }
        
        int[] answer = {-1};
        if (list.size() > 0) {
            answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i).intValue();
            }            
        }
        return answer;
    }
}
