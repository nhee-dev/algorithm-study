class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int w = park[0].length();
        int h = park.length;

        char[][] arr = new char[h][w];
        int x = 0;
        int y = 0;

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                arr[i][j] = park[i].charAt(j);
                if(arr[i][j] == 'S'){
                    x = j;
                    y = i;
                }
            }
        }
        for(int i = 0; i < routes.length; i++){
            char direction = routes[i].charAt(0);
            int dis = routes[i].charAt(2) - '0';
            boolean block = false;
            switch(direction){
                case 'N':
                    if(y - dis >= 0) {
                        for(int j = 0; j <= dis; j++){
                            if(arr[y - j][x] == 'X') block = true;
                        }
                        if(!block) y -= dis;
                        block = false;
                    }
                    break;
                case 'S':
                    if(y + dis < h) {
                        for(int j = 0; j <= dis; j++){
                            if(arr[y + j][x] == 'X') block = true;
                        }
                        if(!block) y += dis;
                        block = false;
                    }
                    break;
                case 'W':
                    if(x - dis >= 0){
                        for(int j = 0; j <= dis; j++){
                            if(arr[y][x - j] == 'X') block = true;
                        }
                        if(!block) x -= dis;
                        block = false;
                    }
                    break;
                case 'E':
                    if(x + dis < w){
                        for(int j = 0; j <= dis; j++){
                            if(arr[y][x + j] == 'X') block = true;
                        }
                        if(!block) x += dis;
                        block = false;
                    }
                    break;
            }
            System.out.println(y + " " + x);

        }
        answer[0] = y;
        answer[1] = x;

        return answer;
    }
}