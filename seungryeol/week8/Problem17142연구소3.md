import java.util.*;
import java.io.*;

public class Problem17142 {
    static int n, m;
    static int[][] map;
    static List<Point> viruses = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int emptySpace = 0;
    static int minTime = Integer.MAX_VALUE;
    static Point[] active;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        active = new Point[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    viruses.add(new Point(i, j, 0));
                } else if (map[i][j] == 0) {
                    emptySpace++;
                }
            }
        }

        if (emptySpace == 0) {
            System.out.println(0);
        } else {
            chooseVirus(0, 0);
            System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
        }
    }

    static void chooseVirus(int start, int selectCount) {
        if (selectCount == m) {
            spreadVirus(emptySpace);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            active[selectCount] = viruses.get(i);
            chooseVirus(i + 1, selectCount + 1);
        }
    }

    static void spreadVirus(int emptySpace) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] infected = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            Point virus = active[i];
            infected[virus.x][virus.y] = true;
            q.add(virus);
        }

        while (!q.isEmpty()) {
            Point virus = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (infected[nx][ny] || map[nx][ny] == 1) continue;

                if (map[nx][ny] == 0) {
                    emptySpace--;
                }

                if (emptySpace == 0) {
                    minTime = Math.min(minTime, virus.time + 1);
                    return;
                }

                infected[nx][ny] = true;
                q.add(new Point(nx, ny, virus.time + 1));
            }
        }

    }

    static class Point {
        int x;
        int y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}