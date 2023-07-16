// 메모리 978 kb 시간 복잡도 O(n^2)

import java.util.*;
public class _2309 {
    public static void main(String[] args) {
        //1. 입력 처리
       int[] arr=new int[9];
       int totalSum=0;
       int fp=0,sp=0;
       Scanner sc=new Scanner(System.in);


       for(int i=0;i<9;i++){
           arr[i]=sc.nextInt();
           totalSum+=arr[i];
       }

        Arrays.sort(arr);

       //2. 뺄 난쟁이 2명 선택하기
        loop:
        for(int i=0;i<8;i++){
           for(int j=i+1;j<9;j++){
               if(totalSum-arr[i]-arr[j]==100) {
                   fp=i;
                   sp=j;
                   break loop;
               }
           }
        }

        //3. 출력하기
        for(int i=0;i<9;i++){
            if(i==fp||i==sp)
                continue;
            System.out.println(arr[i]);
        }
        sc.close();
    }
}