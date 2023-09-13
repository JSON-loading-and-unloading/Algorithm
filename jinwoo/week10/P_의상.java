package jinwoo.week10;

import java.io.IOException;
import java.util.*;

public class P_의상 {
    public static void main(String[] args) throws NumberFormatException, IOException {
       String[][] test = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

       System.out.println(solution(test));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        // Key - Value : 종류 - 갯수
        for(String[] array : clothes) {
            String key = array[1];
            if(map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
        }
        
        int answer = 1 ;

         for (Integer value : map.values()) {
                answer *= (value+1); // 안 입는 경우까지 함께 카운트
        }  

        // 모든 옷을 입지 않는 경우 제외함
        answer = answer -1;

        return answer;
    }
}
