package jinwoo.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    public int d; //destination
    public int cost;

    Node(int d, int c) {
        this.d = d;
        this.cost = c;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}

public class B_1916 {

    static ArrayList<ArrayList<Node>> info = new ArrayList<>(); // 연결 정보 저장
    static int[] dist; //시작점에서 각 정점으로 가는 최단거리
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //초기화
        for(int i=0; i<N+1; i++) {
            info.add(new ArrayList<>());
        }

        //단방향 인접리스트 구현
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            info.get(start).add(node);
        }

        dist = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    // 다익스트라 알고리즘
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); //우선순위 큐
        boolean[] check = new boolean[N + 1]; // 방문을 확인하는 체크배열
        pq.offer(new Node(start, 0));
        dist[start] = 0;
 
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.d;
 
            if (!check[cur]) {
                check[cur] = true;
 
                for (Node node : info.get(cur)) {
                    if (!check[node.d] && dist[node.d] > dist[cur] + node.cost) {
                        dist[node.d] = dist[cur] + node.cost;
                        pq.add(new Node(node.d, dist[node.d]));
                    }
                }
            }
        }
        return dist[end];
    }
}
