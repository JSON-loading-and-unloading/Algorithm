import java.util.*;
import java.io.*;
public class Main {

	static int n;
	static int m;
	static int r;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int rowStart = 0; // 시작점
		int rowEnd = n-1; // 끝점
		
		int colStart = 0; // 시작점
		int colEnd = m-1; // 끝점
		while(true) {
			int size = (rowEnd-rowStart+1)*2 + (colEnd-colStart+1)*2 -4; // 테두리 길이
			change(rowStart,rowEnd,colStart,colEnd,r%size); // r%size -> 시간복잡도를 줄이기 위해 나머지값으로만 반복하게
			rowStart+=1;
			rowEnd-=1;
			colStart+=1;
			colEnd-=1;
			if(rowStart>rowEnd || colStart>colEnd) break;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
      System.out.println(sb);
	}
	
	public static void change(int rowStart, int rowEnd, int colStart, int colEnd, int cnt) {
		for(int k=0;k<cnt;k++) {
			int temp = arr[rowStart][colStart];

			for(int j=colStart;j<colEnd;j++) {
				arr[rowStart][j] = arr[rowStart][j+1]; 
			}
			
			for(int i=rowStart;i<rowEnd;i++) {
				arr[i][colEnd] = arr[i+1][colEnd];
			}
			
			for(int j=colEnd;j>colStart;j--) {
				arr[rowEnd][j] = arr[rowEnd][j-1];
			}
			
			for(int i=rowEnd;i>rowStart;i--) {
				arr[i][colStart] = arr[i-1][colStart];
			}
			arr[rowStart+1][colStart] = temp;
		}
	}

}