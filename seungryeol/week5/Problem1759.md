import java.util.*;


public class Problem1759 {
    static char[] alphabetArray;
    static int  inputLength;
    static int length;
    static ArrayList<String> result = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        length = sc.nextInt();
        inputLength = sc.nextInt();

        sc.nextLine();

        String alphabet = sc.nextLine();

        alphabetArray = new char[inputLength];

        for(int i = 0; i < inputLength; i++){
            alphabetArray[i] = alphabet.charAt(2*i);
        }

        Arrays.sort(alphabetArray);
        listArray(length,0, new char[length]);
        for (String results : result) {
            System.out.println(results);
        }


    }

    static void listArray(int le,int start,char[] noMean){
        if(le == 0){
            if (check(noMean)) {
                result.add(new String(noMean));
            }
            return;
        }
        for(int i = start; i <= alphabetArray.length - le; i++){
            noMean[noMean.length - le ] = alphabetArray[i];
            listArray(le-1,i+1,noMean);
        }
    }

    static boolean check(char[] arr) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (char c : arr) {
            if (isVowel(c)) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }
        return vowelCount >= 1 && consonantCount >= 2;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}

//    1.main 메서드:
//
//        입력으로 주어진 length와 inputLength에 관계없이, alphabetArray 배열에 inputLength개의 알파벳이 저장됩니다. 이 부분의 시간 복잡도는 O(inputLength)입니다.
//        Arrays.sort(alphabetArray)를 수행하는 부분의 시간 복잡도는 O(inputLength * log(inputLength))입니다. (퀵소트 기반의 정렬 알고리즘)
//        listArray 메서드를 호출하는 부분의 시간 복잡도는 O(length)입니다.
//    2.listArray 메서드:
//
//        재귀 호출이 이루어지는 부분의 시간 복잡도를 분석하겠습니다. listArray 메서드에서 재귀 호출은 le값이 0이 될 때까지 이루어집니다. 각 호출에서 반복문이 alphabetArray 배열을 순회하며 해당 원소를 선택하고 다음 호출을 하므로, 시간 복잡도는 다음과 같습니다:
//        첫 번째 호출: O(inputLength)
//        두 번째 호출: O(inputLength - 1)
//        세 번째 호출: O(inputLength - 2)
//        ...
//        마지막 호출(le = 0): O(1)
//        이러한 재귀 호출은 총 length번 이루어집니다. 따라서 전체 listArray 메서드의 시간 복잡도는 대략적으로 O(inputLength * length)입니다.
//        따라서 전체 코드의 시간 복잡도는 대략적으로 O(inputLength * log(inputLength) + inputLength * length)입니다. 이때, inputLength와 length의 값에 따라 실행 시간이 크게 영향을 받습니다. 

