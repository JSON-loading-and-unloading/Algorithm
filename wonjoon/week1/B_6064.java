package week1;

import java.io.IOException;
import java.util.Scanner;

public class B_6064 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            boolean flag = false;
            int lcm = M * N / gcd(M, N);  //Calculate LCM
            for (int mYear = x; mYear < lcm; mYear += M) {
                if (mYear % N == y) {
                    sb.append(mYear + 1).append("\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }

    //최대공약수 구하는 식
    private static int gcd(int M, int N) {
        while (N != 0) {
            int r = M % N;
            M = N;
            N = r;
        }
        return M;
    }
}

