package week5;

import java.util.*;

public class B_1759 {
    static String[] result;
    static List<String> alphabets;
    static int L;
    static int C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt(); //암호의 길이
        C = sc.nextInt(); //입력받을 알파벳의 개수
        result = new String[L];
        alphabets = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            alphabets.add(sc.next());
        }
        Collections.sort(alphabets);

        getResult(0, 0); // 암호를 구하는 재귀 메서드 호출
    }

    public static void getResult(int start, int cnt) {
        if (cnt == L) { // 암호의 길이에 도달한 경우
            String resultString = Arrays.toString(result).replace(", ", "").replace("[", "").replace("]", "");
            if (getCount(resultString))
                System.out.println(resultString);
            return;
        }

        for (int i = start; i < C; i++) { // 현재까지 선택된 알파벳들 중에서 다음으로 올 수 있는 알파벳들을 선택하도록 반복
            result[cnt] = alphabets.get(i); // 현재 위치에 알파벳을 선택하고
            getResult(i + 1, cnt + 1); // 다음 재귀 호출을 위해 start와 cnt를 조정하여 재귀 호출
        }
        /**
         * cnt = 0 -> alphabets 처음부터 끝까지 모두 넣어봄
         * 첫번째 재귀 호출 -> 두번째 배열 위치에 i+1부터 끝까지 모두 넣어봄
         * 두번째 재귀 호출 -> 세번째 배열 위치에 i+2부터 끝까지 모두
         * 세번째 재귀 호출 -> 네번째 배열 위치에 i+3부터 끝까지 모두
         * 네번째 재귀 호출 -> cnt == L이기에 검사 후 반환
         *
         * 이 과정이 i가 1씩 증가하면서 계속해서 반복 -> 모든 경우의 수 체크
         */
    }

    private static boolean getCount(String result) {
        int vowelCount = 0; // 모음 개수를 저장
        if (result.contains("a")) {
            vowelCount++;
        }
        if (result.contains("e")) {
            vowelCount++;
        }
        if (result.contains("i")) {
            vowelCount++;
        }
        if (result.contains("o")) {
            vowelCount++;
        }
        if (result.contains("u")) {
            vowelCount++;
        }
        if (L - vowelCount < 2 || vowelCount < 1)
            return false;
        return true;
    }
}
