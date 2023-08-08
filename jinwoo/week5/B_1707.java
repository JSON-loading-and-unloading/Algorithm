package jinwoo.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1707 {
    static int K;
    static int V;
    static int E;
    static ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
    static int[] colored;  // 0: 방문X, 1과 2로 구분
    static boolean ans=true;
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    K = Integer.parseInt(br.readLine());

    for(int i=0; i<K; i++) {
        // V, E 입력받기
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        makeGraph(br, st);
        ans=true;

        for(int j=0; j<=V; j++){
            colored = new int[V+1];
            dfs(j,2);

            if(!ans) {
                System.out.println("NO");
                break;
            }

            if(ans && j==V) {
                System.out.println("YES");
            }
        }
    }
}
    public static void makeGraph(BufferedReader br, StringTokenizer st) throws IOException {
        
        for(int i=0; i<=V; i++){ 
            edge.add(new ArrayList<Integer>());
        }

        for(int i=0 ; i<E; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
  
        edge.get(u).add(v);
        edge.get(v).add(u); 
        }
    }
    public static void dfs(int v, int c) {
        if(v>V) return;
        if(colored[v]!=0) {
            if(c!=colored[v]) return;
            else{
                ans = false;
                return;
            }
        }
        if(c==1) colored[v] = 2;
        else colored[v] = 1;

        for(int u: edge.get(v)){
            dfs(u, colored[v]);
        }
    }
}
