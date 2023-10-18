package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] polygon = new long[n+1][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            polygon[i][0] = Long.parseLong(st.nextToken());
            polygon[i][1] = Long.parseLong(st.nextToken());
        }
        polygon[n][0] = polygon[0][0];
        polygon[n][1] = polygon[0][1];

        double size = 0;
        long a = 0;
        long b = 0;
        for (int i = 0; i < n; i++) {
            a += polygon[i][0]*polygon[i+1][1];
            b += polygon[i][1]*polygon[i+1][0];
        }

        size = Math.abs(a-b)/2.0;

        System.out.println(String.format("%.1f", size));
//        System.out.println(size);
    }
}
