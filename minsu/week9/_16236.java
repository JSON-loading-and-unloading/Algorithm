import java.io.*;
import java.util.*;

public class _16236 {
    // 상하좌우 이동을 위한 배열
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 공간의 크기를 입력받는다.

        map = new int[N][N];
        int[] sharkPos = null;  // 아기 상어의 초기 위치

        // 맵 정보 입력 및 아기 상어 위치 설정
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    sharkPos = new int[]{i, j};
                    map[i][j] = 0;  // 아기 상어 위치 초기화
                }
            }

        int sharkSize = 2;  // 아기 상어 초기 크기
        int eatenFishCount = 0;  // 먹은 물고기 수
        int totalMovedDistance = 0;  // 움직인 총 거리

        // 아기 상어가 먹을 수 있는 물고기를 찾는다.
        while (true) {
            int[] nextFish = getNextFish(N, sharkPos, sharkSize);
            if (nextFish == null) break;  // 더 이상 먹을 수 있는 물고기가 없으면 종료

            map[nextFish[0]][nextFish[1]] = 0;  // 먹은 물고기 위치 초기화
            totalMovedDistance += nextFish[2];  // 총 움직인 거리 증가
            sharkPos = new int[]{nextFish[0], nextFish[1]};  // 아기 상어 위치 갱신

            // 물고기를 먹은 수가 아기 상어의 크기와 같다면 크기 증가
            if (++eatenFishCount == sharkSize) {
                sharkSize++;
                eatenFishCount = 0;
            }
        }

        System.out.println(totalMovedDistance);  // 결과 출력
    }

    // 아기 상어의 현재 위치에서 먹을 수 있는 가장 가까운 물고기의 위치를 반환하는 메서드
    public static int[] getNextFish(int N, int[] startPos, int sharkSize) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);  // 거리가 짧은 순서
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);  // 위쪽에 있는 순서
            return Integer.compare(a[1], b[1]);  // 왼쪽에 있는 순서
        });

        boolean[][] visited = new boolean[N][N];
        que.add(new int[]{startPos[0], startPos[1], 0});  // 현재 위치 큐에 삽입
        visited[startPos[0]][startPos[1]] = true;  // 현재 위치 방문 표시

        while (!que.isEmpty()) {
            int[] current = que.poll();

            // 현재 위치에 있는 물고기 크기가 아기 상어 크기보다 작으면 해당 위치 반환
            if (map[current[0]][current[1]] > 0 && map[current[0]][current[1]] < sharkSize) {
                return current;
            }

            // 상하좌우로 이동 가능한 위치를 큐에 삽입
            for (int i = 0; i < 4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || map[ny][nx] > sharkSize)
                    continue;  // 이동 불가능한 위치면 스킵

                que.add(new int[]{ny, nx, current[2] + 1});
                visited[ny][nx] = true;  // 해당 위치 방문 표시
            }
        }

        return null; // 더 이상 먹을 수 있는 물고기가 없으면 null 반환
    }
}

