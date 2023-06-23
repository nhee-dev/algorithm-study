// 재귀 함수 + visited 배열을 사용했던 첫 제출 코드
// worst : 3.14ms, 74.1MB (일반적인 경우 큰 차이는 없기에 worst 비교)
class Solution {    
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        perm(0, k, dungeons, visited);
                
        return answer;
    }

    void perm(int depth, int k, int[][] dg, boolean[] visited) {
        for (int i = 0; i < dg.length; i++) {
            if (!visited[i] && k >= dg[i][0]) {
                k -= dg[i][1];
                visited[i] = true;

                perm(depth + 1, k, dg, visited);
                
                visited[i] = false;
                k += dg[i][1];
            }
        }
        
        answer = Math.max(answer, depth);
    }
}
