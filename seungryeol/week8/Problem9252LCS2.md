import java.util.ArrayList;
import java.util.Scanner;

public class Problem9252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String first = sc.nextLine();
        String second = sc.nextLine();

        int[][] array = new int[first.length() + 1][second.length() + 1];

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else {
                    array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }

        int length = array[first.length()][second.length()];


        StringBuilder lcs = new StringBuilder();
        int i = first.length();
        int j = second.length();
        while (i > 0 && j > 0) {
            if (first.charAt(i - 1) == second.charAt(j - 1)) {
                lcs.insert(0, first.charAt(i - 1));
                i--;
                j--;
            } else if (array[i - 1][j] > array[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println(length);
        System.out.println(lcs.toString());


    }

}

