import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] papper;
    static int n,m,max=0;

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        papper=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;i++) {
            String str=sc.next();
            for(int j=0;j<m;j++) {
                papper[i][j]=str.charAt(j)-'0';
            }
        }
        check(0,0);
        System.out.println(max);
    }

    static void check(int r, int c) {

        if(r>=n) {
            sum();
            return;
        }
        if(c>=m) {
            check(r+1,0);
            return;
        }

        visited[r][c]=true;
        check(r,c+1);
        visited[r][c]=false;
        check(r,c+1);
    }

    static void sum() {
        int sum=0;
        for(int i=0;i<n;i++) {
            int temp=0;
            for(int j=0;j<m;j++) {

                if(visited[i][j]) {
                    temp*=10;
                    temp+=papper[i][j];
                }

                else {
                    sum+=temp;
                    temp=0;
                }
            }
            sum+=temp;
        }

        for(int i=0;i<m;i++) {
            int temp=0;
            for(int j=0;j<n;j++) {

                if(!visited[j][i]) {
                    temp*=10;
                    temp+=papper[j][i];
                }

                else {
                    sum+=temp;
                    temp=0;
                }
            }
            sum+=temp;
        }
        max=Math.max(max, sum);
    }
}