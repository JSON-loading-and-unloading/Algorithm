package jinwoo.week10;

import java.io.IOException;
import java.util.*;

public class P_완주하지못한선수 {
    public static void main(String[] args) throws NumberFormatException, IOException {

    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<participant.length; i++) {
            
            if(i==participant.length-1) { //마지막일때
                return participant[i];
            }
            
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return "";
    }
}
