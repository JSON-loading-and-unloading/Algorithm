package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        String bomb = br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < st.length(); i++) {
            sb.append(st.charAt(i));
            if (sb.length() >= bomb.length()) {
                if (sb.substring(sb.length()-bomb.length(), sb.length()).equals(bomb)) {
                    sb.delete(sb.length()-bomb.length(), sb.length());
                }
            }
        }

        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(usedMemory + " bytes");

        if (sb.length() == 0) {
            System.out.println("FRULA");
            return;
        }
        System.out.println(sb);
    }
}

/**
 * import java.io.BufferedReader;
 * import java.io.IOException;
 * import java.io.InputStreamReader;
 *
 * public class Main {
 *     static String st;
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *
 *         st = br.readLine();
 *         String bomb = br.readLine();
 *
 *         while (checkBomb(bomb))
 * //        while(true) {
 * //            String s = checkBomb(bomb);
 * //            if (s.equals("FIN"))
 * //                break;
 * //            st = s;
 * //        }
 *
 *         if (st.isEmpty()) {
 *             System.out.println("FRULA");
 *             return;
 *         }
 *         System.out.println(st);
 *     }
 *
 *     private static boolean checkBomb(String bomb) {
 *         if (st.contains(bomb)) {
 *             st = st.replace(bomb, "");
 *             return true;
 *         }
 *         return false;
 *     }
 * }
 *
 * 메모리 초과
 */
