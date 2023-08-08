package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16935 {
    static int[][] board;
    static int[][] copy;
    static int n;
    static int m;
    static int tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        m = Integer.parseInt(input.nextToken());
        int r = Integer.parseInt(input.nextToken());

        board = new int[n][m];
        copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input.nextToken());
                copy[i][j] = board[i][j];
            }
        }

        input = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            operation(Integer.parseInt(input.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void operation(int num) {
        if (num == 1) {
            upDownReverse();
            return;
        }
        if (num == 2) {
            reverse();
            return;
        }
        if (num == 3) {
            right();
            return;
        }
        if (num == 4) {
            left();
            return;
        }
        if (num == 5) {
            rightSection();
            return;
        }
        if (num == 6) {
            leftSection();
        }
    }

    static void upDownReverse() {
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = copy[n-1-i][j];
            }
        }
        copy = board;
    }

    static void reverse() {
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = copy[i][m-1-j];
            }
        }
        copy = board;
    }

    static void right() {
        board = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[j][n-1-i] = copy[i][j];
            }
        }
        copy = board;

        tmp = n;
        n = m;
        m = tmp;
    }

    static void left() {
        board = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[m-1-j][i] = copy[i][j];
            }
        }
        copy = board;

        tmp = n;
        n = m;
        m = tmp;
    }

    static void rightSection() {
        board = new int[n][m];

        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                board[i][j] = copy[i+n/2][j];
                board[i][j+m/2] = copy[i][j];
                board[i+n/2][j+m/2] = copy[i][j+m/2];
                board[i+n/2][j] = copy[i+n/2][j+m/2];
            }
        }
        copy = board;
    }

    static void leftSection() {
        board = new int[n][m];

        for(int i=0; i<n/2; i++){
            for(int j=0; j<m/2; j++){
                board[i][j] = copy[i][j+m/2];
                board[i][j+m/2] = copy[i+n/2][j+m/2];
                board[i+n/2][j+m/2] = copy[i+n/2][j];
                board[i+n/2][j] = copy[i][j];
            }
        }

        copy = board;
    }
}

