package jinwoo.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1261 {
    static int N;
    static int M;
    static int[][] arr;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int min = 100000;
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        queue.offer(0);
        queue.offer(0);
        queue.offer(0);
        queue.offer(0);
        queue.offer(0);

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            int x_ = queue.poll();
            int y_ = queue.poll();
            int d = queue.poll();

            if(x==N-1 && y==M-1) {
                if(d < min) {
                    min = d;
                } 
            }
            if(x<0 || y<0 || x>N-1 || y>M-1) continue;
            if(!(x==0 && y==0) && x==x_ && y==y_) continue;
            if(!(x==0 && y==0) && arr[x][y]==0) {
                d = d-1;
            }
            if(arr[x][y]== -1) continue;
            if((x==0 && y==0)) {
                arr[x][y]= -1;
            }

            for(int i=0;i<4;i++){
                queue.offer(x+dx[i]);
                queue.offer(y+dy[i]);
                queue.offer(x);
                queue.offer(y);
                queue.offer(d+1);
            }
        }
        System.out.println(min);
    }
}
