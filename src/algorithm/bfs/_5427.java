package algorithm.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5427 {

    public static char[][] board = new char[1001][1001];
    public static int[][] dist1 = new int[1001][1001]; // 불
    public static int[][] dist2 = new int[1001][1001]; // 상근이
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int M, N;
   public static Queue<Point> q1; // 불
   public static Queue<Point> q2; // 상근이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                Arrays.fill(dist1[i], -1);
                Arrays.fill(dist2[i], -1);
            }
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();

            for (int i = 0; i < N; i++) { // 건물 구조 그리기
                board[i] = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == '*') {
                        dist1[i][j] = 0;
                        q1.add(new Point(i, j));
                    }
                    if (board[i][j] == '@') {
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

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (dist1[nx][ny] >= 0 || board[nx][ny] == '#') continue;

                    dist1[nx][ny] = dist1[cur.x][cur.y] + 1;
                    q1.add(new Point(nx, ny));
                }
            }
            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    public static String bfs() {
        while (!q2.isEmpty()) {
            Point cur = q2.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    return dist2[cur.x][cur.y] + 1 + "";
                }
                if (dist2[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.x][cur.y] + 1) continue;

                dist2[nx][ny] = dist2[cur.x][cur.y] + 1;
                q2.add(new Point(nx, ny));
            }
        }
        return "IMPOSSIBLE";
    }
}
