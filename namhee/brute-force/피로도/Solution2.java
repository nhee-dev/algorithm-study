// 재귀 함수 + dungeons 배열 값을 변경해 visited를 대신한 코드
// worst : 2.76ms, 77.3MB
class Solution {    
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        perm(0, k, dungeons);
        
        return answer;
    }

    void perm(int depth, int k, int[][] dg) {
        for (int i = 0; i < dg.length; i++) {
            int limit = dg[i][0];
            if (k >= limit) {
                dg[i][0] = 9999;
                perm(depth + 1, k - dg[i][1], dg);                
                dg[i][0] = limit;
            }
        }
        
        answer = Math.max(answer, depth);
    }
}
