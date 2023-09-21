package jinwoo.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2458 {
    static ArrayList<ArrayList<Integer>> tall = new ArrayList<>(); // 자신보다 큰 사람 저장
    static ArrayList<ArrayList<Integer>> small = new ArrayList<>(); // 자신보다 작은 사람 저장
    static boolean[] chk; // 방문했는지 체크하는 배열
    static int cnt = 0; // 자신보다 키가 크고 작은 학생 카운트
    static int ans = 0; // 자신의 키가 몇 번째인지 알 수 있는 학생 카운트

    public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N+1; i++) { // 초기화
            tall.add(new ArrayList<>());
            small.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) { // 자기보다 크고 작은 사람 저장
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            small.get(v).add(u);
            tall.get(u).add(v);
        }

        chk = new boolean[N+1];

        for(int i=1; i<N+1; i++) {
            
            Arrays.fill(chk, false);
            dfs(i, small);
            Arrays.fill(chk, false);
            dfs(i, tall);

            if(cnt-1 == N) ans ++; // 중복 카운트 제거

            cnt = 0;
        }

        System.out.println(ans);
    }

    public static void dfs(int x, ArrayList<ArrayList<Integer>> findArr) {
        
        if(chk[x]) return;
        chk[x] = true;
        cnt ++;

        if(findArr.get(x).isEmpty()) return;

        for(int i=0; i<findArr.get(x).size(); i++) {
            dfs(findArr.get(x).get(i), findArr);
        }
        
    }
}
