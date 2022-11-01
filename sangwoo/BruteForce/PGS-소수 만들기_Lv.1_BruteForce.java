import java.util.*;

class Solution {
    int count = 0;
    boolean[] visited, prime;
    public int solution(int[] nums) {
        prime = new boolean[3001];
        visited = new boolean[nums.length];
        prime[0] = true;
        prime[1] = true;
        for(int i = 2; i < 3001; i++) {
            if(!prime[i]) {
                for(int j = i + i; j < 3001; j += i) {
                    prime[j] = true;
                }
            }
        }    
        
        combi(0, 0, nums.length, 3, nums);
        
        return count;
    }
    
    public void combi(int start, int depth, int n, int r, int[] nums) {
        if(depth == r) {
            int sum = 0;
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    sum += nums[i];
                }
            }
            
            if(!prime[sum]) {
                count++;
            }
            
            return;
        }
        for(int i = start; i < n; i++) {
            visited[i] = true;
            combi(i + 1, depth + 1, n, r, nums);
            visited[i] = false;
        }
    }
}