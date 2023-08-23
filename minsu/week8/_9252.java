import java.util.*;
import java.io.*;
public class _9252 {
    public static int[][] dp;
    public static char[] A, B;
    public static int length_A, length_B;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        A=br.readLine().toCharArray();
        B=br.readLine().toCharArray();

        length_A=A.length;
        length_B=B.length;

        dp=new int[length_A+1][length_B+1];

        LCS();
        System.out.println(dp[length_A][length_B]);
        ToString();
        System.out.println(sb);
    }
    public static void LCS(){
        for(int i=1;i<=length_A;i++){
            for(int j=1;j<=length_B;j++){
                if(A[i-1]==B[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    public  static void ToString(){
        Stack<Character> st = new Stack<>();
        while (length_A > 0 && length_B > 0) {
            if (dp[length_A][length_B] == dp[length_A - 1][length_B]) {
                length_A--;
            } else if (dp[length_A][length_B] == dp[length_A][length_B - 1]) {
                length_B--;
            } else {
                st.push(A[length_A-1]);
                length_A--;
                length_B--;
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
    }
}
