//메모리 14448kb, 시간 168ms

import java.util.*;
import java.io.*;
public class _11054 {
    static int N;
    static int[] seq;
    static int[] l_dp;
    static int[] r_dp;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        seq=new int[N];
        l_dp=new int[N];
        r_dp=new int[N];
        dp=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }
        LDP();
        RDP();

        int max=-1;
        for(int i=0;i<N;i++){
            dp[i]=l_dp[i]+r_dp[i]-1;
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);

    }

    public static void LDP(){
        for(int i=0;i<N;i++){
            l_dp[i]=1;
            for(int j=0;j<i;j++){
                if(seq[j]<seq[i]&&l_dp[i]<l_dp[j]+1){
                    l_dp[i]=l_dp[j]+1;
                }
            }
        }
    }

    public static void RDP(){
        for(int i=N-1;i>=0;i--){
            r_dp[i]=1;
            for(int j=N-1;j>=i;j--){
                if(seq[j]<seq[i]&&r_dp[i]<r_dp[j]+1)
                    r_dp[i]=r_dp[j]+1;
            }
        }
    }
}
