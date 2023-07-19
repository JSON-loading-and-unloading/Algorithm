package jinwoo.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
		int ans = 0;
		int S[] = new int[N];
		int up[] = new int[N];
		int down[] = new int[N];

        st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}

		// 상승
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (S[j] < S[i]) {
					max = Math.max(max, up[j]);
				}
			}
			up[i] = max + 1;
		}

		// 하강
		for (int i = N-1; i >= 0; i--) {
			int max = 0;
			for (int j = N-1; j > i; j--) {
				if (S[j] < S[i]) {
					max = Math.max(max, down[j]);
				}
			}
			down[i] = max + 1;
		}

		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, up[i]+down[i]);
		}
		
		System.out.println(ans-1); //중복제거
	}
}
