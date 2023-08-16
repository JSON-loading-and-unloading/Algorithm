import java.util.*;

public class Problem14890 {
    static int size;
    static int length;
    static int[][] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        length = sc.nextInt();

        array = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int widthCount = countValidPaths(array);
        int[][] rotatedArray = rotateArray(array);
        int heightCount = countValidPaths(rotatedArray);

        System.out.println(widthCount + heightCount);
    }

    static int countValidPaths(int[][] array) {
        int count = 0;

        for (int i = 0; i < size; i++) {
            int[] path = array[i];
            if (isValidPath(path)) {
                count++;
            }
        }

        return count;
    }

    static boolean isValidPath(int[] path) {
        int count = 1;
        for (int i = 1; i < size; i++) {
            if (path[i - 1] == path[i]) {
                count++;
            } else if (path[i - 1] + 1 == path[i] && count >= length) {
                count = 1;
            } else if (path[i - 1] - 1 == path[i] && count >= 0) {
                count = -length + 1;
            } else {
                return false;
            }
        }
        return count >= 0;
    }

    static int[][] rotateArray(int[][] array) {
        int[][] rotated = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotated[j][size - i - 1] = array[i][j];
            }
        }
        return rotated;
    }
}
