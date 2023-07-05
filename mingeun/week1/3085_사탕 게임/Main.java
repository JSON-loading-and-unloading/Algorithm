import java.util.*;
import java.io.*;

// 3085: 사탕 게임
// O(N^4), N <= 50, 204ms
// 14852KB
public class Main{
    static int N, result;
    static char[][] candies;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        N = Integer.parseInt(br.readLine());
        candies = new char[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; i < N; i++){
                candies[i] = br.readLine().toCharArray();
            }
        }

        char temp;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (j + 1 < N && candies[i][j] != candies[i][j + 1]) { // -> 방향으로 스왑 후 체크 후 복구
                    temp = candies[i][j];
                    candies[i][j] = candies[i][j + 1];
                    candies[i][j + 1] = temp;

                    result = Math.max(result, countCandies(candies));

                    temp = candies[i][j];
                    candies[i][j] = candies[i][j + 1];
                    candies[i][j + 1] = temp;
                }

                if (i + 1 < N && candies[i][j] != candies[i + 1][j]) { // 아래 방향으로 스왑 후 체크 후 복구
                    temp = candies[i][j];
                    candies[i][j] = candies[i + 1][j];
                    candies[i + 1][j] = temp;

                    result = Math.max(result, countCandies(candies));

                    temp = candies[i][j];
                    candies[i][j] = candies[i + 1][j];
                    candies[i + 1][j] = temp;
                }

                if (result == N) {
                    bw.write(String.valueOf(result));
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

    public static int countCandies(char[][] candies){
        int max_sum = 0;

        for (int i = 0; i < N; i++){ // 가로 줄로 보기
            int sum = 1;
            for (int j = 1; j < N; j++){
                if (candies[i][j] == candies[i][j - 1]){
                    sum += 1;
                }
                else {
                    sum = 1;
                }

                if (sum == N){
                    return sum;
                }
                
                max_sum = Math.max(max_sum, sum);
            }
            
        }

        for (int i = 0; i < N; i++){ // 세로 줄로 보기
            int sum = 1;
            for (int j = 1; j < N; j++){
                if (candies[j][i] == candies[j - 1][i]){
                    sum += 1;
                }
                else {
                    sum = 1;
                }

                if (sum == N){
                    return sum;
                }
                
                max_sum = Math.max(max_sum, sum);
            }

        }

        return max_sum;
    }

}