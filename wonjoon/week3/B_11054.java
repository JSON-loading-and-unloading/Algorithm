package week3;

import java.util.Scanner;

public class B_11054 {
    static int[] seq;
    static int[] upDp;
    static int[] downDp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int max = 0;
        seq = new int[length];
        upDp = new int[length];
        downDp = new int[length];

        for (int i = 0; i < length; i++) {
            seq[i] = sc.nextInt();
            upDp[i] = 1;
            downDp[i] = 1;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && upDp[i] <= upDp[j]) {
                    upDp[i] = upDp[j]+1;
                }
            }
        }

        for (int i = length-1; i >= 0; i--) {
            for (int j = length-1; j > i; j--) {
                if (seq[j] < seq[i] && downDp[i] <= downDp[j]) {
                    downDp[i] = downDp[j]+1;
                }
            }

            if (max < upDp[i] + downDp[i] -1)
                max = upDp[i] + downDp[i] -1;
        }

        System.out.println(max);
    }
}
