import java.io.*;
import java.util.*;

public class _17142 {
    public static int N, M, zeroNum, ans;
    public static int[][] input;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static ArrayList<Node> virus;


    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        input=new int[N][N];
        ans=Integer.MAX_VALUE;
        virus=new ArrayList<>();
        zeroNum=0;

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                input[i][j]=Integer.parseInt(st.nextToken());
                if(input[i][j]==2){
                    virus.add(new Node(i,j));
                }else if(input[i][j]==0){
                    zeroNum++;
                }
            }
        }

        dfs(0,0,new int[M]);

        if(ans==Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    public static void dfs(int start, int depth, int[] arr){
        if(depth==M){
            int time=bfs(arr);
            if(time!=-1){
                ans=Math.min(ans,time);
            }
            return;
        }
        for(int i=start;i< virus.size();i++){
            arr[depth]=i;
            dfs(i+1,depth+1,arr);
        }
    }
    public static int bfs(int[] str){
        Queue<Node> que=new LinkedList<>();
        boolean[][] visited=new boolean[N][N];

        for(int i:str){
            Node node=virus.get(i);
            node.time=0;
            visited[node.x][node.y]=true;
            que.add(node);
        }

        int time=0;
        int cnt = 0;
        while(!que.isEmpty()) {
            Node node = que.poll();
            for(int d=0;d<4;d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];
                if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if(!visited[nx][ny]) {
                        if(input[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            cnt++;
                            time = Math.max(time, node.time+1);
                            que.add(new Node(nx, ny, node.time+1));
                        } else if(input[nx][ny] == 2){
                            visited[nx][ny] = true;
                            que.add(new Node(nx, ny, node.time+1));
                        }
                    }
                }
            }
        }

        if(cnt != zeroNum) return -1;

        return time;


    }

    public static class Node {
        private int x;
        private int y;
        private int time;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

}
