package boj;
import java.io.*;
import java.util.*;

public class BOJ_6593_상범빌딩_G5 {
	static int dx[] = {0,1,0,-1,0,0};
	static int dy[] = {-1,0,1,0,0,0};    
    static int dz[] = {0,0,0,0,1,-1};
    static int L,R,C;
    static char arr[][][];
    static int map[][][];
    static boolean visit[][][],check=false;
    static Point start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            check = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L==0 && R==0 && C==0) {
                break;
            }
            arr = new char[L][R][C];
            map = new int[L][R][C];
            visit = new boolean[L][R][C];
            
            for(int l=0; l<L; l++) {
                for(int r=0; r<R; r++) {
                    String str = br.readLine();
                    
                    if(str.equals("")) 
                        str = br.readLine();
                        
                    for(int c=0; c<C; c++) {
                        char ch = str.charAt(c);
                        if(ch == 'S') {
                            start = new Point(c,r,l);
                        }else if(ch == 'E') {
                            end = new Point(c,r,l);
                        }
                        arr[l][r][c] = ch;
                    }
                }
            }
            
            bfs(start);
            if(!check) {
                System.out.println("Trapped!");
            }
        }
        
        
    }
    public static void bfs(Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        visit[p.z][p.y][p.x] = true;
        
        while(!queue.isEmpty()) {
            Point tmp = queue.poll();
            if(tmp.x == end.x && tmp.y == end.y && tmp.z == end.z) {
                
                System.out.println("Escaped in "+map[tmp.z][tmp.y][tmp.x]+" minute(s).");
                check = true;
                return;
            }
            
            for(int d=0; d<6; d++) {
                int newX = tmp.x + dx[d];
                int newY = tmp.y + dy[d];
                int newZ = tmp.z + dz[d];
                
                if(0<=newX && newX<C && 0<=newY && newY<R && 0<=newZ && newZ<L && !visit[newZ][newY][newX]) {
                    if(arr[newZ][newY][newX]!='#') {
                        visit[newZ][newY][newX] = true;
                        map[newZ][newY][newX] = map[tmp.z][tmp.y][tmp.x] + 1;
                        queue.add(new Point(newX,newY,newZ));
                    }
                }
            }
        }
        
    }
    public static class Point{
        int x;
        int y;
        int z;
        public Point(int x,int y,int z) {
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
}