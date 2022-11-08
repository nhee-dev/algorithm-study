import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int[] dp = new int[100001];
        
        if(sticker.length == 1) {
            return sticker[0];
        } 
        
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for(int i = 2; i < sticker.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i-1]);
        }
        int answer = dp[sticker.length - 2];
        
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i = 2; i < sticker.length; i++) {
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
               
        return Math.max(dp[sticker.length - 1], answer);
    }
}