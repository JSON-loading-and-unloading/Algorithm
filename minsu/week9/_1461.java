import java.io.*;
import java.util.*;

public class _1461 {
    static int N, M, answer, max;
    static List<Integer> minus, plus;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);        // 책의 개수
        M = Integer.parseInt(input[1]);        // 한 번에 들 수 있는 책의 개수

        plus = new ArrayList<>();
        minus = new ArrayList<>();

        String[] positions = br.readLine().split(" ");
        for (String pos : positions) {
            int num = Integer.parseInt(pos);

            // 가장 멀리 있는 책의 위치를 찾는다.
            max = Math.max(max, Math.abs(num));

            if (num > 0) {
                plus.add(num);
            } else {
                minus.add(Math.abs(num));  // 음수 위치는 절댓값으로 저장
            }
        }

        // 내림차순 정렬
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        // 양수 위치의 책들을 처리
        for (int i = 0; i < plus.size(); i += M) {
            if (plus.get(i) == max) {
                answer += plus.get(i);
            } else {
                answer += (plus.get(i) * 2);
            }
        }

        // 음수 위치의 책들을 처리
        for (int i = 0; i < minus.size(); i += M) {
            if (minus.get(i) == max) {
                answer += minus.get(i);
            } else {
                answer += (minus.get(i) * 2);
            }
        }

        System.out.println(answer);
    }
}

