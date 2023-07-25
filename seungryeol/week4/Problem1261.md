import java.util.*;


public class Problem1261 {
    static int N;
    static int M;
    static int[] dx = { -1, 0, 1, 0};
    static int[] dy = { 0, 1, 0, -1};
    static int[][] miro;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();


        miro = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = sc.nextLine();

            for(int j = 0; j < M; j++){
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        sc.close();

        int minSu = bfs();
        System.out.println(minSu);
    }
    static public int bfs(){

        int[][] blockPuncher = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                blockPuncher[i][j] = Integer.MAX_VALUE;
            }
        }

        blockPuncher[0][0] = 0;
        Queue<Pair2> queue = new LinkedList<>();
        queue.offer(new Pair2(0,0));

        while (!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){
                Pair2 current = queue.poll();

                int x = current.x;
                int y = current.y;

                for(int j = 0; j < 4; j++){

                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(isValid(nx,ny)){
                        int newBlockPuncher = blockPuncher[x][y] + miro[nx][ny];
                        System.out.println(blockPuncher[x][y]);
                        if (newBlockPuncher < blockPuncher[nx][ny]) {
                            blockPuncher[nx][ny] = newBlockPuncher;
                            queue.offer(new Pair2(nx, ny));
                        }

                    }
                }
            }

        }

        return blockPuncher[N-1][M-1];
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    static class Pair2 {
        int x, y;
        public Pair2(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
<!-- 시간 복잡도는 O(N * M)입니다. 주어진 미로의 크기가 N * M이라고 할 때, BFS 알고리즘을 사용하여 미로의 모든 칸을 최소한 한 번 이상 방문해야 하기 때문에 최악의 경우에 모든 칸을 방문하게 됩니다. 따라서 각 칸을 큐에 넣고 빼는 과정을 수행하는 횟수는 최악의 경우에 N * M번입니다. -->
