import java.util.*;
import java.io.*;

// 2133: 타일 채우기
// O(N^2), N <= 30, 148ms 
// 1492KB

public class Main{
    static int N;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        br.close();

        if (N % 2 == 1) {
            bw.write(0 + "\n");
            bw.flush();
            bw.close();
            return;
        }
        dp = new int[N + 1];
        dp[0] = 1;
        dp[2] = 3;

        // N: 1 -> 0개
        // N: 2 -> 3개 -> 
        // N: 3 -> 0개
        // N: 4 -> N(2) * N(2) + N(0) * 2
        // N: 6 -> N(4) * N(2) + N(2) * 2 + 2
        // N: 8 -> N(6) * N(2) + N(4) * 2 + N(2) * 2 + 2
        // N: 0 -> 1개로 가정

        for (int i = 4; i < N + 1; i += 2){
            dp[i] = dp[i - 2] * dp[2];
            
            for (int j = i - 4; j >= 0; j -= 2){
                dp[i] += dp[j] * 2;
            }
        }
        
        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }
}