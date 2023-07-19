package week3;

import java.util.Scanner;

public class B_2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int solution = solution(N);
        System.out.println(solution);
    }

    static int solution(int N) {
        if (N % 2 != 0)
            return 0;
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= N; i += 2) {
            dp[i] = dp[i-2] * dp[2];
            for (int j = 4; j <= i; j += 2) {
                dp[i] += 2 * dp[i-j];
            }
        }

        return dp[N];
    }
}
