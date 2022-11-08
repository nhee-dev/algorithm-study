import java.util.*;

class Solution {
    static int answer;
    static boolean[] v;
    static Queue<String> q;

    public int solution(String begin, String target, String[] words) {
        answer = 0;
        v = new boolean[words.length];
        q = new LinkedList<>();
        q.add(begin);

        answer = dfs(words, target, 0);

        return answer;
    }

    public static int dfs(String[] words, String target, int depth)
    {
        int result = Integer.MAX_VALUE;
        while (!q.isEmpty())
        {
            int size = q.size();
            for (int sz = 0; sz < size; sz++) {
                String str = q.poll();
                if (str.equals(target)) {
                    return Math.min(result, depth);
                }

                char[] origin = str.toCharArray();
                for (int i = 0; i < words.length; i++) {
                    int cnt = 0;
                    char[] change = words[i].toCharArray();
                    for (int j = 0; j < change.length; j++) {
                        if (origin[j] != change[j]) {
                            cnt++;
                        }
                    }
                    if (cnt == 1 && !v[i]) {
                        v[i] = true;
                        q.add(words[i]);
                    }
                }
            }
            depth++;
        }
        return 0;
    }
}