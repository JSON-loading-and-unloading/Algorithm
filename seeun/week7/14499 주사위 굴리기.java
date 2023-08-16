import java.io.*;
import java.util.*;

public class Main {
	static int[] dice = new int[7];
	static int n,m,x,y,k;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
        
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
        
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			int d = Integer.parseInt(st.nextToken());
			move(d);
		}
		
	}
	
    static void move(int d) {
        int nx = x + dx[d-1];
        int ny = y + dy[d-1];
        if(nx <0 || ny < 0 || nx > m-1 || ny > n-1) return;
        moveDice(d, nx, ny);
        x = nx; y = ny;

    }

    
	static void moveDice(int d, int x, int y) {
		int tmp = dice[3]; // dice[3]은 무조건 움직이므로 tmp에 넣고, 가장 먼저 dice[3]으로 이동
		switch(d) {
		case 1: // 동쪽으로 이동
			dice[3] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		case 2: // 서쪽으로 이동
			dice[3] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;
		case 3: // 남쪽으로 이동
			dice[3] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[1];
			dice[1] = tmp;
			break;
		case 4: // 북쪽으로 이동
			dice[3] = dice[1];
			dice[1] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}
		if(map[y][x] == 0) {
			map[y][x] = dice[6];
		} else {
			dice[6] = map[y][x];
			map[y][x] =0;
		}
		System.out.println(dice[3]);
		
	}
}