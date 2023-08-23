import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class Problem2467 {
    static int amount;
    static int[] waterValue;
    int resultNum1 = 0, resultNum2 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = MAX_VALUE;
        int value;
        int resultNum1 = 0, resultNum2 = 0;


        amount = sc.nextInt();

        waterValue = new int[amount];
        sc.nextLine();

        for(int i = 0; i < amount; i++){
            waterValue[i] = sc.nextInt();
        }

        int left = 0;
        int right = amount - 1;
        int minSum = Integer.MAX_VALUE;


        while (left < right) {
            int sum = waterValue[left] + waterValue[right];

            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                resultNum1 = waterValue[left];
                resultNum2 = waterValue[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.print(resultNum1 +" " +resultNum2);

    }
}