import java.util.*;

class Solution {

    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        bfs(maps);
        return answer != Integer.MAX_VALUE ? answer : -1;
    }

    public static void bfs(int[][] maps) {
        boolean[][] v = new boolean[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[] cur = {0,0,1};
        q.add(cur);
        v[0][0] = true;
        while(!q.isEmpty()) {
            int[] c = q.poll();

            if(c[0] == maps.length - 1 && c[1] == maps[0].length - 1) {
                answer = answer > c[2] ? c[2] : answer;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = c[0] + x[i];
                int ny = c[1] + y[i];
                int count = c[2] + 1;

                if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length) {

                    if(maps[nx][ny] != 0 && !v[nx][ny]) {
                        v[nx][ny] = true;
                        int[] nc = new int[3];
                        nc[0] = nx;
                        nc[1] = ny;
                        nc[2] = count;
                        q.add(nc);
                    }
                }
            }
        }
    }
}