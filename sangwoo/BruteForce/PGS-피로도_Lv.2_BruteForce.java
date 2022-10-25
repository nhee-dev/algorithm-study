import java.util.*;

class Solution {
    boolean[] visited;
    int[] output;
    int max = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[n];
        output = new int[n];        

        perm(k,dungeons, 0, n, n);
        return max;
    }
    
    public void ad(int k, int[][] dungeons) {
        int count = 0;
        for(int i = 0; i < output.length; i++) {
            if(k < dungeons[output[i]][0]) {
                continue;
            }
            k -= dungeons[output[i]][1];            
            count++;
        }
        if(count > max) {
            max = count;
        }
    }
    
    public void perm(int k,int[][] dungeons, int depth, int n, int r) {
        if(depth == r) {
            ad(k, dungeons);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                perm(k, dungeons, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}