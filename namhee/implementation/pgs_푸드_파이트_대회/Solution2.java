/* 풀이 방법 : 
    1. StringBuilder에 i를 food[i] / 2만큼 추가하기
    2. 0 추가 후, 반대로 food[i] / 2만큼 추가하기

  시간 복잡도 : 4500 + 4500 = 9000
*/
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }
        
        sb.append("0");
        
        // 아래는 sb.reverse()로 대체 가능
        for (int i = food.length - 1; i >= 1; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }
                
        return sb.toString();
    }
}
