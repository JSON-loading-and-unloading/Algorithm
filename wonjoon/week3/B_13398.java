package week3;

import java.util.Scanner;

public class B_13398 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }
        int max = getMax(seq);
        System.out.println(max);
    }

    static int getMax(int[] seq) {
        int n = seq.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        dp[0] = seq[0];
        dp2[0] = 0;
        int max = dp[0];
        for(int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1]+seq[i], seq[i]);
            //dp[i] 는 그냥 자신까지 쭉 더한 값 혹은 자신
            dp2[i] = Math.max(dp2[i-1]+seq[i], dp[i-1]);
            //dp[i] 는 자신의 값을 제외하고 모두 더한 값 혹은 이전에 결과 + 자신의 값 중 더 큰 값이 저장된다.
            max = Math.max(max, Math.max(dp[i], dp2[i]));
        }
        return max;
    }
}
