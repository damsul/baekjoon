package algorithm.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562 {

    public static int[][] board = new int[302][302];
    public static int[][] dist = new int[302][302];
    public static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            I = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point night = new Point(x, y);

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Point target = new Point(x, y);

            for (int i = 0; i < I; i++) {
                Arrays.fill(dist[i], -1);

            }
            dist[night.x][night.y] = 0;
            Queue<Point> q = new LinkedList<>();
            q.add(night);
            while (!q.isEmpty()) {
                if (dist[target.x][target.y] != -1) break;
                Point cur = q.poll();

                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
                    if (dist[nx][ny] >= 0) continue;

                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }

            System.out.println(dist[target.x][target.y]);
        }
    }

}
