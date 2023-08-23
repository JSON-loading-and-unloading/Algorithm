package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_9252 {
    /**
     * 첫번째 두번째 입력 dp이용
     * 0 1 2 3 4 5 6 ...
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * .
     * .
     * .
     * 각 위치마다 같은지 체크하여 같으면 dp[first-1][second-1]+1 저장
     * 다르다면 Dp[first-1][second] dp[first][second-1] 비교 후 큰거 저장
     */
    static int[][] dp;
    static int n1;
    static int n2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        lcs(first,second);
        getLCSToString(first, first.length(), second.length());


    }

    static void lcs (String first, String second) {
        n1 = first.length();
        n2 = second.length();

        dp = new int[n1+1][n2+1];
        for(int i=1; i<=n1; i++) {
            for(int j=1; j<=n2; j++) {
                if(first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n1][n2]);
    }

    static void getLCSToString(String first, int i, int j) {
        Stack<Character> st = new Stack<>();

        while(i>0 && j>0) {

            if(i == 0 || j ==0)break;

            if(dp[i][j] == dp[i-1][j]) {
                i--;
            }else if(dp[i][j] == dp[i][j-1]) {
                j--;
            }else {
                st.push(first.charAt(i-1));
                i--;
                j--;
            }


        }
        while(!st.isEmpty()) {
            System.out.print(st.pop());
        }


    }
}
