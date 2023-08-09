import java.util.*;

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
		} else {
			bfs(n);
      System.out.println(time[k]);
		}
	}

	public static void bfs(int n) {
		Queue<Integer> que = new LinkedList<>();
		que.add(n);

		while (!que.isEmpty()) { // 큐가 빌때까지
			int x = que.poll(); // 현재위치
			if (x == k) // 값이 구해지면 멈춤
	            break;
            
      if (x * 2 < time.length && time[x * 2] == 0 && before[x * 2] == 0) { //순간이동 (첫 방문) 순간이동이 0초이므로 가장 먼저 실행
				que.add(x * 2);
				time[x * 2] = time[x];
				before[x * 2] = x;

			}
            
			if (x > 0 && time[x - 1] == 0 && before[x - 1] == 0) { //왼쪽으로 이동 (첫 방문)
				que.add(x - 1);
				time[x - 1] = time[x] + 1;
				before[x - 1] = x; // 이전에 들렀던 곳 저장
			}
            
			if (x + 1 < time.length && time[x + 1] == 0 && before[x + 1] == 0) { //오른쪽으로 이동 (첫 방문)
				que.add(x + 1);
				time[x + 1] = time[x] + 1;
				before[x + 1] = x;
			}

		}
	}

}