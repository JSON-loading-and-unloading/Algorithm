import java.io.*;
import java.util.*;

public class _1707 {
    public static int K, V, E;
    public static List<Integer>[] adjList;
    public static int[] color; //color이 0이면 미지정이고 1또는 2만 가질 수 있음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adjList = new List[V + 1];
            for (int v = 0; v <= V; v++) {
                adjList[v] = new ArrayList<>();
            }

            color = new int[V + 1];
            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
                adjList[to].add(from);
            }

            for (int v = 1; v <= V; v++) {
                if (color[v] == 0) { //0이면 그룹 미지정이므로
                    dfs(v, 1);
                }
            }

            if (isBipartite()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void dfs(int node, int c) {
        color[node] = c;
        for (int next : adjList[node]) {
            if (color[next] == 0) { //인접한 노드가 미지정이면
                dfs(next, 3 - c); //다른 그룹에 배정
            }
        }
    }

    public static boolean isBipartite() {
        for (int i = 1; i <= V; i++) {
            for (int j : adjList[i]) {
                if (color[i] == color[j]) { //인접한 노드와 같은 그룹이면 이분 그래프 아님
                    return false;
                }
            }
        }
        return true;
    }
}
