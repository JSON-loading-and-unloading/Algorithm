import java.util.Scanner;

public class Problem16935 {
    static int[][] array;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int count = sc.nextInt();
        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < count; i++) {
            int op = sc.nextInt();
            executeOperation(op);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void executeOperation(int op) {
        int[][] temp = new int[n][m];
        switch (op) {
            case 1:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        temp[i][j] = array[n - 1 - i][j];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        temp[i][j] = array[i][m - 1 - j];
                    }
                }
                break;
            case 3:
                temp = new int[m][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        temp[j][n - 1 - i] = array[i][j];
                    }
                }
                int tempN = n;
                n = m;
                m = tempN;
                break;
            case 4:
                temp = new int[m][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        temp[m - 1 - j][i] = array[i][j];
                    }
                }
                tempN = n;
                n = m;
                m = tempN;
                break;
            case 5:
                for (int i = 0; i < n / 2; i++) {
                    for (int j = 0; j < m / 2; j++) {
                        temp[i][j + m / 2] = array[i][j];
                    }
                }
                for (int i = 0; i < n / 2; i++) {
                    for (int j = m / 2; j < m; j++) {
                        temp[i + n / 2][j] = array[i][j];
                    }
                }
                for (int i = n / 2; i < n; i++) {
                    for (int j = m / 2; j < m; j++) {
                        temp[i][j - m / 2] = array[i][j];
                    }
                }
                for (int i = n / 2; i < n; i++) {
                    for (int j = 0; j < m / 2; j++) {
                        temp[i - n / 2][j] = array[i][j];
                    }
                }
                break;
            case 6:
                for (int i = 0; i < n / 2; i++) {
                    for (int j = 0; j < m / 2; j++) {
                        temp[i + n / 2][j] = array[i][j];
                    }
                }
                for (int i = n / 2; i < n; i++) {
                    for (int j = 0; j < m / 2; j++) {
                        temp[i][j + m / 2] = array[i][j];
                    }
                }
                for (int i = n / 2; i < n; i++) {
                    for (int j = m / 2; j < m; j++) {
                        temp[i - n / 2][j] = array[i][j];
                    }
                }
                for (int i = 0; i < n / 2; i++) {
                    for (int j = m / 2; j < m; j++) {
                        temp[i][j - m / 2] = array[i][j];
                    }
                }
                break;
        }
        array = temp;
    }
}

~~~
//import java.util.*;
//
//public class Problem16935 {
//    static int[][] array;
//    static ArrayList<Integer> cal = new ArrayList<>();
//    static Runnable[] fun = new Runnable[7];
//    static int n,m;
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        n = sc.nextInt();
//        m = sc.nextInt();
//        int count = sc.nextInt();
//        sc.nextLine();
//        array = new int[n][m];
//        for(int i = 0; i < n; i++){
//            String line = sc.nextLine();
//            String lines[] = line.split(" ");
//            for(int j = 0; j < m; j++){
//                array[i][j] = Integer.parseInt(lines[j]);
//            }
//        }
//        String cals = sc.nextLine();
//        String calArr[] = cals.split(" ");
//        for(int i = 0; i < cals.split(" ").length; i++){
//            cal.add( Integer.parseInt(calArr[i]));
//        }
//
//        fun[1] = Problem16935::calOne;
//        fun[2] = Problem16935::calTwo;
//        fun[3] = () -> calThree(array);
//        fun[4] = () -> calFour(array);
//        fun[5] = () -> calFive(array);
//        fun[6] = () -> calSix(array);
//
//
//        for(int i = 0; i < count; i++){
//            for(int index = 0; index < cal.size(); index++){
//
//                fun[cal.get(index)].run();
//            }
//        }
//
//
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    static void calOne(){
//        for (int i = 0; i < array.length / 2; i++) {
//            int[] temp = array[i];
//            array[i] = array[array.length - i - 1];
//            array[array.length - i - 1] = temp;
//        }
//    }
//
//    static void calTwo(){
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length / 2; j++) {
//                int temp = array[i][j];
//                array[i][j] = array[i][array[i].length - j - 1];
//                array[i][array[i].length - j - 1] = temp;
//            }
//        }
//    }
//
//    static void calThree(int[][] inputArray){
//        int[][] rotate = new int[inputArray[0].length][inputArray.length];
//        for (int i = 0; i < inputArray.length; i++) {
//            for (int j = 0; j < inputArray[i].length; j++) {
//                rotate[j][inputArray.length - i - 1] = inputArray[i][j];
//            }
//        }
//        array = rotate;
//    }
//
//    static void calFour(int[][] inputArray){
//
//        int[][] rotate = new int[inputArray[0].length][inputArray.length];
//        for (int i = 0; i < inputArray.length; i++) {
//            for (int j = 0; j < inputArray[i].length; j++) {
//                rotate[inputArray[i].length - j - 1][i] = inputArray[i][j];
//            }
//        }
//        array = rotate;
//    }
//
//    static void calFive(int[][] inputArray){
//
//        int[][] temp = new int[n][m];
//
//        for (int i = 0; i < n / 2; i++) {
//            for (int j = 0; j < m / 2; j++) {
//                temp[i][j + m / 2] = inputArray[i][j];
//            }
//        }
//
//        for (int i = 0; i < n / 2; i++) {
//            for (int j = m / 2; j < m; j++) {
//                temp[i + n / 2][j] = inputArray[i][j];
//            }
//        }
//
//        for (int i = n / 2; i < n; i++) {
//            for (int j = m / 2; j < m; j++) {
//                temp[i][j - m / 2] = inputArray[i][j];
//            }
//        }
//
//        for (int i = n / 2; i < n; i++) {
//            for (int j = 0; j < m / 2; j++) {
//                temp[i - n / 2][j] = inputArray[i][j];
//            }
//        }
//
//        array = temp;
//
//    }
//
//    static void calSix(int[][] inputArray){
//        int[][] temp = new int[n][m];
//
//        for (int i = 0; i < n / 2; i++) {
//            for (int j = 0; j < m / 2; j++) {
//                temp[i + n / 2][j] = inputArray[i][j];
//            }
//        }
//
//        for (int i = n / 2; i < n; i++) {
//            for (int j = 0; j < m / 2; j++) {
//                temp[i][j + m / 2] = inputArray[i][j];
//            }
//        }
//
//        for (int i = n / 2; i < n; i++) {
//            for (int j = m / 2; j < m; j++) {
//                temp[i - n / 2][j] = inputArray[i][j];
//            }
//        }
//
//        for (int i = 0; i < n / 2; i++) {
//            for (int j = m / 2; j < m; j++) {
//                temp[i][j - m / 2] = inputArray[i][j];
//            }
//        }
//
//        array = temp;
//    }
//}

~~~
