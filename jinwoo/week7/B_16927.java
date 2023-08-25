package jinwoo.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16927 {
    static int[][] arr ;
    static int N, M, R;
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    arr = new int[N][M];

    for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<M; j++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i][j] = x;
        }
    }

    int mid  = (Math.min(N,M))/2 ; //N과 M중 작은 수가 돌리는 횟수의 기준이 된다.

    for(int i=0; i< mid; i++) {
        int r = R % (((N - ((2*i)+1))+(M - ((2*i)+1)))*2);
        for(int j=0; j<r; j++){
            rotate(i);
        }
    }

    print();

}
    public static void rotate(int k) {
        int next = arr[k][k]; 
        for(int i=k; i<=N-2-k; i++) { //위 -> 아래
            int tmp = arr[i+1][k];
            arr[i+1][k] = next;
            next = tmp;
        }

        for(int i=k; i<=M-2-k; i++) { //왼 -> 오
            int tmp = arr[N-1-k][i+1];
            arr[N-1-k][i+1] = next;
            next = tmp;
        }

        for(int i=N-1-k; i>=1+k; i--) { //아래 -> 위
            int tmp = arr[i-1][M-1-k];
            arr[i-1][M-1-k] = next;
            next = tmp;
        }

        for(int i=M-1-k; i>=1+k; i--) { //오 -> 왼
            int tmp = arr[k][i-1];
            arr[k][i-1] = next;
            next = tmp;
        }
    }

    public static void print() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
    }
    }
} 