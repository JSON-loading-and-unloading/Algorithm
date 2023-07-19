package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1476 {
    /**
     * 연도 -> 숫자 3개
     * E, S, M
     * (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
     * 1년은 1 1 1
     * 이후 1년이 지날때마다 1씩 증가
     * 15년은
     * 15 15 15
     * 16년은
     * 1 16 16
     *
     * 입력 3개 = 15나머지 28나머지 19나머지
     * 그중 만족하는 가장 첫번째 숫자
     */
    public static void main(String[] args) throws IOException {
        int e = 15;
        int s = 28;
        int m = 19;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] threeYears = input.split(" ");
        boolean plusYear = true;
        int year = 0;
        while (plusYear) {
            year++;

            int eYear = year % e;
            if (eYear == 0)
                eYear = 15;

            int sYear = year % s;
            if (sYear == 0)
                sYear = 28;

            int mYear = year % m;
            if (mYear == 0)
                mYear = 19;

            if (eYear == Integer.parseInt(threeYears[0]) && sYear == Integer.parseInt(threeYears[1]) && mYear == Integer.parseInt(threeYears[2]))
                plusYear = false;
        }

        System.out.println(year);
    }
}
