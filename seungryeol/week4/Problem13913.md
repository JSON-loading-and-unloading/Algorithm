import java.util.*;


public class Problem13913 {
    static int start;
    static int finish;
    static ArrayList<Integer> distance = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int now;
    static int[] calNows;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        finish = sc.nextInt();
        sc.nextLine();

        int graph[] = new int[100001];
        Arrays.fill(graph, -1);
        queue.add(start);
        graph[start] = start;

        while (!queue.isEmpty()){
            now = queue.poll();

            if(now == finish){

                while (now != start){
                    distance.add(now);
                    now = graph[now];
                }
                distance.add(now);
                Collections.reverse(distance);
                break;
            }

            calNows = new int[]{now + 1, now - 1, 2 * now};

            for(int calNow : calNows){
                if( calNow >= 0 && calNow <= 100000 && graph[calNow] == -1){
                    queue.add(calNow);
                    graph[calNow] = now;
                }
            }


        }
        System.out.println(distance.size() - 1);
        for(int i = 0; i < distance.size(); i++){
            System.out.print(distance.get(i) +" ");
        }
    }
}


<!-- 1. queue에 노드를 삽입하거나 노드를 제거하는 연산: O(1)
2. 상태를 체크하고 새로운 노드를 탐색하는 과정: O(1) (상수 시간)
3. 모든 노드를 방문하여 최단 경로를 탐색하는 과정: O(V) (V는 노드의 개수)
위의 과정을 종합하면, BFS의 시간 복잡도는 O(V)입니다. -->