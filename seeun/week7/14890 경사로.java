import java.io.*;
import java.util.*;

public class Main {
    private static int n, l;
    private static int[][] map;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            if (check(0,i,1)) {// 행
                cnt++;
            }
            if (check(i,0,0)) { // 열
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean check(int x, int y, int isRow) {

        int[] height = new int[n];
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (isRow == 0) { // 열 체크
                height[i] = map[x][i];
            } else { // 행 체크
                height[i] = map[i][y];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (height[i] == height[i+1]) { // 높이가 같다면 그냥 지나가기
                continue;
            } else if (height[i] - 1 == height[i+1]) { // 내리막
                for (int j = i+1; j < i+1+l; j++) {
                    if (j >= n) { // 경계 벗어날 때
                        return false;
                    }
                    if (visit[j]) { // 이미 지나간 길
                        return false;
                    }
                    if (height[i+1] != height[j]) { // 높이가 다를 때 (낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우)
                        return false;
                    }
                    visit[j] = true;
                }
            } else if (height[i] + 1 == height[i+1]) { // 오르막
                for (int j = i; j > i-l; j--) {
                    if (j < 0) {
                        return false;
                    }
                    if (visit[j]) {
                        return false;
                    }
                    if (height[i] != height[j]) {
                        return false;
                    }
                    visit[j] = true;
                }

            } else {
                return false;
            }
        }
        return true;
    }
}
