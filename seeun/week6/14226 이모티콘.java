import java.io.*;
import java.util.*;

public class Main{
    static int s;
    static boolean[][] visited = new boolean[2001][2001];// [화면에 있는 이모티콘 수][클립보드에 있는 이모티콘 수]
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        Queue<Emotion> q = new LinkedList<>();
        
        // 이미 화면에 이모티콘 1개를 입력했다고 했으니 화면 1개, 클립보드 0개, 0초
        q.offer(new Emotion(1, 0, 0));
        visited[1][0] = true;
        
        int rslt = 0;
        while(!q.isEmpty()){
            Emotion e = q.poll();
            if(e.screen == s){
                rslt = e.time;
                break;
            }
            
            // 클립보드 -> 화면 
            // 클립보드에 있는 값이 0이 아니고 화면 복사 시의 경우가 이미 진행된 경우가 아니며(e.screen + e.clip)
            // 화면 출력 되는 개수가 1000이하인 경우에 가능
            if(e.clip != 0 && !visited[e.screen + e.clip][e.clip] && e.screen + e.clip <= 1000){
                q.offer(new Emotion(e.screen + e.clip, e.clip, e.time+1));
                visited[e.screen+e.clip][e.clip] = true;
            }
            
            // 화면 -> 클립보드
            // 화면과 클립보드의 이모티콘 개수가 다르고 복사 시의 상태가 이미 진행된 경우가 아닌 경우
            // 클립보드는 복사하면 덮어쓰기를 하므로 e.screen
            if(e.screen != e.clip && !visited[e.screen][e.screen]){
                q.offer(new Emotion(e.screen, e.screen, e.time+1));
                visited[e.screen][e.screen] = true;
            }
            
            // 현재 화면에 있는 이모티콘 1개를 삭제
            if(e.screen > 0 && !visited[e.screen-1][e.clip]){
                q.offer(new Emotion(e.screen-1, e.clip, e.time+1));
                visited[e.screen-1][e.clip] = true;
            }
        }
        System.out.println(rslt);
    }
}

class Emotion{
    int screen;
    int clip;
    int time;
    public Emotion(int screen, int clip, int time){
        this.screen = screen;
        this.clip = clip;
        this.time = time;
    }
}