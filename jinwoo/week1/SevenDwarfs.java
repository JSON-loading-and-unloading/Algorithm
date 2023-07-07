package jinwoo.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenDwarfs {

    public static void main(String[] args) throws IOException {
        // 메모리 : 11460 KB , 시간복잡도 : n^2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        int sum = 0;
        int fake1 = 0, fake2 = 0;

        for(int i=0;i<9;i++){
            heights[i] = Integer.parseInt(br.readLine());
            sum+=heights[i];
        }

        Loop1 :
        for(int i=0;i<9;i++){
            for(int j=i+1;j<9;j++){
                if(heights[i]+heights[j]==sum-100){
                    fake1 = heights[i];
                    fake2 = heights[j];
                    break Loop1;
                }
            }
        }

        Arrays.sort(heights);

        for(int i = 0 ; i<9 ; i++){
            if(fake1 == heights[i] || fake2 == heights[i]) continue;
            System.out.println(heights[i]);
        }
    }
}