package week6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int goal = sc.nextInt();
        int[][] visit = new int[goal * 2][goal * 2];
        // 화면, 클립보드 이모티콘 개수에 따른 몇초인지 저장
        for (int i = 0; i < goal * 2; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
            // 각 행을 반복하며 초기화 (방문x)
        }

        Queue<Emoticon> queue = new LinkedList<>();
        //bfs를 위해 queue 생성
        queue.add(new Emoticon(1, 0));
        visit[1][0] = 0;

        while (!queue.isEmpty()) {
            Emoticon current = queue.poll();
            int screen = current.screen;
            int clipboard = current.clipboard;

            if (screen == goal) {
                // queue를 사용하기 때문에 나오는 순간이 가장 빠른 순간
                System.out.println(visit[screen][clipboard]);
                break;
            }

            // 이모티콘 복사 -> 화면이모티콘 클립보드에 넣을 경우
            if (visit[screen][screen] == Integer.MAX_VALUE) {
                visit[screen][screen] = visit[screen][clipboard] + 1;
                queue.add(new Emoticon(screen, screen));
            }

            // 이모티콘 추가 -> 클립보드에서 꺼내 더할 경우
            if (screen + clipboard <= goal && visit[screen + clipboard][clipboard] == Integer.MAX_VALUE) {
                visit[screen + clipboard][clipboard] = visit[screen][clipboard] + 1;
                queue.add(new Emoticon(screen + clipboard, clipboard));
            }

            // 이모티콘 삭제 -> 하나 삭제할 경우
            if (screen - 1 >= 0 && visit[screen - 1][clipboard] == Integer.MAX_VALUE) {
                visit[screen - 1][clipboard] = visit[screen][clipboard] + 1;
                queue.add(new Emoticon(screen - 1, clipboard));
            }
        }
    }

    static class Emoticon {
        int screen;
        int clipboard;

        public Emoticon(int screen, int clipboard) {
            this.screen = screen;
            this.clipboard = clipboard;
        }
    }
}


