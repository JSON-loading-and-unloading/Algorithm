package jinwoo.week10;

import java.io.IOException;
import java.util.*;

public class P_전화번호목록 {
    public static void main(String[] args) throws NumberFormatException, IOException {

    }

    public static boolean solution(String[] phone_book) {

        Arrays.sort(phoneBook);

        for (int i = 0; i < phoneBook.length - 1; i++)
            if (phoneBook[i + 1].startsWith(phoneBook[i]))
                return false;

        return true;
    }
}
