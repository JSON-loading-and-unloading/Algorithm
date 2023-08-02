import java.io.*;
import java.util.*;

// 시간 복잡도 O(C^L) , 메모리 14304KB
public class Main {

    public static int L, C;
    public static char[] alpha;
    public static char[] code;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());//서로 다른 L개의 알파벳 소문자로 구성되는 암호 
        C = Integer.parseInt(st.nextToken());//C개의 문자

        alpha = new char[C]; // 알파벳 담는 배열
        code = new char[L]; // 암호 만드는 배열

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }


        // 정렬
        Arrays.sort(alpha);

        // 암호 만들기 시작. 처음에는 0개의 알파벳을 골랐고, 가장 처음부터 시작하므로 (0,0)
        makeCode(0,0);

    }

    public static void makeCode(int x,int idx) {

        // L개의 알파벳을 다 골랐을 때 
        if (idx == L) {
            // 최소 한개의 모음, 최소 2개의 자음인지 확인
            if (isSuccess()) {
                System.out.println(code);
            }
            return;
        }

        // 재귀 사용
        for (int i = x; i < C; i++) {
            code[idx] = alpha[i]; // 알파벳 하나 선택해 배열에 넣기
            makeCode(i+1, idx + 1); // 그 다음으로 넘어가기. 위치는 현 위치 다음으로, 
            // 배열에 넣었기 때문에, 알파벳 고른 횟수도 +1
        }
    }

    // 최소 모음 1개, 최소 자음 2개인지 확인
    public static boolean isSuccess() {
        int vowel = 0;
        int consonant = 0;

        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        if (vowel >= 1 && consonant >= 2) {
            return true;
        }
        return false;
    }

}