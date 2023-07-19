package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B_2309 {
    static List<Integer> heights = new ArrayList<>();
    static int fakeOne;
    static int fakeTwo;
    public static void main(String[] args) throws IOException {
        /**
         * 9명이 주어짐, 7명의 합 = 100 이됨 -> 7묶음이 여러 종류일 수 있다.
         * 여러종류이면 아무거나 출력 -> 첫번째 결과 출력하자
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int input = Integer.parseInt(br.readLine());
            heights.add(input);
            sum += input;
        }
        int fakeSum = sum - 100;

        getFakeNum(fakeSum);

        for (int i = 0; i < heights.size(); i++) {
            if (i != fakeOne && i != fakeTwo)
                result.add(heights.get(i));
        }
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }

    private static void getFakeNum(int fakeSum) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights.get(i) + heights.get(j) == fakeSum) {
                    fakeOne = i;
                    fakeTwo = j;
                    return;
                }
            }
        }
    }
}
