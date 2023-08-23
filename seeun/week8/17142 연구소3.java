import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[] arr; // 뽑은 조합을 담는 배열 

	static ArrayList<Virus> virusList = new ArrayList<>();
	
	static int[][] map;
	static boolean[][] isVisit;
	static int zero;		// 빈칸 개수
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken()); 
		
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				map[i][j] = num;
				
				if(num == 2) { // 바이러스. 바이러스 리스트에 넣기
					virusList.add(new Virus(i,j,0));
				}else if(num == 0) {
					zero++;	
				}
			}
		}
		
		// 빈칸 없는 경우 바로 종료
		if(zero == 0) {
			System.out.println(0);
			return;
		}
		
		arr = new int[m];
		
		// 조합 + 탐색 시작
		dfs(0, 0);
		
		// 다 못채우면 종료
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(min);
		
	}

	// cnt : 뽑은 수, index : 현재 가르키는 위치
	private static void dfs(int cnt, int index) {
		if(cnt == m) {
			bfs();		//다 뽑으면 탐색 시작
			return;
		}
		// 시간 복잡도를 위해 바이러스가 있는 곳만 탐색
		for (int i = index; i < virusList.size(); i++) {
			arr[cnt] = i;
			dfs(cnt+1, i+1);
		}
	}

	private static void bfs() {
		Queue<Virus> q = new LinkedList<>();
		isVisit = new boolean[n][n];
		
		// 뽑힌 수대로 바이러스 리스트에 접근해서 Q에 삽입
		for (int i = 0; i < m; i++) {
			q.add(virusList.get(arr[i]));
			isVisit[virusList.get(arr[i]).x][virusList.get(arr[i]).y] = true;
		}
		
		int time = 0;		// 걸린 시간 
		int count = 0;		// 확산된 빈칸 개수
		
		while(!q.isEmpty()) {
			Virus v = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				
				time = v.time;
				
				// 범위 밖 OR 이미 방문 -> 무시
				if(!(0 <= nx && nx < n && 0 <= ny && ny < n) || isVisit[nx][ny]) continue;
				
				// 빈칸이어서 확산한 경우
				if(map[nx][ny] == 0) {
					isVisit[nx][ny] = true;
					count++;
					q.add(new Virus(nx,ny,v.time+1));
				}
				
				// 확산은 못하지만 지나갈 수 있는 경우
				if(map[nx][ny] == 2) {
					isVisit[nx][ny] = true;
					q.add(new Virus(nx,ny,v.time+1));
				}
				
			}
			
			// 만약 이미 빈칸이 채워졌다면 사전에 종료시킴으로써 시간값의 계속 증가를 방지
			if(count == zero) {
				time++;	// 이경우, 새로 뽑은 시간값 할당이 안되므로, 임의로 1 증가
				break;
			}
		};
	
		if(count != zero) return;	// 다 못채우면 그냥 끝내기
		
		min = Math.min(min, time);
	}

    public static class Virus {
	int x;
	int y;
	int time;
	
	public Virus(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
}