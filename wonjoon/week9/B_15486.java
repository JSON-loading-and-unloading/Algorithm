package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15486 {
    static Consulting[] consultings;
    static int[] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        consultings = new Consulting[n+2];
        dp = new int[n+2];
        StringTokenizer st;
        consultings[n] = new Consulting(0, 0);
        consultings[n+1] = new Consulting(0, 0);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            consultings[i] = new Consulting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        check();

        Arrays.sort(dp);
        System.out.println(dp[n]);
    }
    static void check() {
        int now = 0;
        while (now <= n) {
            if (now + consultings[now].day > n) {
                dp[now+1] = Math.max(dp[now], dp[now+1]);
                now++;
                continue;
            }
            dp[now + consultings[now].day] = Math.max(dp[now + consultings[now].day], dp[now] + consultings[now].money);
            dp[now+1] = Math.max(dp[now], dp[now+1]);
            now++;
        }
    }
}
class Consulting {
    public Consulting(int day, int money) {
        this.day = day;
        this.money = money;
    }
    int day;
    int money;
}
