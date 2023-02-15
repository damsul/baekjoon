package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6593 {

    public static char[][][] board = new char[31][31][31];
    public static int[][][] dist = new int[31][31][31];
    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    public static int X, Y, Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            Z = Integer.parseInt(st.nextToken()); // 높이
            X = Integer.parseInt(st.nextToken()); // 행
            Y = Integer.parseInt(st.nextToken()); // 열

            if (Z == 0 && X == 0 && Y == 0) break;

            Queue<Point1> q = new LinkedList<>();
            Point1 end = new Point1(-1,-1,-1);
            for (int z = 0; z < Z; z++) { // 빌딩 정보 넣기
                for (int x = 0; x < X; x++) {
                    char[] chars = br.readLine().toCharArray();
                    for (int y = 0; y < Y; y++) {
                        board[x][y][z] = chars[y];
                        dist[x][y][z] = -1;

                        if (board[x][y][z] == 'S') {
                            dist[x][y][z] = 0;
                            q.add(new Point1(x, y, z));
                        }

                        if (board[x][y][z] == 'E') {
                            end = new Point1(x, y, z);
                        }
                    }
                }
                br.readLine();
            }

            while (!q.isEmpty()) {
                Point1 cur = q.poll();



                for (int dir = 0; dir < 6; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    int nz = cur.z + dz[dir];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= X || ny >= Y || nz >= Z)
                        continue;
                    if (dist[nx][ny][nz] >= 0 || board[nx][ny][nz] == '#')
                        continue;

                    dist[nx][ny][nz] = dist[cur.x][cur.y][cur.z] + 1;
                    q.add(new Point1(nx, ny, nz));
                }
            }

            if (dist[end.x][end.y][end.z] >= 0) {
                sb.append("Escaped in ").append(dist[end.x][end.y][end.z]).append(" minute(s).\n");
            } else {
               sb.append("Trapped!\n");
            }
        }
        System.out.println(sb);
    }
}

class Point1 {

    int x;
    int y;
    int z;

    public Point1(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}