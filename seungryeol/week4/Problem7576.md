import java.util.*;

public class Problem7576 {
    static int[][] tomatoBox;
    static int[] dx = { -1, 0, 1, 0};
    static int[] dy = { 0, 1, 0, -1};
    static int m, n;



    public static void main(String[] args) {
        int day;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        tomatoBox = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j < m; j++){
                tomatoBox[i][j] = sc.nextInt();
            }
        }

        day = bfs();

        if (checkAllRipe()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static int bfs(){
        Queue<Pair> queue = new LinkedList<>();
        int day = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tomatoBox[i][j] == 1){
                    queue.offer(new Pair(i,j));
                }
            }
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair tomato = queue.poll();
                for(int j = 0; j < 4; j++){
                    int nx = tomato.x + dx[j];
                    int ny = tomato.y + dy[j];

                    if(isValid(nx,ny) && tomatoBox[nx][ny] == 0){
                        tomatoBox[nx][ny] = 1;
                        queue.offer(new Pair(nx,ny));
                    }
                }
            }
            if(!queue.isEmpty()){
                day++;
            }
        }
        return day;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static boolean checkAllRipe() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoBox[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


// 1. 토마토 상자를 순회하여 익은 토마토의 좌표를 큐에 넣는 시간 복잡도: O(N*M) (N은 행의 개수, M은 열의 개수)
// 2. BFS를 통해 익은 토마토를 상하좌우로 퍼뜨리는 시간 복잡도: O(N*M)
// 3. 최악의 경우, 모든 칸을 큐에 넣고 BFS를 진행하게 될 수 있으므로 최악의 시간 복잡도는 O(N*M)입니다.