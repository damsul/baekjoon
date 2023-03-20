package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206 {

    // 0: 이동 가능
    // 1: 이동 불가능
    // 1,1 -> n,m 까지 이동
    // 최단 경로는?
    public static int n, m;
    public static char[][] board = new char[1005][1005];
    public static int[][][] dist = new int[1005][1005][2];
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        int ans = bfs();
        System.out.println(ans);
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1, 0));
        dist[1][1][0] = dist[1][1][1] = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == n && cur.y == m) return dist[cur.x][cur.y][cur.broken];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                int broken = cur.broken;

                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if (board[nx][ny] == '0') {
                    if (dist[nx][ny][broken] == -1) {
                        dist[nx][ny][broken] = dist[cur.x][cur.y][broken] + 1;
                        q.add(new Point(nx, ny, broken));
                    }
                } else {
                    if (broken != 1 && dist[nx][ny][1] == -1){
                        dist[nx][ny][1] = dist[cur.x][cur.y][broken] + 1;
                        q.add(new Point(nx, ny, 1));
                    }
                }
            }
        }
        return -1;
    }

    static class Point{
        int x;
        int y;
        int broken;

        public Point(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }

}
