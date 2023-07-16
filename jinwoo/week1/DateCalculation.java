package jinwoo.week1;

import java.util.Scanner;

public class DateCalculation {
     public static void main(String[] args) {
        //메모리 : 12832KB, 시간복잡도 : n
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int third = sc.nextInt();

        int i = 0 ;

        while(true){
            int target = 28 * i + second;

            if((target-third)%19==0 && (target-first)%15==0) break;
            else i++;
        }

        System.out.println(i*28+second);
        sc.close();
    }
}