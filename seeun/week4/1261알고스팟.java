import java.util.*;
import java.io.*;

// 메모리 14576KB, 시간 복잡도 O(n * m)
public class Main {
    static int[] dx = {1, -1, 0, 0}; // x축 이동
    static int[] dy = {0, 0, 1, -1}; // y축 이동
    static boolean[][] isEmpty, visited; //빈방, 방문여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        isEmpty = new boolean[n][m];

        // 공백 없는 문자열을 한 글자씩 분리하여 배열에 넣기. 공백이 없으므로 StringTokenizer 사용 불가
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (input[j] == '0') {
                    isEmpty[i][j] = true;
                }
            }
        }

        int answer = bfs(isEmpty, n, m);
        System.out.println(answer);
    }

    public static int bfs(boolean[][] isEmpty, int n, int m) {
        visited = new boolean[n][m];
        visited[0][0] = true;
        Deque<Point> deque = new ArrayDeque<Point>();
        deque.offer(new Point(0,0,0)); // 시작점 설정
        while (!deque.isEmpty()) {
            Point tmp = deque.poll(); //FIFO 형식을 사용 
            int x = tmp.x;
            int y = tmp.y;
            int cnt = tmp.cnt;

            if (x == n - 1 && y == m - 1) { // 끝까지 온 경우 
                return cnt;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (isEmpty[nx][ny]) { // 빈방이면 앞쪽에 두어 우선순위를 줌 (FIFO)
                        //4개의 후보 중 빈방으로 이동하는 것이 그 시점을 기준으로 가장 벽을 최소로 깰 수 있는 방법.
                        deque.addFirst(new Point(nx, ny, cnt));
                    } else {// 벽이면 뒤쪽에 둠 
                        deque.addLast(new Point(nx, ny, cnt + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static class Point {
        private int x;
        private int y;
        private int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}    
        
       