package week10;

import java.util.HashMap;
import java.util.Map;

public class Clothes {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;

            Map<String, Integer> types = new HashMap<>();
            for (String[] cloth : clothes) {
                types.put(cloth[1], types.getOrDefault(cloth[1], 0)+1);
            }
            for (int cnt : types.values()) {
                answer *= (cnt+1);
            }
            return answer-1;
        }
    }
}
