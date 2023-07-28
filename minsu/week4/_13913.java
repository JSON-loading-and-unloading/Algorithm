import java.util.*;

public class _13913 {
    static int[] before = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first, second;

        first = sc.nextInt();
        second = sc.nextInt();
        if (first == second) {
            System.out.println(0);
            System.out.println(first);
        } else {
            System.out.println(bfs(first, second));
            StringBuilder sb = new StringBuilder(); // 결과 저장
            Stack<Integer> stack = new Stack<>();
            int after = second; // 뒤에서부터 왔던길 찾아가기
            while (after != first) {
                stack.push(after);
                after = before[after];
            }
            stack.push(first);

            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            System.out.println(sb.toString());
        }

    }

    public static int bfs(int start, int end) {
        int count = 0;
        boolean[] visited = new boolean[100001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int size = q.size();


        while (true) {
            count++;
            size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                visited[x] = true;
                if (x - 1 == end || x + 1 == end || 2 * x == end) {
                    before[end] = x;
                    return count;
                }
                if (x - 1 >= 0 && !visited[x - 1]) {
                    visited[x - 1] = true;
                    q.add(x - 1);
                    before[x - 1] = x;
                }
                if (x + 1 <= 100000 && !visited[x + 1]) {
                    visited[x + 1] = true;
                    q.add(x + 1);
                    before[x + 1] = x;
                }
                if (2 * x <= 100000 && !visited[2 * x]) {
                    visited[2 * x] = true;
                    q.add(2 * x);
                    before[x * 2] = x;
                }
            }
        }
    }
}
