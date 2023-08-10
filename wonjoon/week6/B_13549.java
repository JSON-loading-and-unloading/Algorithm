package week6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_13549 {
    /**
     * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
     *
     * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
     *
     * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
     */
    static int[] dp;
    static int n;

    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        n = Integer.parseInt(input.nextToken());
        k = Integer.parseInt(input.nextToken());

        dp = new int[100001];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[n] = 0;
        bfs();

        System.out.println(dp[k]);
    }

    static void bfs() {
        Deque<Integer> queue = new LinkedList<>();
        queue.addFirst(n);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == k)
                break;
            if (now <= 50000 && (dp[now * 2] > dp[now] || dp[now * 2] == Integer.MAX_VALUE)) {
                dp[now * 2] = dp[now];
                queue.addFirst(now*2);
            }
            if (now < 100000 && (dp[now + 1] > dp[now] ||dp[now + 1] == Integer.MAX_VALUE)) {
                dp[now + 1] = dp[now] + 1;
                queue.addLast(now+1);
            }
            if (now > 0 && (dp[now - 1] > dp[now] || dp[now - 1] == Integer.MAX_VALUE)) {
                dp[now - 1] = dp[now] + 1;
                queue.addLast(now-1);
            }
        }
    }
}
