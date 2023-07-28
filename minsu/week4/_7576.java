import java.io.*;
import java.util.*;
public class _7576 {
    static int N, M;
    static int[][] map;
    static Queue<Node> que = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int zeroNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); //열 개수
        N = Integer.parseInt(st.nextToken()); //행 개수
        map = new int[N][M];
        zeroNum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    que.add(new Node(j, i, 0));
                if (map[i][j] == 0)
                    zeroNum += 1;
            }

        }
        if (zeroNum == 0)
            System.out.println(0);
        else
            System.out.println(bfs());

    }

    public static int bfs() {
        int n_x, n_y;
        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                n_x = node.x + dx[i];
                n_y = node.y + dy[i];
                if (n_x >= 0 && n_y >= 0 && n_x < M && n_y < N) {
                    if (map[n_y][n_x] == 0) {
                        map[n_y][n_x] = 1;
                        que.add(new Node(n_x, n_y, node.count + 1));
                        zeroNum -= 1;
                        if (zeroNum == 0)
                            return node.count + 1;
                    }
                }
            }
        }

        return -1;
    }

    public static class Node {
        public int x;
        public int y;
        public int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
