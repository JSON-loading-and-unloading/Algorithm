import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
    static int result = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
        int max = n * (n * (n - 1) / 2); // 완전 그래프 간선 수 * n
        
		arr= new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = max; 
            }
        }
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b]= 1; //a, b가 서로의 키를 아는 상태
		}
		
		//플로이드-워셜: 경유지-출발지-도착지 : 3중 for문
		//출발 i, 도착:j, 경유지:k
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
		for(int i = 1; i <= n; i++) {
			int cnt=0;
			for(int j = 1; j <= n; j++) {
				if(arr[i][j]!= max || arr[j][i]!= max) cnt++;
			}
			if(cnt == n - 1) result++; //자신의 키가 몇 번째인지 아는 학생 수
		}
		
        System.out.println(result);
	}
        
}