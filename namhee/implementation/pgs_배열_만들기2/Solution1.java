import java.util.ArrayList;
import java.util.Arrays;

class Solution {    
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    public int[] solution(int l, int r) {        
    
        int num = 5;
        perm(l, r, num);
        
        int[] answer = {-1};
        if (list.size() > 0) {
            answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i).intValue();
            }            
        }
        
        Arrays.sort(answer);
        return answer;
    }
    
    void perm(int l, int r, int num) {
        if (l <= num && num <= r) {
            list.add(num);
        }
        
        if (num > r) {
            return;
        }
        
        num *= 10;
        perm(l, r, num);
        perm(l, r, num + 5);
    }
}
