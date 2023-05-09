import java.util.*;

class Solution {
    public int N, result = 0;
    public List<List<Integer>> map = new ArrayList<>();

    public int solution(int n, int[][] lighthouse) {
        N = n;
        for (int i = 0; i <= N; i++)
            map.add(new ArrayList<>());
        for (int i = 0; i < lighthouse.length; i++) {
            map.get(lighthouse[i][0]).add(lighthouse[i][1]);
            map.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }

        dfs(1, 0);
        return result;
    }

    public int dfs(int cur, int before) {
        if (map.get(cur).size() == 1 && map.get(cur).get(0) == before)
            return 1;

        int tmpRes = 0;
        for (int i = 0; i < map.get(cur).size(); i++) {
            int next = map.get(cur).get(i);
            if (next == before) continue;
            tmpRes += dfs(next, cur);
        }

        if (tmpRes == 0)
            return 1;

        result++;
        return 0;
    }
}