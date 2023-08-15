package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14499 {
    static int N, M, X, Y;
    static int[][] board;
    static int[] dice;
    //0이 천장, 5가 바닥 백준 무시

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    //순서대로 동,서,남,북

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dice = new int[6];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rolling(new StringTokenizer(br.readLine()));
    }

    static void rolling(StringTokenizer st) {
        while (st.hasMoreTokens()) {
            int dir = Integer.parseInt(st.nextToken()) - 1;

            if (X + dx[dir] < 0 || Y + dy[dir] < 0 || X + dx[dir] >= N || Y + dy[dir] >= M)
                continue;
            X += dx[dir];
            Y += dy[dir];

            int tmp = dice[5];
            switch (dir) {
                // 동
                case 0:
                    dice[5] = dice[2];
                    dice[2] = dice[0];
                    dice[0] = dice[3];
                    dice[3] = tmp;
                    break;
                // 서
                case 1:
                    dice[5] = dice[3];
                    dice[3] = dice[0];
                    dice[0] = dice[2];
                    dice[2] = tmp;
                    break;
                // 남
                case 2:
                    dice[5] = dice[4];
                    dice[4] = dice[0];
                    dice[0] = dice[1];
                    dice[1] = tmp;
                    break;

                // 북
                default:
                    dice[5] = dice[1];
                    dice[1] = dice[0];
                    dice[0] = dice[4];
                    dice[4] = tmp;
            }

            // 0인경우 주사위 바닥 -> 맵
            if (board[X][Y] == 0) {
                board[X][Y] = dice[5];
            }

            // board이 0이 아닌 경우 맵 -> 주사위 복사, 맵은 0으로 된다.
            else {
                dice[5] = board[X][Y];
                board[X][Y] = 0;
            }

            System.out.println(dice[0]);
        }
    }
}
