package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = 0;

        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int position = Integer.parseInt(st.nextToken());
            if (position < 0) {
                negatives.add(position);
                continue;
            }
            positives.add(position);
        }
        Collections.sort(positives);
        int bigPos = 0;
        if (!positives.isEmpty())
            bigPos = positives.get(positives.size()-1);
        Collections.sort(negatives);
        int smallNeg = 0;
        if (!negatives.isEmpty())
            smallNeg = negatives.get(0);
        while (!negatives.isEmpty()) {
            int cnt = 0;
            while (cnt < m) {
                if (negatives.isEmpty())
                    break;

                Integer remove = negatives.remove(0);
                if (cnt == 0) {
                    sum += 2 * (Math.abs(remove));
                }
                cnt++;
            }
        }

        while (!positives.isEmpty()) {
            int cnt = 0;
            while (cnt < m) {

                if (positives.isEmpty())
                    break;
                Integer remove = positives.remove(positives.size()-1);

                if (cnt == 0) {
                    sum += 2 * (remove);
                }
                cnt++;
            }
        }
        System.out.println(sum - Math.abs(Math.max(Math.abs(smallNeg), bigPos)));
    }
}
