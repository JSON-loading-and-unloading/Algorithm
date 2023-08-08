package jinwoo.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
        int x;
        int y;
        int cnt; // 벽을 부순 개수
     
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
     
        @Override
        public int compareTo(Point o) {
            return cnt - o.cnt;
        }
    }

public class B_1261 {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] chk;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int min = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        chk = new int[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        int cnt = bfs();

        System.out.println(cnt);
    }

    public static int bfs(){
         PriorityQueue<Point> queue = new PriorityQueue<>(); // 벽을 부순 개수를 오름차순으로 정렬하도록 설정.
         queue.offer(new Point(0, 0, 0));
         while(!queue.isEmpty()){
            Point p = queue.poll();

            if (p.x == N-1 && p.y == M-1) {
                return p.cnt;
            }
            
            if(p.x<0 || p.y<0 || p.x>N-1 || p.y>M-1) continue;
            if(chk[p.x][p.y]==1) continue;
            if(arr[p.x][p.y] == 1) {
                p.cnt = p.cnt +1;
            }
            chk[p.x][p.y] = 1;

            for(int i=0;i<4;i++){
                queue.offer(new Point(p.x+dx[i],p.y+dy[i],p.cnt));
            }
        }
        return 0;
    }
}
