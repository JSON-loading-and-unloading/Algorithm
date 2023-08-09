import java.util.*;
import java.io.*;
public class _16935 {
    static int n; // 행 개수
    static int m; // 열 개수
    static int r; // 입력 개수
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<r; i++) {
            int num = Integer.parseInt(st.nextToken());
            solve(num);
        }


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void solve(int num) {
        switch(num) {
            case 1 :
                button1();
                break;
            case 2:
                button2();
                break;
            case 3:
                button3();
                int temp = n;
                n = m;
                m = temp;
                break;
            case 4:
                button4();
                int temp1 = n;
                n = m;
                m = temp1;
                break;
            case 5:
                button5();
                break;
            case 6:
                button6();
                break;
        }
    }

    public static void button1() {//상하 반전
        int[][] temp = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                temp[i][j] = map[n-i-1][j];
            }
        }
        map = temp;
    }

    public static void button2() {//좌우 반전
        int[][] temp = new int[n][m];

        for(int j=0; j<m; j++) {
            for(int i=0; i<n; i++) {
                temp[i][j] = map[i][m-j-1];
            }
        }
        map = temp;
    }

    public static void button3() {//오른쪽으로 90도 회전
        int[][] temp = new int[m][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                temp[j][n-1-i] = map[i][j];
            }
        }
        map = temp;
    }

    public static void button4() { //왼쪽으로 90도 회전
        int[][] temp = new int[m][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                temp[m-j-1][i] = map[i][j];
            }
        }
        map = temp;
    }

    public static void button5() {  // 1->2, 2->3, 3->4, 4->1
        int[][] temp = new int[n][m];
        int x = n/2;
        int y = m/2;

        for(int i = 0; i<x; i++) { //1->2
            for(int j=0; j<y; j++) {
                temp[i][j+y] = map[i][j];
            }
        }
        for(int i = 0; i<x; i++) { //2->3
            for(int j=y; j<m; j++) {
                temp[i+x][j] = map[i][j];
            }
        }
        for(int i = x; i<n; i++) { //3->4
            for(int j=y; j<m; j++) {
                temp[i][j-y] = map[i][j];
            }
        }
        for(int i = x; i<n; i++) { //4->1
            for(int j=0; j<y; j++) {
                temp[i-x][j] = map[i][j];
            }
        }
        map = temp;
    }

    public static void button6() {  // 1->4, 4->3, 3->2, 2->1
        int[][] temp = new int[n][m];
        int x = n/2;
        int y = m/2;

        for(int i = 0; i<x; i++) { //1->4
            for(int j=0; j<y; j++) {
                temp[i+x][j] = map[i][j];
            }
        }
        for(int i = 0; i<x; i++) { //2->1
            for(int j=y; j<m; j++) {
                temp[i][j-y] = map[i][j];
            }
        }
        for(int i = x; i<n; i++) { //3->2
            for(int j=y; j<m; j++) {
                temp[i-x][j] = map[i][j];
            }
        }
        for(int i = x; i<n; i++) { //4->3
            for(int j=0; j<y; j++) {
                temp[i][j+y] = map[i][j];
            }
        }
        map = temp;
    }

}
