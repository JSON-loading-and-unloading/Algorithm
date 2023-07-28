import java.util.*;

//메모리 36264KB, 시간복잡도 O(k)
public class Main {
	static int[] time = new int[100001]; // 현재 위치까지 오는데에 걸리는 시간 
	static int[] before = new int[100001]; // 현재 위치로 오기 전에 있는 위치 (경로 저장용)
	static int n;
	static int k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		if (n == k) { // 수빈과 동생이 같은 위치에 있을 때
			System.out.println(0);
			System.out.println(n);
		} else {
			bfs(n);
            System.out.println(time[k]);
			StringBuilder sb = new StringBuilder(); // 결과 저장
			Stack<Integer> stack = new Stack<>(); // LIFO인 Stack을 사용해 경로 추적
			int position = k; // LIFO이기 때문에 도착지점부터 처음 위치까지 경로 추적
			while (position != n) {
				stack.push(position);
				position = before[position];
			}
			stack.push(n); // 처음 위치 넣어주기

			while (!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}

			System.out.println(sb.toString());

		}
	}

	public static void bfs(int n) {
		Queue<Integer> que = new LinkedList<>(); // 큐 생성 LinkedList 사용하는 이유?
        // 큐는 항상 첫 번재 저장된 데이터를 삭제하므로, ArrayList와 같은 배열 기반의 자료구조를 
        //사용하게 되면 빈공간을 채우기 위해서 데이터의 복사가 발생하므로 매우 비효율.
		que.add(n);

		while (!que.isEmpty()) { // 큐가 빌때까지
			int x = que.poll(); // 현재위치
			if (x == k) // 값이 구해지면 멈춤
				break;
			if (x > 0 && time[x - 1] == 0) { //왼쪽으로 이동 (첫 방문)
				que.add(x - 1);
				time[x - 1] = time[x] + 1;
				before[x - 1] = x; // 이전에 들렀던 곳 저장
			}
			if (x + 1 < time.length && time[x + 1] == 0) { //오른쪽으로 이동 (첫 방문)
				que.add(x + 1);
				time[x + 1] = time[x] + 1;
				before[x + 1] = x;
			}
			if (x * 2 < time.length && time[x * 2] == 0) { //순간이동 (첫 방문)
				que.add(x * 2);
				time[x * 2] = time[x] + 1;
				before[x * 2] = x;

			}

		}
	}

}