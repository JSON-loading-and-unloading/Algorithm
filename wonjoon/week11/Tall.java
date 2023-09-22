package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tall {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] check; // 이어져있는지
    static int N, M;

    public static void main(String[] args) throws Exception {
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(check[i], false);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            check[from][to] = true;
        }

        for (int k = 0; k < N; k++) { // 경유지
            for (int i = 0; i < N; i++) { // 출발지
                for (int j = 0; j < N; j++) { // 도착지
                    if (k == i || i == j || k == j)
                        continue;
                    if (check[i][j])
                        continue;
                    if (check[i][k] == true && check[k][j] == true)
                        check[i][j] = true;
                    // 한단계씩 갈 수 있는지 체크 갈 수 있다면 true
                }
            }
        }

        for (int i = 0; i < N; i++) {
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                if (i == j || check[i][j] || check[j][i])
                    continue;
                // n번이 m번까지 모두 연결되어있다면 계속 continue하여 flag가 true
                flag = false;
                break;

            }
            if (flag)
                answer++;
        }
        System.out.println(answer);
    }
}
