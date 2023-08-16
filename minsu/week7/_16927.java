import java.util.*;
import java.io.*;
public class _16927 {
    public static int N; //행 개수
    public static int M; //열 개수
    public static int R; //회전 개수
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map=new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int startCol = 0;
        int endCol = M - 1;
        int startRow = 0;
        int endRow = N - 1;
        while (true) {
            int size = (endRow - startRow + 1) * 2 + (endCol - startCol + 1) * 2 - 4;
            rotate(startCol, endCol, startRow, endRow, R % size);
            startCol += 1;
            startRow += 1;
            endCol -= 1;
            endRow -= 1;
            if (startRow > endRow || startCol > endCol)
                break;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void rotate(int startCol, int endCol, int startRow, int endRow, int cnt) {
        for (int k = 0; k < cnt; k++) {
            int temp = map[startRow][startCol];

            for (int i = startCol; i < endCol; i++) { //맨 윗줄, 왼쪽으로 이동
                map[startRow][i] = map[startRow][i + 1];
            }
            for (int j = startRow; j < endRow; j++) { //맨 오른쪽, 위쪽으로 이동
                map[j][endCol] = map[j + 1][endCol];
            }
            for (int i = endCol; i > startCol; i--) { //맨 아랫줄, 오른쪽으로 이동
                map[endRow][i] = map[endRow][i - 1];
            }
            for (int j = endRow; j > startRow; j--) { //맨 왼쪽, 아럐쪽으로 이동
                map[j][startCol] = map[j - 1][startCol];
            }
            map[startRow + 1][startCol] = temp;
        }
    }
}
