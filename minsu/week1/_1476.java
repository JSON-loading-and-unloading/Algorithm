// 메모리 1003kb, 시간복잡도 O(n)

import java.util.*;
public class _1476 {
    public static void main(String[] args) {
        int E, S, M;
        Scanner sc=new Scanner(System.in);
        int a=0;

        E=sc.nextInt();
        S=sc.nextInt();
        M=sc.nextInt();

        while(true){
            if((15*a+E-S)%28==0&&(15*a+E-M)%19==0)
                break;
            else
                a++;
        }
    }
}
