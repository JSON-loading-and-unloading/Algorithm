package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_3085 {
    static int max = 0;
    static String[][] bomboni;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int n = Integer.parseInt(br.readLine());
        bomboni = new String[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                bomboni[i][j] = String.valueOf(input.charAt(j));
            }
        }

        //가로
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                swapRow(i, j, bomboni[i][j], bomboni[i][j+1]);
                getMaxRow(n);
                getMaxColumn(n);
                swapRow(i, j, bomboni[i][j], bomboni[i][j+1]);
            }
        }

        //세로
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n; j++) {
                swapColumn(i, j, bomboni[i][j], bomboni[i+1][j]);
                getMaxRow(n);
                getMaxColumn(n);
                swapColumn(i, j, bomboni[i][j], bomboni[i+1][j]);
            }
        }

        System.out.println(max);
    }

    private static void swapRow(int i, int j, String a, String b) {
        bomboni[i][j] = b;
        bomboni[i][j+1] = a;
    }

    private static void swapColumn(int i, int j, String a, String b) {
        bomboni[i][j] = b;
        bomboni[i+1][j] = a;
    }

    private static void getMaxRow(int n) {
        int count;
        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = 0; j < n-1; j++) {
                if (bomboni[i][j].equals(bomboni[i][j+1])) {
                    count++;
                }
                else
                    count = 1;
                if (max < count) {
                    max = count;
                }
            }
        }
    }

    private static void getMaxColumn(int n) {
        int count;
        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = 0; j < n-1; j++) {
                if (bomboni[j][i].equals(bomboni[j+1][i])) {
                    count++;
                }
                else
                    count = 1;
                if (max < count)
                    max = count;
            }
        }
    }
}
