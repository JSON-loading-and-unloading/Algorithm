package week10;

import java.util.ArrayList;
import java.util.List;

public class PhoneKetMon {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            List<Integer> myPocket = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                if(myPocket.contains(nums[i])) {
                    continue;
                }
                myPocket.add(nums[i]);
            }

            if(myPocket.size() >= nums.length/2) {
                answer = nums.length/2;
            } else {
                answer = myPocket.size();
            }

            return answer;
        }
    }
}
