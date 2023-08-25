package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2467 {
    static int n;
    static int[] liquids;
    static int left = 0;
    static int right;
    static int min = Integer.MAX_VALUE;
    static int minIndex[] = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        right = n-1;
        liquids = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquids);

        check();

        System.out.println(liquids[minIndex[0]] + " " + liquids[minIndex[1]]);
    }

    static void check() {
        while(true) {
            if (Math.abs(liquids[left] + liquids[right]) < min) {
                min = Math.abs(liquids[left] + liquids[right]);
                minIndex[0] = left;
                minIndex[1] = right;
            }
            if ((liquids[left] + liquids[right]) == 0)
                return;
            if ((liquids[left] + liquids[right]) > 0) {
                if (left + 1 == right) {
                    return;
                }
                right--;
                continue;
            }
            if ((liquids[left] + liquids[right]) < 0) {
                if (left + 1 == right) {
                    return;
                }
                left++;
            }
        }
    }
}
