import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> map = new HashMap(8);
        
        for(int i = 0; i < choices.length; i++) {
            if(choices[i] < 4) {
                String key = survey[i].substring(0, 1); 
                map.put(key, map.getOrDefault(key, 0) + -(choices[i] - 4));
            } else if(choices[i] > 4) {
                String key = survey[i].substring(1); 
                map.put(key, map.getOrDefault(key, 0) + choices[i] - 4);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(map.getOrDefault("R", 0) >= map.getOrDefault("T", 0) ? "R" : "T");
        sb.append(map.getOrDefault("C", 0) >= map.getOrDefault("F", 0) ? "C" : "F");
        sb.append(map.getOrDefault("J", 0) >= map.getOrDefault("M", 0) ? "J" : "M");
        sb.append(map.getOrDefault("A", 0) >= map.getOrDefault("N", 0) ? "A" : "N");
        return sb.toString();
    }
}