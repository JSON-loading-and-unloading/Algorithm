//메모리 14260kb 시간 132ms
import java.io.*;
public class _2133 {
    static Integer N;
    static int[] dp;
    static int[] index;


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        dp=new int[Math.max(N/2, 2)];
        if (isOdd(N)) {
            System.out.println(0);
        }else{
            System.out.println(count());
        }
    }
    public static int count(){
        dp[0] = 3;
        dp[1] = 11;
        int tmp = 0;
        for (int i = 2; i < N/2; i++) {
            dp[i] = dp[i-1] * 3 + 2 + (tmp+=dp[i-2]*2);
        }
        return dp[N/2-1];
    }
    public static boolean isOdd(Integer n){
        if(n%2==0)
            return false;
        else
            return true;
    }
}
