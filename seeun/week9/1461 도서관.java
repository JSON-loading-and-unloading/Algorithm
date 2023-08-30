import java.util.*;
import java.io.*;

public class Main {
    static int end = 0;
    static int step = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 최소 걸음 수를 구하기 때문에 위치가 - 인 곳과 위치가 + 인곳을 따로 나눠서 체크 
        // 위치가 -인 책과 +인 책을 같이 들고 다니면 어짜피 0을 지나게 되어있어 한번에 처리하는 의미가 없다
        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Collections.reverseOrder()); 
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num >= 0) plusQ.add(num);
            else minusQ.add(Math.abs(num));
        }
        
        // 가장 멀리 있는 곳을 찾기. 가장 멀리 있는 곳은 가장 나중에 처리하는 게 좋다
        // 다시 0으로 돌아올 필요가 없기 때문
        if(plusQ.isEmpty()) 
            end = minusQ.peek();
        else if(minusQ.isEmpty())
            end = plusQ.peek();
        else{
            end = Math.max(minusQ.peek(), plusQ.peek());
        }
        
        while(!plusQ.isEmpty()){
            step += plusQ.peek()*2; 
            for(int i = 0; i < m; i++) plusQ.poll(); // 가장 먼곳으로 이동해 책을 한번에 처리
        }
        
        while(!minusQ.isEmpty()){
            step += minusQ.peek()*2;
            for(int i = 0; i < m; i++) minusQ.poll(); // 가장 먼곳으로 이동해 책을 한번에 처리
        }
        
        step -= end; // 마지막에 가장 먼 곳에서 끝나면 0 지점으로 돌아갈 필요가 없기 때문에 다시 빼주기 
        System.out.println(step);

    }
}