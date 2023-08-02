import java.util.*;
import java.io.*;
public class _1759 {
    public static int L,C;
    public static char[] input;
    public static char[] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine(), " ");
        L=Integer.parseInt(st.nextToken()); //만들어야 하는 문자열 길이
        C=Integer.parseInt(st.nextToken()); //input 문자열 길이

        st=new StringTokenizer(br.readLine(), " ");
        input=new char[C];
        result=new char[L];

        for(int i=0;i<C;i++){
            input[i]=st.nextToken().charAt(0);
        }

        Arrays.sort(input);
        combination(0,0);


    }
    public static void combination(int depth, int start){
        if(depth==L){
            if(check(result)){
                for(char c:result){
                    System.out.print(c);
                }
                System.out.println();
            }
            return;
        }
        for(int i=start;i<C;i++){
            result[depth]=input[i];
            combination(depth+1, i+1);
        }
    }
    public static boolean check(char[] chars){//모음은 최소 1개, 자음은 최소 2개
        int vowelNum=0;
        int consonantNum=0;

        for(int i=0;i<chars.length;i++){
           if(chars[i]=='a'||chars[i]=='i'||chars[i]=='o'||chars[i]=='e'||chars[i]=='u')
               vowelNum++;
           else
               consonantNum++;
        }
        if(vowelNum>=1&&consonantNum>=2)
            return true;
        else
            return false;

    }
}
