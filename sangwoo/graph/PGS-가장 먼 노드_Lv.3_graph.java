import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer> map[] = new List[n + 1];
        boolean[] visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            map[i] = new ArrayList();
        }
        for(int i = 0; i <edge.length; i++) {
            map[edge[i][0]].add(edge[i][1]);
            map[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<Integer> q = new LinkedList();
        q.offer(1);
        visited[1] = true;
        int depth = 0;
        int size = 0;
        while(!q.isEmpty()) {
            size = q.size();
            for(int i = 0; i <size; i++) {
                int num = q.poll();
                for(int j = 0; j < map[num].size(); j++) {
                    int cur = map[num].get(j);
                    if(!visited[cur]) {
                        q.offer(cur);
                        visited[cur] = true;
                    }
                }
            }
            depth++;
        }        
        
        return size;
    }
}