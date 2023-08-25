import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class _2467 {
    public static int N;
    public static int[] input;
    public static long[] result=new long[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        input=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            input[i]=Integer.parseInt(st.nextToken());
        }

        mix();

        for(int i=0;i<2;i++) {
            System.out.print(result[i]+" ");
        }
    }
    public static void mix(){
        int leftPoint=0;
        int rightPoint=N-1;
        long min=Long.MAX_VALUE;
        while(leftPoint<rightPoint){
            long temp=input[leftPoint]+input[rightPoint];
            if(Math.abs(temp)<min){
                min=Math.abs(temp);
                result[0]=input[leftPoint];
                result[1]=input[rightPoint];
            }
            if(temp>=0)
                rightPoint--;
            else
                leftPoint++;
        }
    }
}
