package jinwoo.week2;

import java.util.Scanner;

public class B_6064 {

    public static void main(String[] args) {
        //메모리 : 21628KB, 시간 : 476ms, 시간복잡도 : O(T*M)
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int M = 0, N = 0, x = 0, y = 0;
        for(int i=0; i<T; i++){
            M = sc.nextInt();
            N = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            check(M,N,x,y);
        }

        sc.close();
    }

   
     public static void check(int M, int N, int x, int y){
        int end = checkEnd(M,N); //마지막해 구하기
        int j = 0;

        while(true){

            int test = N * j + y;

            if((test)>end){
                System.out.println(-1);
                break;
            }

           if(((test)-x)%M==0){ 
                System.out.println(test);
                break;
           }

           j++;
        }
    }

    public static int checkEnd(int M, int N){
        int k = 0;
        while(((N*k + N)-M)%M!=0){
            k++;
        }
        return N*k+N;
    }
}