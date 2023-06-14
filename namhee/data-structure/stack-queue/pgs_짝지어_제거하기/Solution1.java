// 효율성 테스트 평균 14ms, 57.7MB
// Stack을 사용 (stack 구현을 배열로 해 봄.)
class Solution {
    public int solution(String s) {
        int len = s.length();
        
        char ch;
        int top = -1;
        char[] stack = new char[len];
        for (int i = 0; i < len; i++) {
            ch = s.charAt(i);
            if (top >= 0 && stack[top] == ch) {
                top--; // pop
            }
            else {
                stack[++top] = ch; // push
            }
        }
        
        return top == -1 ? 1 : 0;
    }
}
