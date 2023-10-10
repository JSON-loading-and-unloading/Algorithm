package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10830 {
    static long[][] origin;
    static long[][] matrix;
    static long[][] temp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        origin = new long[n][n];
        matrix = new long[n][n];
        temp = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                temp[i][j] = matrix[i][j];
                origin[i][j] = matrix[i][j];
            }
        }

        matrixSum(b);

//        int cnt = 1;
//        int sum;
//        while (cnt < b) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    sum = 0;
//                    for (int k = 0; k < n; k++) {
//                        sum += matrix[i][k]*origin[k][j];
//                    }
//                    temp[i][j] = sum;
//                }
//            }
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    matrix[i][j] = temp[i][j];
//                }
//            }
//            cnt++;
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]%1000 + " ");
            }
            System.out.println();
        }
    }

    static void matrixSum(long b) {
        if (b == 0)
            return;
        matrixSum(b/2);
        if (b == 1)
            return;
        if (b%2 == 1) {
            multi(matrix);
            multi(origin);
            return;
        }
        multi(matrix);
    }

    static void multi(long[][] matrix2) {
        long sum;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += matrix[i][k]*matrix2[k][j];
                }
                temp[i][j] = sum % 1000;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
