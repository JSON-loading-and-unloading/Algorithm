import java.util.*;

class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            String type = clothes[i][1];
            hash.put(type, hash.getOrDefault(type, 1) + 1);
        }

        for (String key : hash.keySet()) {
            answer *= hash.get(key);
        }

        return answer - 1;
    }
}