package week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_7576 {
    static int[] moveN = { -1, 1, 0, 0 };
    static int[] moveM = { 0, 0, -1, 1 };
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int box[][] = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        bfs(box, N, M);

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        /**
         * 안익은 것 보이면 -1
         * 모두 익었으면 dp중 가장 큰 값이 총 걸린 날짜
         */
        System.out.println(max);
    }

    static void bfs(int[][] box, int N, int M) {
        Queue<Ripe> ripe = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1)
                    ripe.offer(new Ripe(i, j));
            }
        }
        /**
         * 익은 것들 queue에 담아줌
         * 해당 큐를 기준으로 상하좌우가 더 익을 것이기 때문에
         */

        while (!ripe.isEmpty()) {
            Ripe current = ripe.poll();
            for (int i = 0; i < 4; i++) {
                int n = current.n + moveN[i];
                int m = current.m + moveM[i];

                if (n < 0 || m < 0 || n >= N || m >= M)
                    continue;
                if (box[n][m] != 0)
                    continue;
                /**
                 * 안익은 토마토 익히고 해당 좌표 큐에 넣어줌
                 * 동시에 기존의 날짜 + 1하여 익은 날짜 기록
                 *
                 * 더이상 익힐 것이 없으면 while탈출
                 */
                box[n][m] = 1;
                dp[n][m] = dp[current.n][current.m] + 1;
                ripe.offer(new Ripe(n, m));
            }
        }
    }

    static class Ripe {
        int n;
        int m;

        public Ripe(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
