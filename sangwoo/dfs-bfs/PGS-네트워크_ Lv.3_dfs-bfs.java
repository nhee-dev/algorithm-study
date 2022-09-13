import java.util.*;

class Solution {
    static boolean[] visited;
    static int networkCount = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        
        for(int i = 0; i < computers.length; i++) {
            if(!visited[i]) {
                dfs(computers, i);
                networkCount++;
            }
        }        
        
        return networkCount;
    }
    
    static void dfs(int[][] computers, int cur) {
        visited[cur] = true;
        
        for(int i = 0; i < computers[cur].length; i++) {
            if(!visited[i] && computers[cur][i] == 1) {
                dfs(computers, i);
            }
        }
    }
}