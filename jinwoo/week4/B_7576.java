package jinwoo.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576 {
    static int M;
    static int N;
    static int[][] arr;
    static int[][] chk;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int ans;
     public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        chk = new int[N][M]; //체크배열

        for(int i=0; i<N; i++){
             st = new StringTokenizer(br.readLine());
             for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    queue.offer(i);
                    queue.offer(j);
                    queue.offer(0);
                }

                if(arr[i][j]==-1){
                    chk[i][j] =1;
                }
             }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            int d = queue.poll();
            d = ans;

            if(x<0 || y<0 || x>N-1 || y>M-1) continue;
            if(arr[x][y]==-1 || chk[x][y]==1) continue;
            chk[x][y] = 1;

            for(int i=0;i<4;i++){
                queue.offer(x+dx[i]);
                queue.offer(y+dy[i]);
                queue.offer(d+1);
            }
        }

        loop :
         for(int i=0; i<N; i++){
             for(int j=0; j<M; j++){
                if(chk[i][j]==0) {
                    System.out.println(-1);
                    break loop;
                }

                if(i==N-1 && j==M-1){
                   System.out.println(ans-1); 
                }
          }
        }
}
}
