package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16927 {
    static int n;
    static int m;
    static int inputCnt;
    static int[][] board;
    static int[][] copy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inputCnt = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = board[i][j];
            }
        }

        int nN = n;
        int nM = m;
        for(int i=0; i<Math.min(n, m)/2; i++) {
            int cnt = inputCnt % (2*nN + 2*nM - 4);
            while (cnt > 0) {
                rotate(n, m, i);
                cnt--;
            }
            nN -= 2;
            nM -= 2;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int nx, int mx, int start) {
        for (int i = start ; i < nx-start-1; i++) {
            board[i+1][start] = copy[i][start];
        }
        for (int i = start ; i < mx-start-1; i++) {
            board[nx-start-1][i+1] = copy[nx-start-1][i];
        }
        for (int i = nx-start-1; i >= start+1; i--) {
            board[i-1][mx-start-1] = copy[i][mx-start-1];
        }
        for (int i = mx-start-1; i >= start+1; i--) {
            board[start][i-1] = copy[start][i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = board[i][j];
            }
        }
    }
}
