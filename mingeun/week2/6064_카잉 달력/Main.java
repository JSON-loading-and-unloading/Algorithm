import java.util.*;
import java.io.*;

// 6064: 카잉 달력
// O(T * N), N <= 40000, 340ms 
// 19660KB

public class Main{
    static int T, M, N, x, y;
    static int[] result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        result = new int[T];
        ext: for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // M * A + x = N * B + y = k

            if (y == N) {
                y = 0;
            }

            for (int j = x; j <= M * N; j += M){
                if (j % N == y) {
                    result[i] = j;
                    continue ext;
                }
            }
            result[i] = -1;
        }

        for (int val: result){
            bw.write(String.valueOf(val) + "\n");
        }

        bw.flush();
        bw.close();
    }
}