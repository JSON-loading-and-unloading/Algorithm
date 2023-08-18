package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14890 {
    static boolean[][] empty;
    static int[][] board;
    static int n;
    static int l;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        empty = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                empty[i][j] = true;
            }
        }

        check();

        System.out.println(count);
    }

    static void check() {
        boolean check;
        //가로 검사
        for (int i = 0; i < n; i++) {
            check = true;
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] < board[i][j+1]) {
                    if (board[i][j] != board[i][j+1] - 1) {
                        check = false;
                        break;
                    }
                    if (j < l-1) {
                        check = false;
                        break;
                    }
                    for (int k = 0; k < l-1; k++ ) {
                        if (board[i][j-k] != board[i][j-k-1]) {
                            check = false;
                            break;
                        }
                        if (!(empty[i][j-k] && empty[i][j-k-1])) {
                            check = false;
                            break;
                        }
                    }
                    if (l == 1) {
                        if (!empty[i][j]) {
                            check = false;
                            break;
                        }
                    }
                    if (!check)
                        break;

                    for (int k = 0; k <= l-1; k++ ) {
                        empty[i][j-k] =false;
                    }
                }
                if (board[i][j] > board[i][j + 1]) {
                    if (board[i][j] != board[i][j+1] + 1) {
                        check = false;
                        break;
                    }
                    if (j >= (n-l)) {
                        check = false;
                        break;
                    }
                    for (int k = 0; k < l-1; k++ ) {
                        if (board[i][j+k+1] != board[i][j+k+2]) {
                            check = false;
                            break;
                        }
                        if (!(empty[i][j+k+1] && empty[i][j+k+2])) {
                            check = false;
                            break;
                        }
                    }
                    if (l == 1) {
                        if (!empty[i][j+1]) {
                            check = false;
                            break;
                        }
                    }
                    if (!check)
                        break;

                    for (int k = 1; k <= l; k++ ) {
                        empty[i][j+k] =false;
                    }
                }
            }
            if (check) {
                count++;
            }
            Arrays.fill(empty[i], true);
        }

        // 세로 검사
        for (int i = 0; i < n; i++) {
            check = true;
            for (int j = 0; j < n - 1; j++) {
                if (board[j][i] < board[j+1][i]) {
                    if (board[j][i] != board[j+1][i] - 1) {
                        check = false;
                        break;
                    }
                    if (j < l-1) {
                        check = false;
                        break;
                    }
                    for (int k = 0; k < l-1; k++ ) {
                        if (board[j-k][i] != board[j-k-1][i]) {
                            check = false;
                            break;
                        }
                        if (!(empty[j-k][i] && empty[j-k-1][i])) {
                            check = false;
                            break;
                        }
                    }
                    if (l == 1) {
                        if (!empty[j][i]) {
                            check = false;
                            break;
                        }
                    }
                    if (!check)
                        break;

                    for (int k = 0; k <= l-1; k++ ) {
                        empty[j-k][i] =false;
                    }
                }
                if (board[j][i] > board[j+1][i]) {
                    if (board[j][i] != board[j+1][i] + 1) {
                        check = false;
                        break;
                    }
                    if (j >= (n-l)) {
                        check = false;
                        break;
                    }
                    for (int k = 0; k < l-1; k++ ) {
                        if (board[j+k+1][i] != board[j+k+2][i]) {
                            check = false;
                            break;
                        }
                        if (!(empty[j+k+1][i] && empty[j+k+2][i])) {
                            check = false;
                            break;
                        }
                    }
                    if (l == 1) {
                        if (!empty[j+1][i]) {
                            check = false;
                            break;
                        }
                    }
                    if (!check)
                        break;

                    for (int k = 1; k <= l; k++ ) {
                        empty[j+k][i] =false;
                    }
                }
            }
            if (check) {
                count++;
            }
            Arrays.fill(empty[i], true);
        }
    }
}
