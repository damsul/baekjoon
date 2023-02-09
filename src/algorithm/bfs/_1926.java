package algorithm.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = {0, 0, 1, -1}; // 상하좌우
        int[] dy = {1, -1, 0, 0};

        int m = Integer.parseInt(st.nextToken()); // 행
        int n = Integer.parseInt(st.nextToken()); // 열

        int[][] board = new int[m][n]; // 그림판
        boolean[][] visit = new boolean[m][n]; // 방문표시
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); // 그림 그리기
            }
        }

        int max = 0; // 그림의 최대 넓이
        int num = 0; // 그림 개수

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 || visit[i][j]) {
                    continue;
                }

                num++; // 그림 개수 증가
                visit[i][j] = true; // 방문 표시
                Queue<Point> q = new LinkedList<>();
                q.add(new Point(i, j));
                int area = 0; // 그림의 넓이
                while (!q.isEmpty()) {
                    Point cur = q.poll();
                    area++; // 그림 요소 빼낼때 마다 넓이 증가

                    for (int dir = 0; dir < 4; dir++) { // 상하좌우 방문
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= m || ny >= n) { // 범위 확인
                            continue;
                        }
                        if (visit[nx][ny] || board[nx][ny] != 1) { // 방문 확인, 빈 도화지 확인
                            continue;
                        }

                        visit[nx][ny] = true; // 방문 표시
                        q.add(new Point(nx, ny)); // 그림 요소 추가
                    }
                }
                // 시작점(i,j) 그림 그리기 완료
                max = Math.max(max, area); // 그림 크기 비교
            }
        }

        System.out.println(num);
        System.out.println(max);
    }
}
