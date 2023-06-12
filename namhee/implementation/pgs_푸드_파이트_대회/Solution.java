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
