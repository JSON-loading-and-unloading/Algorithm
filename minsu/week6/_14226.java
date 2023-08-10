import java.util.*;
import java.io.*;
public class _14226 {

    public static int N;
    public static boolean[][] visited;
    public static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        visited=new boolean[2001][2001];
        result=0;
        bfs();
        System.out.println(result);

    }
    public static void bfs(){
        Queue<Node> que=new LinkedList<>();
        que.offer(new Node(1,0,0));

        while(!que.isEmpty()){
            Node current=que.poll();
            int eN=current.emoticonNum;
            int cN=current.clipboardNum;
            int t=current.time;
            if(eN==N){
                result=t;
                return;
            }
            //복사
            if(eN>0&&eN<2000&&!visited[eN][eN]) {
                visited[eN][eN]=true;
                que.offer(new Node(eN,eN,t+1));
            }
            //붙여넣기
            if(cN>0&&eN+cN<2000&&!visited[eN+cN][cN]){
                visited[eN+cN][cN]=true;
                que.offer(new Node(eN+cN,cN,t+1));
            }
            //삭제
            if(eN>0&&eN<2000&&!visited[eN-1][cN]){
                visited[eN-1][cN]=true;
                que.offer(new Node(eN-1, cN, t+1));
            }
        }

    }
    public static class Node{
        int emoticonNum;
        int clipboardNum;
        int time;
        public Node(int emoticonNum, int clipboardNum, int time){
            this.emoticonNum=emoticonNum;
            this.clipboardNum=clipboardNum;
            this.time=time;
        }
    }
}
