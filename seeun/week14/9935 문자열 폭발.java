import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
        int bombSize = bomb.length();
		
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			st.push(str.charAt(i));
			
			// 폭발 문자열과 길이가 같아지면 탐색 시작 
			if(st.size() >= bombSize) {
				boolean isSame = true;
				
				//bomb와 일치하면 제거 
				for(int j = 0; j < bombSize; j++) {
					if(st.get(st.size() - bombSize + j) != bomb.charAt(j)) {
						isSame = false;
						continue;
					}
				}
				if(isSame) {
					for(int j = 0; j < bombSize; j++) {
						st.pop();
					}
				}
			}
			
		}
        
        //StringBuilder 사용 안하면 시간초과 발생 
        StringBuilder sb = new StringBuilder();
		for(Character c : st) {
			sb.append(c);
		}
		System.out.println(sb.length()==0? "FRULA" : sb.toString());		
	}
}