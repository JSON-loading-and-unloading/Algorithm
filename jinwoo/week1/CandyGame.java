package jinwoo.week1;

import java.util.Scanner;

public class CandyGame {
    // 메모리 : 13216 KB, 시간복잡도 : N^3
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int max = 1;
    static char[][] candy = new char[N][N];

    public static void main(String[] args) {

        for(int i = 0; i<N ; i++){
            String s = sc.next();
            for (int j = 0; j<N; j++){
                candy[i][j] = s.charAt(j);
            }
        }

        // 행 기준으로 오른쪽 값과 바꾸기
        for (int i = 0; i < N; i++){
            for(int j = 0; j < N-1; j++){
                swap(i,j,i,j+1);
                search();
                swap(i,j+1,i,j); // 다시 되돌리기
            }
        }

        if(max != N){
             //열 기준으로 아래쪽 값과 바꾸기
            for(int i=0 ; i < N; i++){
                for(int j=0; j<N-1; j++){
                    swap(j,i,j+1,i);
                    search();
                    swap(j+1,i,j,i);
                }
            }
        }

        System.out.println(max);

        sc.close();
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = candy[x1][y1];
        candy[x1][y1] = candy[x2][y2];
        candy[x2][y2] = temp;
    }

    public static void search() {

        // 행에서 최댓값 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (candy[i][j] == candy[i][j + 1]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }

        // 열에서 최댓값 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (candy[j][i] == candy[j + 1][i]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }
    }
}
