/*  문제 설계
    1. food[1]부터 짝수개 양만 더한다.
    2. 1...2...2...1
     (1) food에서 대결에 쓸 수 있는 음식의 수를 구하자. (worst : 9)
     (2) 구한 음식 수로 char[] 배열 초기화
     (3) 구한 음식 수 / 2 만큼 char[] 배열 값 할당 (9 * 1000 / 2)
     (4) char[] to String
        (String의 최대 길이는?)
 */

class Solution {
    public String solution(int[] food) {
        int num = 0;
        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 == 1) {
                food[i]--;
            }
            num += food[i];
        }
        
        int[] answer = new int[num + 1];
        
        int idx = 0;
        for (int i = 1; i < food.length; i++) {
            while (true) {
                if (food[i] == 0) break;
                
                answer[idx] = i;
                answer[num - idx] = i;
                
                food[i] -= 2;
                idx++;                
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < num + 1; i++) {
            sb.append(answer[i]);
        }
        
        return sb.toString();
    }
}
