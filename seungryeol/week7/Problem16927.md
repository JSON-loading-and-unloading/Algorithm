import java.util.*;

public class Problem16927 {
    static int n, m;
    static int count;
    static int array[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        count = sc.nextInt();

        sc.nextLine();
        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String lineArr[] = line.split(" ");

            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(lineArr[j]);
            }
        }

        int su = Math.min(m, n) / 2;
        for (int i = 0; i < su; i++) {
            int haeng = n - 2 * i;
            int ryeol = m - 2 * i;
            int totalCount = count % (2 * (haeng + ryeol - 2));

            cycle(i, haeng, ryeol, totalCount);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void cycle(int i, int haeng, int ryeol, int totalCount) {
        int[] temp = new int[2 * (haeng + ryeol - 2)];

        int index = 0;
        for (int j = i; j < i + ryeol; j++) {
            temp[index++] = array[i][j];
        }
        for (int j = i + 1; j < i + haeng; j++) {
            temp[index++] = array[j][i + ryeol - 1];
        }
        for (int j = i + ryeol - 2; j >= i; j--) {
            temp[index++] = array[i + haeng - 1][j];
        }
        for (int j = i + haeng - 2; j > i; j--) {
            temp[index++] = array[j][i];
        }

        index = 0;
        totalCount %= temp.length;
        for (int j = i; j < i + ryeol; j++) {
            array[i][j] = temp[(index + totalCount) % temp.length];
            index++;
        }
        for (int j = i + 1; j < i + haeng; j++) {
            array[j][i + ryeol - 1] = temp[(index + totalCount) % temp.length];
            index++;
        }
        for (int j = i + ryeol - 2; j >= i; j--) {
            array[i + haeng - 1][j] = temp[(index + totalCount) % temp.length];
            index++;
        }
        for (int j = i + haeng - 2; j > i; j--) {
            array[j][i] = temp[(index + totalCount) % temp.length];
            index++;
        }
    }
}