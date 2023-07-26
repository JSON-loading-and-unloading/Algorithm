package jinwoo.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_13913 {
    static int N;
    static int M;
    static int ans;
    static int end;
    static int[] parent = new int[200001]; //부모 저장하기 위한 체크배열
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Arrays.fill(parent, -1);
        bfs();

        int[] ansArr = new int[ans];
        ansArr[ans-1] = end;

        findArr(ansArr);

        for(int i=0; i<ans; i++){
            System.out.print(ansArr[i]+" ");
        }

     }

     public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N); //자신
        queue.offer(0); //부모
        queue.offer(0);
        
        while(!queue.isEmpty()){
            int x = queue.poll();
            int p = queue.poll();
            int d = queue.poll();

            if(x<0 || x>100000) continue;
            if(parent[x]!=-1) continue; //방문한 적 있는 노드는 재방문하지 않는다.

            parent[x] = p;
            p = x;
            
            if(x==M) {
                end = x;
                ans = d+1;
                System.out.println(ans-1);
                break;
            }

            queue.offer(x-1);
            queue.offer(p);
            queue.offer(d+1);

            queue.offer(x+1);
            queue.offer(p);
            queue.offer(d+1);

            queue.offer(x*2);
            queue.offer(p);
            queue.offer(d+1);
        }
     }

     public static void findArr(int[] arr) {
        for(int i=ans-2; i>=0; i--) {
            int temp = parent[end];
            arr[i] = temp;
            end = temp;
        }
     }
}
