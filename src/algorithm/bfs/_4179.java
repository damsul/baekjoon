package algorithm.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _4179 {

    public static String[][] board = new String[1001][1001]; // 그림판
    public static int[][] dist1 = new int[1001][1001]; // 불 거리 저장 배열
    public static int[][] dist2 = new int[1001][1001]; // 지훈 거리 저장 배열
    public static int[] dx = {0, 0, -1, 1}; // 상하좌우
    public static int[] dy = {1, -1, 0, 0}; // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int M = Integer.parseInt(st[0]); // 행
        int N = Integer.parseInt(st[1]); // 열

        Queue<Point> q1 = new LinkedList<>(); // 불
        Queue<Point> q2 = new LinkedList<>(); // 지훈

        for (int i = 0; i < M; i++) {
            st = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                dist1[i][j] = -1;
                dist2[i][j] = -1;

                board[i][j] = st[j];
                if (board[i][j].equals("F")) {
                    dist1[i][j] = 0;
                    q1.add(new Point(i, j));
                } else if (board[i][j].equals("J")) {
                    dist2[i][j] = 0;
                    q2.add(new Point(i, j));
                }
            }
        }

        while (!q1.isEmpty()) {
            Point cur = q1.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }
                if (dist1[nx][ny] >= 0 || board[nx][ny].equals("#")) {
                    continue;
                }

                dist1[nx][ny] = dist1[cur.x][cur.y] + 1;
                q1.add(new Point(nx, ny));
            }
        }

        while (!q2.isEmpty()) {
            Point cur = q2.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    System.out.println(dist2[cur.x][cur.y] + 1);
                    return;
                }
                if (dist2[nx][ny] >= 0 || board[nx][ny].equals("#")) {
                    continue;
                }
                if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.x][cur.y] + 1) {
                    continue;
                }
                dist2[nx][ny] = dist2[cur.x][cur.y] + 1;
                q2.add(new Point(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

}
