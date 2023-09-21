package jinwoo.week10;

import java.io.IOException;
import java.util.*;

public class P_전화번호목록 {
    public static void main(String[] args) throws NumberFormatException, IOException {

    }

    public static boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++)
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;

        return true;
    }
}
