import java.util.*;


public class Problem2133 {
    static int tile[];
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tile = new int[N+1];

        if(N%2==1){
            System.out.println(0);
            return;
        }

        tile[0] = 1;

        for(int i = 2; i <= N; i = i + 2){

            tile[i] = 3 * tile[i-2];

            for(int j = 4; j <= i; j = j + 2){
                tile[i] = tile[i] + 2*tile[i-j];
            }
        }
        System.out.println(tile[N]);
    }
}


<!-- 주어진 코드는 동적 계획법(Dynamic Programming)을 사용하여 문제를 풀고 있습니다. 이 코드의 시간 복잡도를 분석해보겠습니다.

주어진 직사각형의 너비를 N이라고 하면, 반복문의 횟수는 N/2번입니다. 따라서 반복문의 시간 복잡도는 O(N)입니다.

반복문 안에서 tile[i] 값을 구하는 과정에서 다시 한 번 반복문이 사용됩니다. 이 안쪽 반복문은 최대 i/2번 수행되는데, i는 N/2까지 증가하므로 최악의 경우에는 O(N^2)의 시간 복잡도를 가집니다.

따라서 전체 코드의 시간 복잡도는 O(N^2)입니다. 입력 크기 N에 대해 이 코드는 비교적 빠르게 동작할 수 있습니다. 다만, N이 큰 경우에는 O(N^2) 시간 복잡도로 인해 실행 시간이 길어질 수 있으므로 최적화가 필요할 수 있습니다. -->