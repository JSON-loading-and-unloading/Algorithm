import java.util.*;

public class Problem1707 {
    static ArrayList<ArrayList<Integer>> graph;
    static int pink = 2;
    static int orange = -2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start, end;
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            sc.nextLine();
            graph = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < E; j++) {

                start = sc.nextInt();
                end = sc.nextInt();
                sc.nextLine();
                graph.get(start).add(end);
                graph.get(end).add(start);
            }
            String result = logic() ? "YES" : "NO";
            System.out.println(result);
        }
    }


    static public boolean logic() {
        int[] visit = new int[graph.size()];

        for (int i = 1; i < graph.size(); i++) {
            if (visit[i] == 0) {
                if (!bfs(i, visit)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean bfs(int start, int[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = pink;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int daum : graph.get(current)) {
                if (visit[daum] == 0) {
                    queue.offer(daum);
                    visit[daum] = (visit[current] == pink) ? orange : pink;
                } else if (visit[daum] == visit[current]) {
                    return false;
                }
            }
        }

        return true;
    }
}