import java.util.*;
import java.io.*;

//메모리 119632KB, 시간복잡도 O(m * n)
class Main {
    static int n;
    static int m;
    static int[][] box;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        box = new int[m][n];
 
        for(int i = 0; i < m; i++) { //2차원 배열 생성 후, 값 넣기
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        bfs();
    }
 
    static void bfs() {
        Queue<Point> q = new LinkedList<Point>();
        int cnt = 0;
 
        // 토마토가 있는 좌표 찾아서 Queue에 넣기
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(box[i][j] == 1) 
                    q.offer(new Point(i, j, 0));
            }
        }
        while(!q.isEmpty()) {
            Point point = q.poll();
            cnt = point.cnt;
 
            for(int i=0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
 
                if(0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if(box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        q.add(new Point(nx, ny, cnt+1));
                    }
                }
            }
        }
 
        // 토마토가 다 익었는지 확인
        if(isAllGrown())
            System.out.println(cnt);
        else
            System.out.println(-1);
    }    
    static boolean isAllGrown() {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(box[i][j] == 0)
                    return false;
            }
        }
 
        return true;
    }
    
   public static class Point {
        int x;
        int y;
        int cnt;
 
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}