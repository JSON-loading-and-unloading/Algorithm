import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int r;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < r; i++) {
			int num = Integer.parseInt(st.nextToken());
			solve(num);
			
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static void solve(int num) {
		switch(num) {
		case 1 :
			cal1();
			break;
		case 2:
			cal2();
			break;
		case 3: // 오른쪽으로 90도 -> n,m 값 바꿔줘야 함
			cal3(); 
			int temp = n;
			n = m;
			m = temp;
			break;
		case 4: // 왼쪽으로 90도 -> n,m 값 바꿔줘야 함
			cal4();
			int temp1 = n;
			n = m;
			m = temp1;
			break;
		case 5:
			cal5();
			break;
		case 6:
			cal6();
			break;
		}
	}
	
	public static void cal1() {// 상하 반전
		int idx = n-1;
		int[][] temp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp[i][j] = arr[idx][j];
			}
			idx--;
		}
		arr = temp;
	}
	
	public static void cal2() {// 좌우 반전
		int idx = m-1;
		int[][] temp = new int[n][m];
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
				temp[i][j] = arr[i][idx];
			}
			idx--;
		}
		arr = temp;
	}
	
	public static void cal3() {// 오른쪽으로 90도 회전
		int idx = n-1;
		int[][] temp = new int[m][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp[j][idx] = arr[i][j];
			}
			idx--;
		}
		arr = temp;
	}
	
	public static void cal4() {// 왼쪽으로 90도 회전
		int[][] temp1 = new int[m][n];
		Queue<Integer> temp = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp.add(arr[i][j]);
			}
		}
		for(int i=0; i<n; i++) {
			for(int j= m-1; j>=0; j--) {
				temp1[j][i] = temp.poll();
			}
		}
		arr = temp1;
	}
	
	public static void cal5() {
		int[][] temp = new int[n][m];
		int x = n/2;
		int y = m/2;
		
		for(int i = 0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i][j+y] = arr[i][j];
			}
		}
		for(int i = 0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i+x][j+y] = arr[i][j+y];
			}
		}
		for(int i = 0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i+x][j] = arr[i+x][j+y];
			}
		}
		for(int i = 0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i][j] = arr[i+x][j];
			}
		}
		arr = temp;
	}
	
	public static void cal6() {
		int[][] temp = new int[n][m];
		int x = n/2;
		int y = m/2;
		
		for(int i = 0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i+x][j+y] = arr[i+x][j];
			}
		}
		for(int i = 0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i][j+y] = arr[i+x][j+y];
			}
		}
		for(int i = 0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i+x][j] = arr[i][j];
			}
		}
		for(int i = 0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i][j] = arr[i][j+y];
			}
		}
		arr = temp;
	}

}