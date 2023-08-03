import java.util.*;
import java.io.*;
public class _14391 {
    public static int N, M;
    public static int[][] input;
    public static boolean[][] isRow;
    public static int result=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine(), " ");

        N=Integer.parseInt(st.nextToken()); //행 크기
        M=Integer.parseInt(st.nextToken()); //열 크기

        input=new int[N][M];
        isRow=new boolean[N][M];

        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int j=0;j<M;j++){
                input[i][j]=str.charAt(j)-'0';
            }
        }
        DFS(0,0);
        System.out.println(result);
    }
    public static void DFS(int row, int col){
        //계산 조건 -> 탐색 종료
        if(row==N){
            calculate(); //계산하고
            return; //pop
        }

        //다음 행으로 이동
        if(col>=M){
            DFS(row+1,0);
            return; //계산이 끝나면 종료
        }

        //처음부터 끝까지 true로 바꾸어줌
        isRow[row][col]=true;
        DFS(row,col+1);

        //끝에서부터 false로 수정
        isRow[row][col]=false;
        DFS(row,col+1);
    }

    public static void calculate(){
        int sum=0;
        int temp;

        for(int i=0;i<N;i++){
            temp=0;
            for(int j=0;j<M;j++){
                if(isRow[i][j]==true){
                    temp*=10;
                    temp+=input[i][j];
                }else{
                    sum+=temp;
                    temp=0;
                }
            }
            sum+=temp;
        }
        for(int j=0;j<M;j++){
            temp=0;
            for(int i=0;i<N;i++){
                if(isRow[i][j]==false){
                    temp*=10;
                    temp+=input[i][j];
                }else{
                    sum+=temp;
                    temp=0;
                }
            }
            sum+=temp;
        }

        result=Math.max(sum,result);
    }
}
