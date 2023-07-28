import java.io.*;
import java.util.*;

public class _1261 {
    static int N, M;// N이 행 M이 열
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        int n_x, n_y;
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!que.isEmpty()) {
            Node now_node = que.poll();
            if (now_node.x == M - 1 && now_node.y == N - 1) {
                return now_node.count;
            }
            for (int i = 0; i < 4; i++) {
                n_x = dx[i] + now_node.x;
                n_y = dy[i] + now_node.y;
                if (n_x >= 0 && n_x < M && n_y >= 0 && n_y < N && visited[n_x][n_y] == false) {
                    if (map[n_x][n_y] == 1) {
                        visited[n_x][n_y] = true;
                        que.add(new Node(n_x, n_y, now_node.count + 1));
                    }
                    if (map[n_x][n_y] == 0) {
                        visited[n_x][n_y] = true;
                        que.add(new Node(n_x, n_y, now_node.count));
                    }
                }
            }
        }
        return 0;
    }

    public static class Node implements Comparable<Node> {
        public int x;
        public int y;
        public int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node node) {
            return this.count - node.count;
        }
    }
}
