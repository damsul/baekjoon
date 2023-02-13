package algorithm.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _10026 {

    public static char[][] board = new char[101][101];
    public static boolean[][] visited = new boolean[101][101];
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int N;

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] || board[nx][ny] != board[cur.x][cur.y]) continue;

                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) { // 그림 그리기
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                board[i][j] = ch[j];
            }
        }

        int num1  = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;

                if (board[i][j] == 'R') {
                    num1++;
                    bfs(i, j);
                }
                if (board[i][j] == 'G') {
                    num1++;
                    bfs(i, j);
                }
                if (board[i][j] == 'B') {
                    num1++;
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false); // 초기화
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'R') { // R == G 초기화
                    board[i][j] = 'G';
                }
            }
        }

        int num2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;

                if (board[i][j] == 'G') {
                    num2++;
                    bfs(i, j);
                }
                if (board[i][j] == 'B') {
                    num2++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(num1 + " " + num2);
    }

}
