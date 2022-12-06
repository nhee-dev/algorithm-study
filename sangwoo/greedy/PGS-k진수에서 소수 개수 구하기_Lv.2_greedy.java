import java.util.*;

class Solution {       
    public int solution(int n, int k) {
        List<Integer> list = new ArrayList<>();
        
        convert(n, k, list);
        
        return findPrime(list);
    }
    
    // K진수에서 소수 찾기
    public int findPrime(List<Integer> list) {        
        int size = list.size(), sum = 0;
        boolean isFirst = true;
        StringBuilder sb = null;

        for(int i = 0; i < size; i++) {     
            // 0이 아닐때
            if(list.get(i) != 0) {
                // 처음 0이 아닐때
                if(isFirst) {
                    sb = new StringBuilder();      
                    isFirst = false;
                }
                sb.append(list.get(i));
            } 
            // 0 일때
            else {
                if(sb != null && sb.length() > 0) {
                    // 판별
                    if(isPrime(Integer.parseInt(sb.toString()))) {
                        sum++;
                    }
                    sb = null;
                    isFirst = true;
                }
            }
        }
        
        
        // 0P, P 조건
        if(sb != null && sb.length() > 0) {
            // 소수 판별
            if(isPrime(Long.parseLong(sb.toString()))) {
                sum++;
            }
        }
        
        return sum;
    }
    
    // 소수 판별
    public boolean isPrime(long n) {
        if(n == 0 || n == 1) {
            return false;
        } 
        if(n == 2) {
            return true;
        }
        if(n % 2 == 0) {
            return false;
        }
        int sqrt = (int)Math.sqrt(n);
        for(int i = 3; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;        
    }
    
    // K 진수 만들기
    public void convert(int n, int k, List<Integer> list) {
        while(n > 0) {
            list.add(n % k);
            n /= k;            
        }
        Collections.reverse(list);
    }
}