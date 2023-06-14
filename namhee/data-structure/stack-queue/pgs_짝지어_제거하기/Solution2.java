// 효율성 테스트 평균 52ms, 59MB
// Stack 사용 (util.Stack 사용)
import java.util.Stack;

class Solution {
    
    public int solution(String s) {

        int len = s.length();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            
            if (stack.size() > 0 && stack.peek() == ch) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        
        return stack.size() > 0 ? 0 : 1;
    }
}
