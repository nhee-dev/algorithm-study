import java.util.*;

class Solution {
    StringBuilder sb;
    
    public String solution(String new_id) {
        // step 1
        sb = new StringBuilder(new_id.toLowerCase());
        System.out.println(sb.toString());

        // step 2
        removeChar();
        System.out.println(sb.toString());
        
        // step 3
        removeDot();
        System.out.println(sb.toString());
        
        // step 4
        removeFirstEndDot();
        System.out.println(sb.toString());
        
        // step 5
        checkEmptyStr();
        System.out.println(sb.toString());
        
        // step 6
        checkLength();
        System.out.println(sb.toString());
        
        // step 7
        checkMinLength();
        System.out.println(sb.toString());
        
        return sb.toString();
    }
    
    public void removeChar() {
        for(int i = sb.length() - 1; i >= 0; i--) {
            if(!((sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') || 
              (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') || 
              (sb.charAt(i) == '-') ||
              (sb.charAt(i) == '_') ||
              (sb.charAt(i) == '.'))) {
                sb.deleteCharAt(i);
            }
        }
    }
    
    public void removeDot() {
        boolean isFirst = false;
        int count = 0;
        for(int i = sb.length() - 1; i >= 0; i--) {
            if(sb.charAt(i) == '.') {
                if(!isFirst) {
                    isFirst = true;
                    count++;
                } else {
                    if(count > 0) {
                        sb.deleteCharAt(i);
                    }
                }
            } else {
                if(isFirst) {
                    isFirst = false;
                    count = 0;
                }
            }
        }
    }
    
    public void removeFirstEndDot() {
        if(sb.length() == 0) {
            return;
        }
        
        if(sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        
        if(sb.length() == 0) {
            return;
        }
        
        if(sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public void checkEmptyStr() {
        if(sb.length() == 0) {
            sb.append('a');
        }
    }
    
    public void checkLength() {
        if(sb.length() < 16) {
            return;
        }
        
        for(int i = sb.length() - 1; i >= 15; i--) {
            sb.deleteCharAt(i);
        }
        
        if(sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public void checkMinLength() {
        if(sb.length() > 2) {
            return;
        }
        
        char last = sb.charAt(sb.length() - 1);
        while(sb.length() < 3) {
            sb.append(last);
        }
    }
}