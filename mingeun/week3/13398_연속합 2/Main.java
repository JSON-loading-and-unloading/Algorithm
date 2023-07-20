import java.util.*;
import java.io.*;

// 13398: 연속합 2
// O(N), N <= 1000000, 316ms 
// 26586KB

public class Main{
    static int N;
    static int[] nums;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        dp[0][0] = nums[0]; // 삭제 X
        dp[0][1] = nums[0]; // 1개 삭제

        int result = nums[0];

        for (int i = 1; i < N; i++){
            // i번째 수 or i - 1 까지의 최대 + i번째 수
            dp[i][0] = Math.max(nums[i], dp[i - 1][0] + nums[i]);

            // i번째 수를 지우는 경우 or 이미 지워서 이번 꺼는 더해야 하는 경우
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);

            result = Math.max(result, dp[i][0] > dp[i][1] ? dp[i][0] : dp[i][1]);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}