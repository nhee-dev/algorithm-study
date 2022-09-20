import java.util.*;

class Solution {
    List<String> paths;
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        paths = new ArrayList();
        visited = new boolean[tickets.length];

        dfs(tickets, "ICN", "ICN", 0);

        Collections.sort(paths);
        
        return paths.get(0).split(" ");
    }
    
    public void dfs(String[][] tickets, String cur, String path, int depth) {
        if(depth == tickets.length) {
            paths.add(path);
            return;
        }
        
        for(int i = 0; i<tickets.length; i++) {
            if(tickets[i][0].equals(cur) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], path + " " + tickets[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
}