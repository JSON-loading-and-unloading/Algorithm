import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] parent;
    private static PriorityQueue<Node> pq;

    private static class Node implements Comparable<Node>{
        int a, b, c;

        Node(int a ,int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Node n) {
            if(this.c > n.c){
                return 1;
            }else if(this.c < n.c){
                return -1;
            }else {
                return 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        parent = new int[n+1];

        for (int i = 0; i < n+1; i++) {
               parent[i] =i;
        }

        for (int i = 0; i < m; i++) {
            st= new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Node(a, b, c));
        }

        int cnt = n-1;
        int ans  = 0;
        int lastWeight = 0; // 제일 마지막에 추가되는 간선의 가중치

        while (cnt > 0){
            Node n = pq.poll();
            
            if(union(n.a, n.b)){
                ans += n.c;
                cnt--;
            }

            if(cnt == 0) lastWeight = n.c; // 마지막 가중치 저장
        }

        // 마지막 가중치 제거 후 출력
        System.out.println(ans - lastWeight);
    }

    private static boolean union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);

        if(root1 == root2) return false;

        if(root1 < root2){
            parent[root1] = root2;
        }else{
            parent[root2] = root1;
        }
        return true;
    }

    private static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return find(parent[a]);
    }
}