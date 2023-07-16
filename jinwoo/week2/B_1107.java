package jinwoo.week2;

import java.util.Scanner;

public class B_1107 {
    static Scanner sc = new Scanner(System.in);
    static int[] nums = {0,1,2,3,4,5,6,7,8,9};
    public static void main(String[] args) {
        //메모리 : 95760KB, 시간 : 264ms , 시간복잡도 : O(n*500,000) (n자릿수)
        String N = sc.nextLine();
        int iN = Integer.parseInt(N);
        int M = sc.nextInt();
        int answer = (Math.abs(iN-100));

        for(int i=0; i<M; i++){
            nums[sc.nextInt()] = -1 ;
        }

        int i = 0;

        while(true){

            if((i+Integer.toString(iN + i).length()) > answer){
                break;
            }

            //-1 비교
            if(iN + (-1)*i>=0 && check(iN +(-1)*i)) {
                i = (-1) * i;
                answer = Integer.toString(iN + i).length()+Math.abs(i);
                break;
            }

            //+1 비교
            if(check(iN + i)) {
                answer = Integer.toString(iN + i).length()+Math.abs(i);
                break;
            }
            i++;
        }
        
        System.out.println(answer);
    }

    public static boolean check(int iN){
        String N2 = Integer.toString(iN); //String 변환

        for(int i=0; i<N2.length(); i++){
            int x = N2.charAt(i)-'0';
            if(nums[x]!=x) return false;
        }

        return true;
    }

}
