package jinwoo.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    public int min;
    public int max;

    Node(int v) {
        this.min = v;
        this.max = v;
    }
}
public class B_2096 {
       public static void main(String[] args) throws IOException{
        
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Node[][] score = new Node[N][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            score[i][0] = new Node(first); 
            score[i][1] = new Node(second);
            score[i][2] = new Node(third);
        }

        //1부터 N-1 까지 최댓값과 최솟값의 누적합을 구한다.
        for(int i=1; i<N; i++) {
            score[i][0].max += Math.max(score[i-1][0].max, score[i-1][1].max);
            score[i][1].max += Math.max(Math.max(score[i-1][1].max, score[i-1][2].max), score[i-1][0].max);
            score[i][2].max += Math.max(score[i-1][2].max, score[i-1][1].max);

            score[i][0].min += Math.min(score[i-1][0].min, score[i-1][1].min);
            score[i][1].min += Math.min(Math.min(score[i-1][1].min, score[i-1][2].min), score[i-1][0].min);
            score[i][2].min += Math.min(score[i-1][2].min, score[i-1][1].min);
        }
        
        int max = Math.max(Math.max(score[N-1][0].max, score[N-1][1].max),score[N-1][2].max);
        int min = Math.min(Math.min(score[N-1][0].min, score[N-1][1].min),score[N-1][2].min);

        System.out.print(max+" "+min);
     }
}
