import java.util.*;
import java.io.*;

// 1107: 리모컨
// O(M * 999999), M <= 10, 324ms
// 66304KB

public class Main {
    static int N, M, min = 100000000;
    static String[] broken;
    static String buf;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if (M == 0) { // 고장난 버튼이 없는 경우
            min = String.valueOf(N).length();
        }
        
        else { // 고장난 버튼이 있는 경우
            buf = br.readLine();
            broken = new String[M];

            StringTokenizer st = new StringTokenizer(buf, " ");

            for (int i = 0; i < M; i++){
                broken[i] = st.nextToken();
            }
            
            ext: for (int i = 0; i <= 999999; i++){
                String temp = String.valueOf(i);
                for (String s: broken){
                    if (temp.contains(s)){
                        continue ext;
                    }
                }
                min = Math.min(min, Math.abs(i - N) + temp.length());
            }
        }

        min = Math.min(min, Math.abs(100 - N)); // 100에서 이동하는 경우랑 비교

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

}