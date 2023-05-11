package src.main.kotlin.dfs;

public class pg121684 {
    int max = -1;
    public int solution(int[][] ability) {
        int answer = 0;

        int studentNum = ability.length;
        int sportsNum = ability[0].length;
        boolean[] visit = new boolean[studentNum];
        dfs(0,0,ability,visit);
        return max;
    }

    private void dfs(int cnt,int sum, int[][] ability, boolean[] visit){

        if(cnt == ability[0].length){
            max = Math.max(max,sum);
            return;
        }

        for(int i = 0; i < ability.length; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(cnt+1,sum+ability[i][cnt], ability, visit);
                visit[i] = false;
            }
        }

    }

}
