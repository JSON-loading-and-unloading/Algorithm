package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] houseValues;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        houseValues = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            houseValues[i][0] = Integer.parseInt(st.nextToken());
            houseValues[i][1] = Integer.parseInt(st.nextToken());
            houseValues[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            houseValues[i][0] = Math.min(houseValues[i-1][1], houseValues[i-1][2]) + houseValues[i][0];
            houseValues[i][1] = Math.min(houseValues[i-1][0], houseValues[i-1][2]) + houseValues[i][1];
            houseValues[i][2] = Math.min(houseValues[i-1][0], houseValues[i-1][1]) + houseValues[i][2];
        }

        System.out.println(Math.min(houseValues[n-1][0], Math.min(houseValues[n-1][1], houseValues[n-1][2])));
    }
}
