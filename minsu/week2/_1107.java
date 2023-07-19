// 메모리 67008 시간 404ms 시간복잡도 O(n^2)

import java.util.ArrayList;
import java.util.Scanner;

public class _1107 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int goalChannel=sc.nextInt();
        int numOfBroken=sc.nextInt();
        ArrayList<Integer> brokenButtons=new ArrayList<>();

        for(int i=0;i<numOfBroken;i++){
            int n=sc.nextInt();
            brokenButtons.add(n);
        }
        int result=Math.abs(goalChannel-100);

        System.out.println(minButtonCount(goalChannel, brokenButtons,result));
    }
    public static int minButtonCount(int goalChannel, ArrayList<Integer> brokenButtons, int result) {
        for(int i = 0; i <= 999999; i++) {
            String str=String.valueOf(i);
            int length=str.length();
            boolean isBroken=false;

            for(int j=0;j<length;j++){
                if(brokenButtons.contains(str.charAt(j)-'0')){
                    isBroken=true;
                    break;
                }
            }
            if(!isBroken){
                int min=Math.abs(goalChannel-i)+length;
                result=Math.min(min, result);
            }
        }
        return result;
    }
}