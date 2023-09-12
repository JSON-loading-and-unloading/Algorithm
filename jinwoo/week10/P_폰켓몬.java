package jinwoo.week10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_폰켓몬 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
    }

     public static int solution(int[] nums) {
        int max = nums.length / 2;

        List<Integer> list = new ArrayList<>();

        for(int i : nums) {
            list.add(i);
        }

        Set set = new HashSet<>(list);
        
        if(max >= set.size()) {
            return set.size();
        } else {
            return max;
        }
    }
}