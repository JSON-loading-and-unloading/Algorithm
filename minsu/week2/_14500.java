// 메모리 176596kb	시간 1280ms, 시간 복잡도 O(n^2)

import java.util.*;
public class _14500 {
    static int ans, n, m;
    static int[][] map;
    static int dx[]={-1,0,1,0};
    static int dy[]={0,-1,0,1};
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        map=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=sc.nextInt();
            }
        }

        visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j]=false;
                check(i,j);
            }
        }
        System.out.println(ans);
    }

    public static void dfs(int y, int x, int cnt, int sum){
        if(cnt>=4){
            ans=Math.max(ans, sum);
            return;
        }
        for(int k=0;k<4;k++){
            int ny=y+dy[k];
            int nx=x+dx[k];

            if(ny<0||nx<0||ny>=n||nx>=m||visited[ny][nx])
                continue;

            visited[ny][nx]=true;
            dfs(ny, nx, cnt+1, sum+map[ny][nx]);
            visited[ny][nx]=false;
        }
    }

    public static void check(int y, int x){
        if (y < n - 2 && x < m - 1)
            ans = Math.max(ans, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]);

        if (y < n - 2 && x > 0)
            ans = Math.max(ans, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1]);

        if (y < n - 1 && x < m - 2)
            ans = Math.max(ans, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);

        if (y > 0 && x < m - 2)
            ans = Math.max(ans, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1]);
    }
}
