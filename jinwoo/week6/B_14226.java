package jinwoo.week6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Step {
    int screenNum;
    int clipBoardNum;
    int time;

    Step(int sN, int cN, int t) {
        this.screenNum = sN;
        this.clipBoardNum = cN;
        this.time = t;
    }
}
public class B_14226 {

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Queue<Step> queue = new LinkedList<>();

    boolean[][] chk = new boolean[1001][1001]; // 행은 화면 이모티콘 개수, 열은 클립보드의 이모티콘 개수


    int N = sc.nextInt();

    queue.add(new Step(1,0,0));
    queue.add(new Step(0,0,0));
    queue.add(new Step(-1,0,0));

    while(!queue.isEmpty()) {
        Step s = queue.poll();

        if(s.screenNum < 0 || s.screenNum >1000) continue;
        if(s.screenNum == 0 && s.clipBoardNum ==0) continue; // 클립보드가 비어있을 때 붙여넣기 할 수 없다. 
        if(chk[s.screenNum][s.clipBoardNum]) continue; 

        if(s.screenNum == N) {
            System.out.println(s.time);
            break;
        }

        chk[s.screenNum][s.clipBoardNum] = true; //메모이제이션

        queue.add(new Step(s.screenNum, s.screenNum, s.time+1));
        queue.add(new Step(s.screenNum + s.clipBoardNum, s.clipBoardNum, s.time+1));
        queue.add(new Step(s.screenNum-1, s.clipBoardNum, s.time+1));
    }

    sc.close();
    }
}
