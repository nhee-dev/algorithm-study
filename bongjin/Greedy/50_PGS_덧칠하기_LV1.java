class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int next = section[0];
        int idx = 0;

        while( idx < section.length ) {
            if (next <= section[idx]) {
                next = section[idx] + m;
                answer++;
            }
            idx++;
        }

        return answer;
    }
}