package jinwoo.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Position {
    int r;
    int c;

    Position(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class B_15686 {
    static int N, M;
    static ArrayList<Position> house = new ArrayList<>(); // 집 좌표 저장
    static ArrayList<Position> chicken = new ArrayList<>(); // 치킨집 좌표 저장
    static Integer ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // 집과 치킨집 좌표 저장
    for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());

        for(int j=0; j<N; j++) {
            int n = Integer.parseInt(st.nextToken());

            if(n == 1) {
                house.add(new Position(i, j));
            }

            if(n == 2) {
                chicken.add(new Position(i, j));
            }   
        }
    }

    boolean[] visited = new boolean[chicken.size()];

    //조합구하기
    combination(visited, 0, chicken.size(), M);

    //최소거리 합 출력
    System.out.println(ans);
    }

    static void combination(boolean[] visited, int start, int n, int r) {
        if(r == 0) { // 조합
            ans = Math.min(ans , getMin(visited));
            return;
        } 
    
        for(int i=start; i<n; i++) {
            visited[i] = true;

            combination(visited, i + 1, n, r - 1);

            visited[i] = false;
        }
    }

    // 모든 집의 치킨 거리 합 구하기
    static int getMin(boolean[] visited) {
        int result = 0;
        for(int i=0; i < house.size(); i++) { 
            int ir = house.get(i).r;
            int ic = house.get(i).c;
            Integer temp = Integer.MAX_VALUE;
            for(int j=0; j<chicken.size(); j++) {
                if(visited[j]) { // 조합으로 선택된 것만
                    int jr = chicken.get(j).r;
                    int jc = chicken.get(j).c;

                    temp = Math.min(temp, Math.abs(ir - jr) + Math.abs(ic - jc)); 
                }
            }

            result += temp;
        }

        return result;
    }


}
