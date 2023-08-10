package jinwoo.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16935 {
    static int[][] arr;
    static int N, M, R;
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken()); //짝수
    M = Integer.parseInt(st.nextToken()); //짝수
    R = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    
    for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<M; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<R; i++){

        int x = Integer.parseInt(st.nextToken());

        switch(x) {
            case 1:
                first();
                break;
            case 2:
                second();
                break;
            case 3:
                third();
                break;
            case 4:
                fourth();
                break;
            case 5:
                fifth();
                break;
            case 6:
                sixth();
                break;
        }
    }   
    
    print();

}
    public static void first() {
        for(int i=0; i<(N/2); i++) {
            int[] tmp = arr[(N-1)-i];
            arr[(N-1)-i] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void second() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M/2; j++) {
                int tmp = arr[i][(M-1)-j];
                arr[i][(M-1)-j] = arr[i][j];
                arr[i][j] = tmp;
            } 
        }
    }

    public static void third() {
        int tmp = N;
        N = M;
        M = tmp;
        int[][] newArr = new int[N][M];
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                newArr[j][(M-1)-i] = arr[i][j];
            }
        }
        arr = newArr;
    }

    public static void fourth() {
        int tmp = N;
        N = M;
        M = tmp;
        int[][] newArr = new int[N][M];
        for(int i=N-1; i>=0; i--) {
            for(int j=0; j<M; j++) {
                newArr[(N-1)-i][j]= arr[j][i];
            }
        }
        arr = newArr;
    }

    public static void fifth() {
        int nMid = N/2; //3
        int mMid = M/2; //4
        //1 -> 2
        for(int i=0; i<N/2; i++) {
            for(int j=0; j<M/2; j++) {
                int tmp = arr[i][mMid + j];
                arr[i][mMid + j] = arr[i][j];
                arr[i][j] = tmp;
            }
        }

        //2 -> 3
        for(int i=0; i<N/2; i++) {
            for(int j=0; j<M/2; j++) {
                int tmp = arr[i+nMid][mMid + j];
                arr[i+nMid][mMid + j] = arr[i][j];
                arr[i][j] = tmp;
            }
        }

        //3 -> 4
        for(int i=0; i<N/2; i++) {
            for(int j=0; j<M/2; j++) {
                int tmp = arr[i+nMid][j];
                arr[i+nMid][j] = arr[i][j];
                arr[i][j] = tmp;
            }
        }
    }

    public static void sixth() {
        int nMid = N/2; //3
        int mMid = M/2; //4

        // 1 -> 4
        for(int i=0; i<N/2; i++) {
            for(int j=0; j<M/2; j++) {
                int tmp = arr[i+nMid][j];
                arr[i+nMid][j] = arr[i][j];
                arr[i][j] = tmp;
            }
        }

        // 4 -> 3
        for(int i=0; i<N/2; i++) {
            for(int j=0; j<M/2; j++) {
                int tmp = arr[i+nMid][j+mMid];
                arr[i+nMid][j+mMid] = arr[i][j];
                arr[i][j] = tmp;
            }
        }

        // 3 -> 2
        for(int i=0; i<N/2; i++) {
            for(int j=0; j<M/2; j++) {
                int tmp = arr[i][j+mMid];
                arr[i][j+mMid] = arr[i][j];
                arr[i][j] = tmp;
            }
        }
    }

    public static void print() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
