import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        answer = players;

        Map<String, Integer> map = new HashMap<String, Integer>();

        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }

        for(int i = 0; i < callings.length; i++){
            int idx = map.get(callings[i]);

            map.replace(answer[idx], idx - 1);
            map.replace(answer[idx - 1], idx);

            String callPlayer = answer[idx];
            String prevPlayer = answer[idx -1];
            answer[idx] = prevPlayer;
            answer[idx - 1] = callPlayer;

        }

        return answer;
    }
}