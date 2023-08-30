import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] time = new int[n + 2];
        int[] pay = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];
        int max = 0; // i 일 까지의 최고 수익
        for (int i = 1; i <= n + 1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
            // i 일에 상담하면 끝나는 날짜
            int day = i + time[i];
            // 퇴사 날까지 기준을 잡아야 함
            if (day <= n + 1) {
                // 상담 끝나는 날짜에 
                // 현재 날짜까지의 최대 금액 + 상담 금액과 현재 날짜 금액 비교 후 큰 값 넣기
                dp[day] = Math.max(dp[day], max + pay[i]);
            }
        }

        System.out.println(max);
    }

}