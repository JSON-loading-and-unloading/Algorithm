package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14391 {
    static int N;
    static int M;
    static int max = 0;
    static int[][] board;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int x, int y) {
        if(x==N) {	//종이 조각내는 것 완성시 조각난 종이 합 구하기
            sum();
            return;
        }
        if(y==M) {	//해당 행 완료시 다음 행으로 이동
            dfs(x+1,0);
            return;
        }
        check[x][y] = true;		//가로로 잘랐을 때
        dfs(x,y+1);

        check[x][y] = false;	//세로로 잘랐을 때
        dfs(x,y+1);
    }

    public static void sum() {
        int result = 0;
        int temp;
        for(int i=0; i<N; i++) {	//가로 합, 행 기준 탐색
            temp = 0;
            for(int j=0; j<M; j++) {
                if(check[i][j]) {	//가로로 자른 값 연속할 때
                    temp *= 10;
                    temp += board[i][j];
                }else {		//세로로 자른 값 만났을 때
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;
        }
        for(int i=0; i<M; i++) {	//세로 합, 열 기준 탐색
            temp = 0;
            for(int j=0; j<N; j++) {
                if(!check[j][i]) {	//세로로 자른 값 연속할 때
                    temp *= 10;
                    temp += board[j][i];
                }else {		//가로로 자른 값 만났을 때
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;
        }
        max = Math.max(max, result);		//최대값 비교
    }
}
