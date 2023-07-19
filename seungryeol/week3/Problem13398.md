import java.util.*;

public class Problem133988 {
    static int N;
    static int[] sequenceArray;
    static int[] sequence;
    static int[] subSequence;
    static int max;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        sequenceArray = new int[N];
        sequence = new int[N];
        subSequence = new int[N];

        for(int i = 0; i < N; i++){
            sequenceArray[i] = sc.nextInt();
        }

        sequence[0] = sequenceArray[0];
        subSequence[0] = 0;
        max = sequenceArray[0];

        for(int i = 1; i < N; i++){
            sequence[i] = Math.max(sequenceArray[i],sequence[i-1] + sequenceArray[i] );
            subSequence[i] = Math.max(sequence[i-1], subSequence[i-1]+sequenceArray[i] );
            max = Math.max(max,Math.max(sequence[i],subSequence[i]) );
        }
        System.out.println(max);
    }
}

<!-- 주어진 코드에서 반복문을 하나만 사용하고 있으므로 시간 복잡도는 O(N)입니다. 배열의 크기에 비례해서 선형적으로 증가합니다. 따라서 전체 코드의 시간 복잡도는 O(N)입니다.

이 코드는 효율적인 알고리즘을 사용하여 입력 배열의 부분 수열 중에서 가장 큰 값을 빠르게 구할 수 있습니다. 따라서 입력 배열의 크기가 커지더라도 계산 시간이 비교적 적게 증가하게 됩니다. -->
