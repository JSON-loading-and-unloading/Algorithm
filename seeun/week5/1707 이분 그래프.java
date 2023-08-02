import java.io.*;
import java.util.*;

// 시간 복잡도 O(V + E) , 메모리 270448KB
public class Main {
	static int v, e;
	static ArrayList<Integer>[] relation; //각 정점의 연결관계 
	static int visit[]; // 방문 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			visit = new int[v+1]; // +1 을 해주는 이유? 각 정점에 붙어있는 번호의 위치(index)에 값을 넣고 싶어서
			relation = new ArrayList[v+1]; 

			for(int j = 0; j <= v; j++)
				relation[j] = new ArrayList<Integer>();

			for(int l = 0; l < e; l++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());

				relation[p1].add(p2); // 서로 연결되어있음 서로 관계 표시
				relation[p2].add(p1);
			}
		       checkGraph(); //이분 그래프 검사
		}
	}

	public static void checkGraph() {
		Queue<Integer> q = new LinkedList<Integer>();

		for(int i = 1; i <= v; i++) {
			if(visit[i] == 0) { // 첫 방문
				q.add(i);
				visit[i] = 1;
			}

			while(!q.isEmpty()) {
				int num = q.poll(); // 방문 번호 (queue fifo)

				for(int j = 0; j < relation[num].size(); j++) { // 방문한 번호에 연관된 번호들의 수 만큼 반복
					if(visit[relation[num].get(j)] == 0) { //첫 방문일 때 
						q.add(relation[num].get(j)); 
					}
					
					if(visit[relation[num].get(j)] == visit[num]) { // 방문한 번호와 연관된 다른 번호와 색이 같은 경우
						System.out.println("NO");
						return;
					}

					if(visit[num] == 1 && visit[relation[num].get(j)] == 0) // 첫 방문일 때
						visit[relation[num].get(j)] = 2; // 연결된 번호와는 다른 색
					else if(visit[num] == 2 && visit[relation[num].get(j)] == 0) // 첫 방문일 때
						visit[relation[num].get(j)] = 1; // 연결된 번호와는 다른 색
				}
			}
		}

		System.out.println("YES");
	}

}