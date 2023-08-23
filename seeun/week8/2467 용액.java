import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
		int[]arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

    int i = 0 , j = n - 1; // 기본적으로 -,+ 조합이어야 0에 가까우므로 일단 가장 작은 값(-), 가장 큰 값(+) 에서 점점 범위 좁히기
    int alkali = 0 , acid = n - 1;
		int min = 2000000001; // 1000000000, 1000000000 인 경우가 가장 크기 때문에 min 값 2000000001
		while(i <= j)
		{
			int val = arr[i] + arr[j];
			if(i != j && Math.abs(arr[i] + arr[j]) < min)
			{
				alkali = i;
				acid = j;
				min = Math.abs(val);
			}
			if(val >= 0) // 값이 0보다 크면 현재 숫자보다 작은 숫자 고르기
				j--;
			else // 값이 0보다 작으면 현재 숫자보다 큰 숫자 고르기
				i++;
		}
		System.out.println(arr[alkali] + " " + arr[acid]);
	}

}