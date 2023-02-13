package algorithm.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012 {

    public static int[][] board = new int[52][52];
    public static boolean[][] visited = new boolean[52][52];
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int M, N, K;

    public static void bfs( int i, int j) {
        Queue<Point> q = new LinkedList<>();
        visited[i][j] = true; // 방문 표시
        q.add(new Point(i, j)); // 배추 시작점 넣기
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int dir = 0; dir < 4; dir++) { // 상하좌우 이동
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue; /* 범위 확인 */
                if (visited[nx][ny] || board[nx][ny] != 1) continue; /* 방문하지 않은 배추 찾기 */

                visited[nx][ny] = true; // 찾은 배추 방문 표시
                q.add(new Point(nx, ny)); // 배추 추가
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 행
            N = Integer.parseInt(st.nextToken()); // 열
            K = Integer.parseInt(st.nextToken()); // 배추 개수



            while (K-- > 0) { // 배추 심기
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            int num = 0; // 지렁이 개수
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] || board[i][j] != 1) continue; // 시작점 찾기
                    num++; // 시작점 찾으면 지렁이 수 증가
                    bfs(i, j); // 배추 찾기
                }
            }
            System.out.println(num);

            for (int i = 0; i < M; i++) { // 배열 초기화, 행
                Arrays.fill(board[i], 0); // 열
                Arrays.fill(visited[i], false); // 열
            }
        }
    }
}
