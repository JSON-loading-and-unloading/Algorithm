package week4;

import java.util.*;

public class B_13913 {
    static int b;
    static int[] dp = new int[100001];
    static int[] path = new int[100001];

    public static void main(String[] args) {
        /**
         * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
         * 수빈이는 걷거나 순간이동을 할 수 있다.
         * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
         * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
         */

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        b = sc.nextInt();
        dp[a] = 0;

        bfs(a);

        System.out.println(dp[b]);

        //그리고 path에 저장된 어디서 왔는가를 스택에 저장하고 스택에서 뽑아서 쓴다.
        Stack<Integer> stack = new Stack<>();
        int current = b;
        while (current != a) {
            stack.push(current);
            current = path[current];
        }
        stack.push(a);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void bfs(int a) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (current == b)
                return;
            int[] move = {current - 1, current + 1, current * 2};

            for (int next : move) {
                if (next < 100001 && next > -1 && dp[next] == 0) {
                    dp[next] = dp[current] + 1;
                    queue.offer(next);
                    path[next] = current;
                }
            }
            /**
             * dp에는 해당 위치까지 이동할때의 횟수를 담는다.
             * queue에 이동할 수 있는 위치를 모두 담는다.
             * path에는 이동할 수 있는 위치에 가는 시점의 현재 값을 담는다.
             *
             * 위로 돌아가서 queue에서 값을 뽑았을 때 b의 위치가 나오면 거기서 끝내고 나온다.
             */
        }
    }
}