import java.util.*;
import java.io.*;

// 1476: 날짜 계산
// O(N), N <= 15 * 28 * 19, 124ms
// 14236KB
public class Main{
    static int E, S, M, result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (E == 15){
            E = 0;
        }

        if (S == 28){
            S = 0;
        }

        if (M == 19){
            M = 0;
        }

        for (int i = 1; i <= 7980; i++){
            if (i % 15 == E && i % 28 == S && i % 19 == M){
                result = i;
                break;
            }
        }
        
        /* 연도를 N이라고 가정했을 때
            N = 15 * X + E
            N = 28 * Y + S
            N = 19 * Z + M */
       
       bw.write(String.valueOf(result));
       bw.flush();
       bw.close();
    }
}