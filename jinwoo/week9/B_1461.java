package jinwoo.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class B_1461 {
    static int N, M;
    static ArrayList<Integer> minus = new ArrayList<>(); 
    static ArrayList<Integer> plus = new ArrayList<>();
    static int steps = 0;
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        minus.add(0); //패딩값(예외처리)
        plus.add(0);

        for(int i=0; i<N; i++) {
            int b = Integer.parseInt(st.nextToken());

            if(b<0) minus.add(Math.abs(b));
            else plus.add(b);
        }

        Collections.sort(minus);
        Collections.sort(plus);

        minus.add(0);
        plus.add(0);

        getMinusSteps();
        getPlusSteps();

        int max = Math.max(plus.get((plus.size()-2)),minus.get(minus.size()-2));
        steps -= max;

        System.out.println(steps);
    }

    public static void getMinusSteps(){
        int x = (minus.size()-2) / M;
        int y = (minus.size()-2) % M;

        for(int i=1; i<=x; i++) {
            steps += minus.get((y+(M*i))) * 2;
        }

        steps += 2*minus.get(y);
    }

    public static void getPlusSteps(){
        int x = (plus.size()-2) / M;
        int y = (plus.size()-2) % M;

        for(int i=1; i<=x; i++) {
            steps += plus.get((y+M*i)) * 2;
        }

        steps += 2*plus.get(y);
    }
}
