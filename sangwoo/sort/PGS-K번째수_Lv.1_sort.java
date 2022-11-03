import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i =0; i < commands.length; i++) {
            answer[i] = sortCommand(array, commands[i]);
        }
        
        return answer;
    }   
    
    public int sortCommand(int[] array, int[] command) {
        int[] arr = new int[command[1] - command[0] + 1];
        for(int i = command[0] -1, j = 0; i <= command[1]- 1; i++, j++) {
            arr[j] = array[i];
        }
        Arrays.sort(arr);
        return arr[command[2]-1];
    }
    
}