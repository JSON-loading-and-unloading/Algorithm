import java.io.*;
import java.util.*;

public class Main {
    
    static char[][] arr = new char[5][5];

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] X = new int[25];
    static int[] Y = new int[25];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<5; i++){
           arr[i] = br.readLine().toCharArray();
        }
        
        for(int i=0; i<25; i++){
            X[i] = i % 5; // 뽑는 숫자에 대해 x 좌표 변환 
            Y[i] = i / 5; // 뽑는 숫자에 대해 y 좌표 변환 
        }

        Comb(new int[7], 0,0,7);
        System.out.println(answer);
    }

    //25개중 7개 뽑기
    public static void Comb(int[] combination, int index, int count, int r){

        if(r == 0){ // 7개 다 선택하면 BFS 실행
            BFS(combination); 
            return;
        }

        if(count == 25) return; //25개 다 확인했으면 끝

        combination[index] = count;
        Comb(combination, index+1, count+1, r-1); // 선택
        Comb(combination, index, count+1, r); // 선택 안하고 그 다음거 선택
    }

    public static void BFS(int[] comb){

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[7];

        q.add(comb[0]);
        int cnt = 1, cntS = 0;

        while (!q.isEmpty()){
            int seat = q.poll();
            if(arr[X[seat]][Y[seat]] == 'S') cntS++; //S가 있으면 cntS 증가 

            for(int i = 0; i < 4; i++){
                for(int j = 1; j < 7; j++){ // 7개 다 무조건 연결되어야 하므로 첫번째 고정하고, 6개만 비교

                    // 첫 방문인지, 연결되어 있는지 확인 
                    if(!visited[j] && X[seat]+dx[i] == X[comb[j]] && Y[seat]+ dy[i] == Y[comb[j]]){
                        visited[j] = true;
                        q.add(comb[j]);
                        cnt++;
                    }

                }
            }

        }
        if(cnt == 7){
            if(cntS >= 4){
                answer++;
            }
        }
    }
}