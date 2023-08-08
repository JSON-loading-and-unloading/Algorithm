import java.io.*;
import java.util.*;

// 시간 복잡도 O(2^(NM)) , 메모리 18584KB
public class Main {
	
	public static int N,M;
	public static int[][] map; 
	public static boolean[][] visited; //방문처리
	public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	visited = new boolean[N][M];
    	
    	for(int i=0;i<N;i++) {
    		String str = br.readLine();
    		for(int j=0;j<M;j++) {
    			map[i][j] = str.charAt(j) - '0';
    		}
    	}
    	
    	dfs(0, 0); 
    	System.out.println(answer);
    	
    	
    	
    }
    
    public static void dfs(int row, int col) {
    	//행이 N과 같아질 시 탐색 종료
    	if(row == N) {
    		getAnswer();
    		return ;
    	}
    	
    	//하나의 행 다 탐색하면, 그 다음 행으로 
    	if(col >= M) {
    		dfs(row + 1, 0);
    		return ; //가로 계산이 끝나면 종료시켜야함.
    	}
    	
    	//가로라면 true 처리
    	visited[row][col] = true;
    	dfs(row, col + 1);
    	
    	//세로라면 false 처리
    	visited[row][col] = false;
    	dfs(row, col + 1);
    	
    }
    
    public static void getAnswer() {
    	int result = 0;
    	int sum = 0;
    	
    	//가로 계산
    	for(int i=0;i<N;i++) {
    		sum = 0;
    		for(int j=0;j<M;j++) {
    			if(visited[i][j] == true) { //방문했다면 
    				sum *= 10; // 숫자가 4,3,2 면 432가 되어야 하므로 자릿수
    				sum += map[i][j];
    			}else {
    				result += sum;
    				sum = 0;
    			}
    		}
    		//행 한줄 계산 끝날때마다 result에 + 연산 추가
    		result += sum;
    	}
    	
        //세로 계산
    	for(int i=0;i<M;i++) {
    		sum = 0;
    		for(int j=0;j<N;j++) {
    			if(visited[j][i] == false) { // 방문했다면(세로 기준으로)
    				sum *= 10; // 숫자가 4,3,2 면 432가 되어야 하므로 자릿수
    				sum += map[j][i];  
    			}else {
    				result += sum;
    				sum = 0;
    			}
    		}
    		result += sum;
    	}
    	
    	answer = Math.max(answer,  result);
    	
    }
    
}