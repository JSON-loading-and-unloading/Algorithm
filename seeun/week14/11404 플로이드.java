import java.io.*;
import java.util.*;
 
public class Main {    
    
    static int[][] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        // 최솟값을 구하기 때문에 먼저 최댓값으로 채우기 
        arr = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = 100000001;
            }
            arr[i][i] = 0;
        }
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(arr[start][end] > cost) arr[start][end] = cost;
        }
        
        //플로이드-워샬알고리즘 
        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < n + 1; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                //i -> j로 갈 수 없는 경우 0출력
                if(arr[i][j] == 100000001) System.out.print("0 "); 
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}