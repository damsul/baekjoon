package algorithm.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012 {

    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로
            int N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            board = new int[52][52];
            visited = new boolean[52][52];

            while (K-- > 0) { // 배추 심기
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }

            int num = 0; // 지렁이 개수
            Queue<Point> q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] || board[i][j] != 1) continue; // 시작점 찾기

                    num++; // 시작점 찾으면 지렁이 수 증가
                    visited[i][j] = true; // 방문 표시
                    q.add(new Point(j, i)); // 배추 시작점 넣기
                    while (!q.isEmpty()) {
                        Point cur = q.poll();

                        for (int dir = 0; dir < 4; dir++) { // 상하좌우 이동
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];

                            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue; // 범위 확인
                            if (visited[ny][nx] || board[ny][nx] != 1) continue; // 방문하지 않은 배추 찾기

                            visited[ny][nx] = true; // 찾은 배추 방문 표시
                            q.add(new Point(nx, ny)); // 배추 요소 증가
                        }
                    }
                }
            }
            System.out.println(num);
        }
    }
}
