import java.util.*;
import java.io.*;

// 14500: 테트로미노
// O(N * M * 4 ^ 4), N <= 500, M <= 500, 848ms
// 68876KB

public class Main{
    static int N, M, max_sum;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] graph = new int[501][501];
    static boolean[][] visited = new boolean[501][501];

    // ㅗ 모양 블록 빼고 4개로 백트래킹 돌리면 다 구현 가능
    public static void dfs(int x, int y, int depth, int sum){
        sum += graph[x][y];

        if (depth == 4) {
            max_sum = Math.max(max_sum, sum);
            return;
        }

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx <= 0 || nx > N || ny <= 0 || ny > M) continue;
            if (visited[nx][ny] == true) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum);
            visited[nx][ny] = false; // 백트래킹    
        }
    }

    public static void calculate(int x, int y){
        int[] values = new int[4];

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx <= 0 || nx > N || ny <= 0 || ny > M) {
                values[i] = -4001;
            } else {
                values[i] = graph[nx][ny];
            }
        }

        int sum = Arrays.stream(values).sum() + graph[x][y];

        for (int val: values){
            max_sum = Math.max(max_sum, sum - val);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                visited[i][j] = true;
                dfs(i, j, 1, 0);
                visited[i][j] = false;

                calculate(i, j);
            }
        }

        bw.write(String.valueOf(max_sum));
        bw.flush();
        bw.close();

        // for (int i = 1; i <= N; i++){
        //     for (int j = 1; j<= M; j++){
        //         System.out.print(graph[i][j]);
        //     }
        //     System.out.println();
        // }
    }
}