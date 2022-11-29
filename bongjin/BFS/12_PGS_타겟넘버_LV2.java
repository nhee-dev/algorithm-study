class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target);
        return answer;
    }

    private void dfs(int len, int sum, int[] numbers, int target)
    {
        if (len == numbers.length)
        {
            if (sum == target)
            {
                answer++;
                return ;
            }
        }
        else
        {
            int tmp;
            tmp = sum + numbers[len];
            dfs(len + 1, tmp, numbers, target);
            tmp = sum - numbers[len];
            dfs(len + 1, tmp, numbers, target);
        }

    }
}