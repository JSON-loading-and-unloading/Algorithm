// 메모리 24940kb 시간 360ms

import java.io.*;
import java.util.StringTokenizer;

public class _13398 {
    static int N;
    static Integer[] seq;
    static int[] l_dp;
    static int[] r_dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        seq = new Integer[N];
        l_dp = new int[N];
        r_dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(DP());

    }

    public static int DP() {
        l_dp[0] = seq[0];
        r_dp[N - 1] = seq[N - 1];
        int result = l_dp[0];


        for (int i = 1; i < N; i++) {
            l_dp[i] = seq[i];
            if (l_dp[i - 1] + seq[i] > l_dp[i]) {
                l_dp[i] = l_dp[i - 1] + seq[i];
            }
            result=Math.max(result,l_dp[i]);
        }

        for (int i = N - 2; i >= 0; i--) {
            r_dp[i] = seq[i];
            if (r_dp[i + 1] + seq[i] > r_dp[i]) {
                r_dp[i] = r_dp[i + 1] + seq[i];
            }
        }


        for (int i = 1; i < N - 1; i++) {
            int temp = l_dp[i - 1] + r_dp[i + 1];
            result = Math.max(temp, result);
        }

        return result;
    }
}
