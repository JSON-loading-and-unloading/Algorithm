package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11404 {
    static int n;
    static int bus;
    static long adjMat[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());
        adjMat = new long[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    adjMat[i][j] = 0;
                    continue;
                }
                adjMat[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (adjMat[a][b] > c)
                adjMat[a][b] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j)
                        continue;
                    if (adjMat[i][k] != Integer.MAX_VALUE && adjMat[k][j] != Integer.MAX_VALUE) {
                        if (adjMat[i][j] > (adjMat[i][k] + adjMat[k][j]))
                            adjMat[i][j] = (adjMat[i][k] + adjMat[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (adjMat[i][j] == Integer.MAX_VALUE)
                    adjMat[i][j] = 0;
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
