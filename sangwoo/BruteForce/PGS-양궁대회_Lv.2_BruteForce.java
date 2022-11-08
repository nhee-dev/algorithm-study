import java.util.*;

class Solution {
    int[] output, lion, apeach, answer;
    int max = Integer.MIN_VALUE;
    int totalCount = 0, loseCount = 0;

    public int[] solution(int n, int[] info) {
        output = new int[n];
        lion = new int[11];
        answer = new int[11];
        apeach = info;
        combi(0, 0, 11, n);
        
        if(totalCount == loseCount) {
            return new int[]{-1};
        }
        System.out.println("최종값: " + Arrays.toString(answer));
        return answer;
    }
    
    public void combi(int start, int depth, int n, int r) {
        if(depth == r) {
            initLionScore();
            setLionScore();
            compareScore();
            return;
        }
        
        for(int i = start; i < n; i++) {
            output[depth] = i;
            combi(i, depth + 1, n, r);            
        }
    }
    
    public void initLionScore() {
        for(int i = 0; i < lion.length; i++) {
            lion[i] = 0;
        }
    }
    
    public void setLionScore() {
        for(int i = 0; i < output.length; i++) {
            lion[10 - output[i]]++;
        }
    }
    
    public void copyArr() {
        for(int i = 0; i < lion.length; i++) {
            answer[i] = lion[i];
        }
    }
    
    public void compareScore() {
        int lionScore = 0, apeachScore = 0;
        for(int i = 0; i < 11; i++) {
            if(lion[i] == 0 && apeach[i] == 0) {
                continue;
            }
            if(lion[i] > apeach[i]) {
                lionScore += (10 - i);
            } else {
                apeachScore += (10 - i);
            }
        }
        
        int scoreDiff = lionScore - apeachScore;
        
        totalCount++;
        if(scoreDiff <= 0) {
            loseCount++;
            return;
        }
        
        // 점수 차이가 최대인 경우
        if(scoreDiff > max) {
            max = scoreDiff;
            copyArr();
            return;
        }
        
        // 점수 차이가 최대와 같은 경우
        if(scoreDiff == max) {
            // 낮은 점수부터 비교
            for(int i = 10; i >= 0; i--) {
                // 이미 있는 결과가 더 낮은 점수를 많이 맞힌 경우 갱신 X
                if(answer[i] > lion[i]) {
                    return;
                }
                // 새로운 결과가 더 낮은 점수를 많이 맞힌 경우 갱신
                if(answer[i] < lion[i]) {
                    copyArr();
                    return;
                }
            }
        }      
    }
}