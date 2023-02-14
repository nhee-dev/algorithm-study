import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N, M;
    static int[][] table;
    static boolean[][] visited;
    
    static int count;
    static ArrayList<Integer> areas = new ArrayList<Integer>();
    
    static int[] queueX;
    static int[] queueY;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    
    public static void main(String args[]) {
        initData();
        solution();
        output();
    }
    
    static void initData() {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        table = new int[M][N];
        visited = new boolean[M][N];
        queueX = new int[N*M];
        queueY = new int[N*M];
        
        int K = sc.nextInt();
        int x0, y0, x1, y1;
        for (int i = 0; i < K; i++) {
            x0 = sc.nextInt();
            y0 = sc.nextInt();
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            
            setRectangle(x0, y0, x1, y1);
        }
        
        sc.close();
    }
    
    static void setRectangle(int x0, int y0, int x1, int y1) {
        for (int i = y0; i < y1; i++) {
            for (int j = x0; j < x1; j++) {
                table[i][j] = 1;
            }
        }
    }
    
    static void solution() {
        int area;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 0 && !visited[i][j]) {
                    area = getArea(i, j);
                    count++;
                    areas.add(area);
                }
            }
        }
    }
    
    static int getArea(int y, int x) {
        int front = -1, rear = -1;
        inputQ(++rear, x, y);
        
        int area = 0;
        while (front != rear) {
            x = queueX[++front]; // pop X
            y = queueY[front];  // pop Y
            area++;
            
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                
                if (!isWall(nx, ny) && table[ny][nx] == 0 && !visited[ny][nx]) {
                    inputQ(++rear, nx, ny);
                }
            }
        }
        
        return area;
    }
    
    static void inputQ(int rear, int x, int y) {
        queueX[rear] = x;
        queueY[rear] = y;
        visited[y][x] = true;
    }
    
    static boolean isWall(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    
    static void output() {
        System.out.println(count);
        
        Collections.sort(areas);
        for (Integer area : areas) {
            System.out.print(area + " ");
        }
    }
}
