package algorithm.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2468 {

    public static int[][] board = new int[101][101];
    public static boolean[][] visited = new boolean[101][101];
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int top = 0; // 빌딩 최고 높이
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); // 지역 빌딩 정보 입력
                top = Math.max(top, board[i][j]); // 빌딩 최고 높이 설정
            }
        }

        int ans = 1; // 최대 안전 영역 개수 = 답
        for (int floor = 1; floor < top; floor++) { // 높이 1~100
            int num = 0; // 안전 영역 개수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] || board[i][j] <= floor) continue;

                    num++;
                    visited[i][j] = true;
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));
                    while (!q.isEmpty()) {
                        Point cur = q.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            if (visited[nx][ny] || board[nx][ny] <= floor) continue;

                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny));
                        }
                    }
                }
            }
            // 층이 끝날 떄 마다
            ans = Math.max(ans, num); // 최대 안전 영역 수 비교
            for (int i = 0; i < N; i++) { // 방문표시 초기화
                Arrays.fill(visited[i], false);
            }
        }
        System.out.println(ans);
    }

}
