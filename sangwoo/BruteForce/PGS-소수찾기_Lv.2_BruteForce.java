import java.util.*;

class Solution {
    int[] arr, output;
    boolean[] visited;
    Set<Integer> set;
    int answer = 0;
    
    public int solution(String numbers) {
        int n = numbers.length();
        arr = new int[n];
        output = new int[n];
        set = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }  
        
        for(int i = 1; i <= n; i++) {
            visited = new boolean[n];
            output = new int[i];
            perm(0, n, i);
        }        
        
        sosu();
        return answer;
    }
    
    public void sosu() {
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            int n = (int)iter.next();
            if(isSosu(n)) {
                answer++;
            }
        }
    }
    
    public boolean isSosu(int n) {
        if(n == 0 || n == 1) {
            return false;
        }
        if(n == 2) {
            return true;
        }        
        if(n % 2 == 0) {
            return false;
        }
        
        int root = (int)Math.sqrt(n);
        for(int i = 3; i <= root; i+=2) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;        
    }
    
    
    public void perm(int depth, int n, int r) {
        if(depth == r) {
            if(output[0] == 0) {
                return;
            }
            if(output.length == 1 && output[0] == 1) {
                return;
            }
            
            String temp = "";
            for(int i = 0; i < output.length; i++) {
                temp += output[i];
            }
            
            // 소수 판별
            set.add(Integer.parseInt(temp));
            // sosu(Integer.parseInt(temp));            
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(depth + 1, n, r);                
                visited[i] = false;
            }
        }
    }
}