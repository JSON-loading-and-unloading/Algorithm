import java.util.*;
import java.io.*;
public class _13549 {
    public static int current, target;
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        current=Integer.parseInt(st.nextToken());
        target=Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(result);
    }
    public static void bfs(){
        result= Integer.MAX_VALUE;
        boolean[] visited=new boolean[200000];
        Queue<Node> que=new LinkedList<>();
        que.offer(new Node(current,0));
        visited[current]=true;

        while(!que.isEmpty()){
            Node now=que.poll();
            int position=now.position;
            int time=now.time;

            if(position==target){
                result=Math.min(result,time);
            }
            visited[position]=true;

            //x+1로 이동
            if(position+1<200000&&!visited[position+1]){
                que.offer(new Node(position+1,time+1));
            }
            //x-1로 이동
            if(position>0&&!visited[position-1]){
                que.offer(new Node(position-1, time+1));
            }
            //2*x로 이동
            if(position*2<200000&&!visited[position*2]){
                que.offer(new Node(position*2, time));
            }
        }
    }
    public static class Node{
        int position;
        int time;

        public Node(int position, int time){
            this.position=position;
            this.time=time;
        }
    }
}
