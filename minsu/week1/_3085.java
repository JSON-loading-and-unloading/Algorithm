// 메모리 1003kb 시간복잡도 O(n^4)

import java.util.*;
public class _3085 {

    /*사탕의 최대 개수를 확인하는 함수*/
    public static int countMax(char[][] candies){
        int max=0;
        int sum;
        // 가로 방향 사탕 개수 세기
        for(int i=0;i<candies.length;i++){
            sum=1;
            for(int j=0;j<candies.length-1;j++){
                if(candies[i][j]==candies[i][j+1]){
                    sum+=1;
                }else{
                    sum=1;
                }
                max=Math.max(sum, max);
            }
        }

        // 세로 방향 사탕 개수 세기
        for(int i=0;i<candies.length;i++){
            sum=1;
            for(int j=0;j<candies.length-1;j++){
                if(candies[j][i]==candies[j+1][i]){
                    sum+=1;
                }else{
                    sum=1;
                }
                max=Math.max(max,sum);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        char[][] candies=new char[N][N];
        String line;
        int max=0, count = 0;

        //1. 입력 처리
        for(int i=0;i<N;i++){
            line=sc.next();
            for(int j=0;j<N;j++){
                candies[i][j]=line.charAt(j);
            }
        }

        //2. 가로로 인접한 사탕끼리 바꾸기
        for(int i=0;i<candies.length;i++){
            for(int j=0;j<candies.length-1;j++){
                char temp=candies[i][j];
                candies[i][j]=candies[i][j+1];
                candies[i][j+1]=temp;

                //3. 개수 세기
                count=countMax(candies);

                //4. 원상복구
                temp=candies[i][j];
                candies[i][j]=candies[i][j+1];
                candies[i][j+1]=temp;

                max=Math.max(count, max);
            }
        }

        //2. 세로로 인접한 사탕끼리 바꾸기
        for(int i=0;i<candies.length;i++){
            for(int j=0;j<candies.length-1;j++){
                char temp=candies[j][i];
                candies[j][i]=candies[j+1][i];
                candies[j+1][i]=temp;

                //3. 개수 세기
                count=countMax(candies);

                //4. 원상복구
                temp=candies[j][i];
                candies[j][i]=candies[j+1][i];
                candies[j+1][i]=temp;

                max=Math.max(count, max);
            }
        }
        System.out.println(max);
    }
}
