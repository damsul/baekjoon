package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569 {

    public static int[][][] board = new int[102][102][102];
    public static int[][][] dist = new int[102][102][102];
    public static int[] dx = {0, 0, 0, 0, 1, -1}; // 상하좌우위아래
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {1, -1, 0, 0, 0, 0};
    public static int M, N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < H; i++) { // 높이
            for (int j = 0; j < N; j++) { // 행
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) { // 열
                    board[i][j][k] = Integer.parseInt(st.nextToken()); // 토마토 넣기

                    if (board[i][j][k] == 0) { // 안 익은 토마토 확인
                        dist[i][j][k] = -1;
                    }
                    if (board[i][j][k] == 1) {
                        q.add(new Point(k, j, i)); // 익은 토마토 큐에 추가
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int dir = 0; dir < 6; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                int nz = cur.z + dz[dir];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) continue;
                if (dist[nz][ny][nx] != -1 || board[nz][ny][nx] != 0) continue;

                dist[nz][ny][nx] = dist[cur.z][cur.y][cur.x] + 1;
                q.add(new Point(nx, ny, nz));
            }
        }

        int ans = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (dist[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }

                    ans = Math.max(ans, dist[i][j][k]);
                }
            }
        }
        System.out.println(ans);
    }
}

class Point {

    int x;
    int y;
    int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}