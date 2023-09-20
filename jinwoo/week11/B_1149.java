package jinwoo.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1149 {
    public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            cost[i][0] = Integer.parseInt(st.nextToken()); // Red
            cost[i][1] = Integer.parseInt(st.nextToken()); // Green
            cost[i][2] = Integer.parseInt(st.nextToken()); // Blue
        }

        //1부터 N-1 까지 Red, Green, Blue 최솟값의 누적합을 구한다.
        for(int i=1; i<N; i++) {

            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);

        }
        
        int min = Math.min(Math.min(cost[N-1][0], cost[N-1][1]),cost[N-1][2]);

        System.out.println(min);
     }
}
