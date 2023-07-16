//메모리 25544kb 시간 588ms 시간복잡도 O(n)

import java.util.*;
public class _6064 {
    static int T;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        T=sc.nextInt();

        map=new int[T][4];
        for(int i=0;i<T;i++){
            for(int j=0;j<4;j++){
                map[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<T;i++){
            System.out.println(count(map[i]));
        }
    }

    public static int count(int[] arr){
        int M=arr[0];
        int N=arr[1];
        int x=arr[2];
        int y=arr[3];

        int min=(M<N)?M:N;
        int gcd=0;

        for(int i=1;i<=min;i++){
            if(M%i==0&&N%i==0)
                gcd=i;
        }

        int lcm=M*N/gcd;

        for(int i=0;i<lcm/M;i++){
            if((M*i+x-y)%N==0)
                return M*i+x;
        }
        return -1;
    }

}
