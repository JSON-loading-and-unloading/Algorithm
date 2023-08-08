package jinwoo.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1759 {
    static int L;
    static int C;
    static char[] arr;
    static char[] ans;
      public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        ans = new char[L];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        
        for(int i=0; i<=C-L; i++){
            dfs(i,0);
        }

      }

      static void dfs(int x, int length) {
            if(x>=C) return; //주어진 문자배열 범위를 벗어날 때
            
            ans[length] = arr[x];
            if(length>=L-1) { //문자 길이 벗어날 때
                if(check()) {
                    for(int j=0; j<L; j++) {
                    System.out.print(ans[j]);
                    }
                    System.out.println();
                }
                return;
            }

            for(int i=x; i<C; i++) {
                dfs(i+1,length+1);
            } 
      }

      static boolean check(){
            int vowel = 0;
            int consonant = 0;

            for(int i=0; i<L; i++) {
                if(ans[i]=='a' || ans[i]=='e' || ans[i]=='i' || ans[i]=='o' || ans[i]=='u'){
                    vowel ++;
                }else {
                    consonant ++;
                }
            }
            if(vowel >=1 && consonant >=2) return true;
            else return false;
      }
}
