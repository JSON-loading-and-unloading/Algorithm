package week5;

import java.util.*;

public class B_1707 {
    /**
     * 그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때,
     * 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
     *
     * 그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.
     */
    static ArrayList<Integer>[] graphs;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int node = sc.nextInt();
            int edge = sc.nextInt();
            graphs = new ArrayList[node+1];
            dp = new int[node+1];
            Arrays.fill(dp, Integer.MAX_VALUE);

            for (int k = 0; k < node+1; k++) {
                graphs[k] = new ArrayList<>();
            }
            for (int j = 0; j < edge; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                graphs[start].add(end);
                graphs[end].add(start);
            }
            boolean check = true;
            for (int l = 1; l <= node; l++) {
                if (dp[l] == Integer.MAX_VALUE) {
                    if (!check(l, 0)) {
                        check = false;
                        break;
                    }
                }
            }

            if (check) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }

    static boolean check(int node, int color) {
        dp[node] = color;
        for (int next : graphs[node]) {
            if (dp[next] == Integer.MAX_VALUE) {
                if (!check(next, 1 - color)) {
                    return false;
                }
            } else if (dp[next] == color) {
                return false;
            }
        }
        return true;
    }
}

