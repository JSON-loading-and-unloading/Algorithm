import java.io.*;
import java.util.*;

public class _15486 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][2];
        int[] dp = new int[n+2];

        // 각 날짜별 상담 정보 입력받기
        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken()); // 상담 기간
            int p = Integer.parseInt(st.nextToken()); // 상담 금액
            arr[i][0] = t;
            arr[i][1] = p;
        }

        int max = 0; // 현재까지 얻을 수 있는 최대 수익

        // 상담을 시작할 수 있는 각 날짜에 대해
        for(int i=1; i<=n+1; i++) {
            // 이전까지의 최대 수익보다 현재 수익이 더 크면 갱신
            max = Math.max(max, dp[i]);

            // 현재 날짜의 상담을 했을 때 끝나는 날짜
            int nxt = i + arr[i][0];

            if(nxt <= n+1) {
                // nxt 날짜에 도달했을 때 얻을 수 있는 수익과 현재까지의 최대 수익 + 현재 날짜의 상담 금액 중 큰 값 저장
                dp[nxt] = Math.max(dp[nxt], max + arr[i][1]);
            }
        }

        System.out.println(max); // 최대 수익 출력
    }
}

