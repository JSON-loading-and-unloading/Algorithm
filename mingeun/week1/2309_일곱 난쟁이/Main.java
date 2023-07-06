import java.util.*;
import java.io.*;

// 2309: 일곱 난쟁이
// O(N^2), N <= 9, 124ms
// 14220KB
public class Main {
    static int[] height = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int sum = 0;
        for (int i = 0; i < 9; i++){
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        ext: for (int i = 0; i < 9; i++){
            for (int j = i + 1; j < 9; j++){
                if (sum - height[i] - height[j] == 100){
                    height[i] = 0;
                    height[j] = 0;
                    Arrays.sort(height);
                    break ext;
                }
            }
        }

        for (int i = 2; i < 9; i++){
            bw.write(String.valueOf(height[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}