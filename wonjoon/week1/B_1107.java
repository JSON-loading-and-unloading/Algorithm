package week1;

import java.util.Scanner;

public class B_1107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        int error = sc.nextInt();
        boolean[] errorNum = {false, false, false, false, false, false, false, false, false, false};
        for (int i = 0; i < error; i++) {
            errorNum[sc.nextInt()] = true;
        }

        int plusMinus = Math.abs(inputNum - 100);

        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            boolean stop = false;
            for (int j = 0; j < s.length(); j++) {
                if (errorNum[Integer.parseInt(String.valueOf(s.charAt(j)))]) {
                    stop = true;
                    break;
                }
            }
            if (stop)
                continue;
            count = Math.abs(inputNum - i) + s.length();

            if (count < min)
                min = count;
        }

        if (plusMinus < min)
            min = plusMinus;

        System.out.println(min);
    }
}
/**
 * 완전 탐색을 이용 최적의 경우만 따로 가정해서 진행하려 하였으나 경우의수가 너무 많아져서 안됨,,
 * 0~999999 까지 누를 수 있는 모든 경우에서 버튼 클릭이 가능한 경우 모두 눌러보면서 최소값을 찾는다.
 * 그리고 단순히 +,-로 이동했을 때 값과 비교해서 최소값을 출력한다.
 */