import java.util.*;


public class Problem14499 {

    static int n,m;
    static int x,y;
    static int command;
    static int array[][];
    static int commandArray[];
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};



    static int[] jusagi = new int[7];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        command = sc.nextInt();

        sc.nextLine();

        array = new int[n][m];
        commandArray = new int[command];

        for(int i = 0; i < n; i++){

            String line = sc.nextLine();
            String[] lineArray = line.split(" ");

            for(int j = 0; j < m; j++){

                array[i][j] = Integer.parseInt(lineArray[j]);
            }
        }

        String commandLine = sc.nextLine();
        String commandLineArray[] = commandLine.split(" ");

        for(int i = 0; i < command; i++){
            commandArray[i] = Integer.parseInt(commandLineArray[i]);
        }

        for(int i = 0; i < command; i++){

            int com = commandArray[i] - 1;
            int xx = x + moveX[com];
            int yy = y + moveY[com];

            if (xx < 0 || xx >= n || yy < 0 || yy >= m) {
                continue;
            }

            move(com);

            if (array[xx][yy] == 0) {
                array[xx][yy] = jusagi[6];
            } else {
                jusagi[6] = array[xx][yy];
                array[xx][yy] = 0;
            }

            x = xx;
            y = yy;

            System.out.println(jusagi[1]);

        }
    }

    static void move(int com) {
        int[] temp = jusagi.clone();

        if (com == 0) {
            jusagi[1] = temp[4];
            jusagi[3] = temp[1];
            jusagi[4] = temp[6];
            jusagi[6] = temp[3];
        } else if (com == 1) {
            jusagi[1] = temp[3];
            jusagi[3] = temp[6];
            jusagi[4] = temp[1];
            jusagi[6] = temp[4];
        } else if (com == 2) {
            jusagi[1] = temp[5];
            jusagi[2] = temp[1];
            jusagi[5] = temp[6];
            jusagi[6] = temp[2];
        } else {
            jusagi[1] = temp[2];
            jusagi[2] = temp[6];
            jusagi[5] = temp[1];
            jusagi[6] = temp[5];
        }
    }
}
