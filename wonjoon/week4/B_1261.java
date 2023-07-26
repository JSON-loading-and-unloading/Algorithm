package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1261 {
    static int N;
    static int M;
    static int[] moveN = new int[]{0, 0, 1, -1};
    static int[] moveM = new int[]{1, -1, 0, 0};
    static int board[][];
    static int[][] dp;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        board = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for (int i = 1; i < N+1; i++) {
            String line = br.readLine();
            for (int j = 1; j < M+1; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
            }
        }

        bfs();

        System.out.println(dp[N][M]);
    }

    static void bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(1, 1, 0));
        visit[1][1] = true;
        dp[1][1] = 0;
        int n;
        int m;
        while (!queue.isEmpty()) {
            /**
             * Point가 벽을 부시고 지나간 횟수가 제일 작을 수록 우선순위를 가지도록 되어있기 때문에
             * 이 경우 만약 벽을 부순 횟수가 0 1 2 3 이라면 무조건 0인 경우를 우선 계산하기 때문에 각 위치에 도착할 때 최소가 될 수 있다.
             *
             * 기존과 모든 로직이 동일하지만 기존에는 최소의 횟수가 가장 먼저 나오게 구현되어있지 않기 때문에 3을 먼저 계산할 수 있어서 안된 것이다.
             */
            Point current = queue.poll();
            if (visit[N][M])
                return;
            for (int i = 0; i < 4; i++) {
                n = moveN[i] + current.n;
                m = moveM[i] + current.m;
                if (n == N+1 || m == M+1 || visit[n][m])
                    continue;

                if (n > 0 && n <= N && m > 0 && m <= M) {
                    if (board[n][m] == 1) {
                        dp[n][m] = dp[current.n][current.m] + 1;
                    }
                    if (board[n][m] == 0) {
                        dp[n][m] = dp[current.n][current.m];
                    }
                    visit[n][m] = true;
                    queue.offer(new Point(n, m, dp[n][m]));
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int n;
        int m;
        int cnt; // 벽을 부순 개수

        Point(int n, int m, int cnt) {
            this.n = n;
            this.m = m;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return cnt - o.cnt;
        }
    }
}
