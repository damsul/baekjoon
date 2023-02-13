package algorithm.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2178 {
    public static int[][] board = new int[101][101]; // 그림판
    public static int[][] dist = new int[101][101]; // 거리 저장 배열
    public static int[] dx = {0, 0, -1, 1}; // 상하좌우
    public static int[] dy = {1, -1, 0, 0}; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        for (int i = 1; i <= N; i++) {
            st = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st[j - 1]);
                dist[i][j] = -1;
            }
        }

        Queue<Point> q = new LinkedList<>();
        dist[1][1] = 1;
        q.add(new Point(1, 1));
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 1 || ny < 1 || nx > N || ny > M) {
                    continue;
                }
                if (dist[nx][ny] >= 0 || board[nx][ny] == 0) {
                    continue;
                }

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Point(nx, ny));
            }
        }

        System.out.println(dist[N][M]);

    }

}
