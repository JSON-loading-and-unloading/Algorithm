package jinwoo.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15486 {
    private static int[] T, P; //시간, 비용
    private static int N;
    private static int max = 0;
    private static int[] dp;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        T = new int[N + 2];
        P = new int[N + 2];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] : i일까지 일했을 때 버는 최고 수익
        // index 1부터 사용 , i번째까지 일한 돈은 i+1번째날에 받는다.
        dp = new int[N + 2];

        for (int i = 1; i < N + 2; i++) {
        
            // max는 현재 시점까지의 최대 수익
            if(max < dp[i])
                max = dp[i];
            
            int day = i + T[i];
            if(day < N + 2)
                dp[day] = Math.max(dp[day], max + P[i]);
            
        }
    
        System.out.println(max);
    }
}
