import java.io.*;
import java.util.*;

public class _14890 {
    public static int N, L;
    public static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        map=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int count=0;
        for(int i=0;i<N;i++){
            if(canRowRoad(i)){
                count++;
            }
            if(canColRoad(i)){
                count++;
            }
        }
        System.out.println(count);

    }
    public static boolean canColRoad(int col){//열이 길이 될 수 있는지 체크
        boolean[] isIncline=new boolean[N]; //경사로가 있는지

        for(int i=0;i<N-1;i++){
            int diff=map[i][col]-map[i+1][col];

            if(diff>1||diff<-1)
                return false;
            else if(diff==-1){//오르막 경사로 -> 그 지점부터 앞의 지점에 경사로를 설치
                for(int j=0;j<L;j++){
                    if(i-j<0||isIncline[i-j])
                        return false;
                    if(map[i][col]!=map[i-j][col])
                        return false;
                    isIncline[i-j]=true;
                }
            }
            else if(diff==1){//내리막 경사로 -> 그 지점의 뒤의 지점에 경사로를 설치
                for(int j=1;j<L+1;j++){
                    if(i+j>=N||isIncline[i+j])
                        return false;
                    if(map[i][col]-1!=map[i+j][col])
                        return false;
                    isIncline[i+j]=true;
                }
            }
        }
        return true;
    }
    public static boolean canRowRoad(int row){//행이 길이 될 수 있는지 체크
        boolean[] isIncline=new boolean[N]; //경사로가 있는지

        for(int i=0;i<N-1;i++){
            int diff=map[row][i]-map[row][i+1];

            if(diff>1||diff<-1)
                return false;
            else if(diff==-1){//오르막 경사로 -> 그 지점부터 앞의 지점에 경사로를 설치
                for(int j=0;j<L;j++){
                    if(i-j<0||isIncline[i-j])
                        return false;
                    if(map[row][i]!=map[row][i-j])
                        return false;
                    isIncline[i-j]=true;
                }
            }
            else if(diff==1){//내리막 경사로 -> 그 지점의 뒤의 지점에 경사로를 설치
                for(int j=1;j<L+1;j++){
                    if(i+j>=N||isIncline[i+j])
                        return false;
                    if(map[row][i]-1!=map[row][i+j])
                        return false;
                    isIncline[i+j]=true;
                }
            }
        }
        return true;
    }
}
