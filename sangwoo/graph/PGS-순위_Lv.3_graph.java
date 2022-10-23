import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] map = new int[n+1][n+1];
        for(int i = 0; i < results.length; i++) {
            map[results[i][0]][results[i][1]] = 1; // 이김
            map[results[i][1]][results[i][0]] = 2; // 짐
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(map[i][k] == 0) {
                        continue;
                    }              
                    if(map[i][k] == map[k][j]) {
                        map[i][j] = map[i][k];
                    }      
                }
            }
        }
        
        int result = 0;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = 1; j <= n; j++) {
                if(map[i][j] != 0) {
                    sum++;
                }
            }
            if(sum == n - 1) {
                result++;
            }
        }
        
        return result;
    }
}