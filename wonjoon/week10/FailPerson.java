package week10;

import java.util.Arrays;

public class FailPerson {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Arrays.sort(participant);
            Arrays.sort(completion);

            for(int i = 0; i < participant.length-1; i++) {
                if (!participant[i].equals(completion[i])) {
                    answer = participant[i];
                    return answer;
                }
            }

            return participant[participant.length-1];
        }
    }
}
