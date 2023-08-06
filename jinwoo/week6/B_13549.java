package jinwoo.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
    int x; //좌표
    int s; //시간

    Info(int x, int s) {
        this.x = x;
        this.s = s;
    }

    @Override
    public int compareTo(Info o) {
        if (this.s < o.s) return -1;
        if  (this.s > o.s) return 1;
        else return 0;
    }

}

public class B_13549 {
    public static void main(String[] args) throws IOException {
    PriorityQueue<Info> queue = new PriorityQueue<>(); //걸린 시간이 짧은 것이 우선순위이다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    boolean[] chk = new boolean[100001];

    queue.add(new Info(N,0));

    while(!queue.isEmpty()) {
        Info info = queue.poll();
        if(info.x < 0 || info.x>100000 || chk[info.x]) continue;
        if(info.x==K) {
            System.out.println(info.s);
            break;
        }
        chk[info.x] = true;
        queue.add(new Info((info.x-1), info.s+1));
        queue.add(new Info((info.x+1), info.s+1));
        queue.add(new Info((info.x*2), info.s));
    }

}
}
