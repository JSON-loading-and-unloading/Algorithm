import java.util.*;
public class Problem11054 {
    static int max = 0;
    static int N;
    static int[] bytonicArray;
    static int up[];
    static int down[];

    public static void main(String[] args) {

        String number;
        String numberString[];

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        bytonicArray = new int[N];
        up = new int[N];
        down = new int[N];

        sc.nextLine();
        number = sc.nextLine();
        numberString = number.split(" ");

        for(int i = 0; i < N; i++){
            bytonicArray[i] = Integer.parseInt(numberString[i]);
        }

        getUp();
        getDown();

        for (int i = 0; i < N; i++) {
            int length = up[i] + down[i] - 1;
            if (length > max) {
                max = length;
            }
        }


        System.out.println(max);

    }

    public static void getUp(){

        for(int i = 0; i<N; i++){
            up[i] = 1;
            for(int j = 0; j<i; j++){
                if(bytonicArray[i] > bytonicArray[j] && up[i] < up[j] + 1){
                    up[i] = up[j] + 1;
                }
            }
        }
    }

    public static void getDown(){

        for(int i = N - 1; i>= 0; i--){
            down[i] = 1;
            for(int j = N - 1; j>i; j-- ){
                if(bytonicArray[i] > bytonicArray[j] && down[i] < down[j] + 1){
                    down[i] = down[j] + 1;
                }
            }
        }

    }
}

<!-- getUp() 함수와 getDown() 함수는 각각 배열의 요소들에 대해 최대 증가 부분 수열과 최대 감소 부분 수열을 계산하는 함수입니다. 이 두 함수의 시간 복잡도는 O(N^2)입니다. 각 요소마다 이전 요소들을 비교하여 최대 증가 부분 수열과 최대 감소 부분 수열을 구하기 때문입니다.

따라서 getUp() 함수와 getDown() 함수를 호출하는 부분에서의 시간 복잡도는 모두 O(N^2)입니다. 이 부분은 반복문이 두 번 중첩되기 때문에 시간 복잡도가 O(N^2)이 됩니다.

따라서 전체 코드의 시간 복잡도는 O(N^2)입니다. 이 코드에서 N의 크기가 커지면 계산 시간이 크게 증가하게 됩니다. N이 큰 경우에는 더 효율적인 알고리즘을 사용하는 것이 좋을 수 있습니다. -->