import java.util.*;
import java.io.*;

// 11054: 가장 긴 바이토닉 부분 수열
// O(N^2), N <= 1000, 164ms 
// 14828KB

public class Main{
    static int N;
    static int[] A, dp1, dp2;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp1 = new int[N];
        dp2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < i; j++){

                if (A[j] < A[i] && dp1[i] < dp1[j] + 1){
                    dp1[i] = dp1[j] + 1;
                }

            }
        }

        for (int i = N - 1; i >= 0; i--){
            for (int j = N - 1; j > i; j--){

                if (A[j] < A[i] && dp2[i] < dp2[j] + 1){
                    dp2[i] = dp2[j] + 1;
                }

            }
        }

        int max = 0;
        for (int i = 0; i < N; i++){
            max = Math.max(max, dp1[i] + dp2[i]);
        }
        
        bw.write(String.valueOf(max - 1));
        bw.flush();
        bw.close();

        // for (int num: A){
        //     System.out.println(num);
        // }
    }
}