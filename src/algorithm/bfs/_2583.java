package algorithm.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2583 {

    public static int[][] board = new int[101][101];
    public static boolean[][] visit = new boolean[101][101];
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    board[i][j] = 1; // 모눈종이 채우기
                    visit[i][j] = true; // 방문 표시
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] || board[i][j] == 1) continue;

                visit[i][j] = true;
                Queue<Point> q = new LinkedList<>();
                q.add(new Point(i, j));
                int area = 0;
                while (!q.isEmpty()) {
                    Point cur = q.poll();
                    area++;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if (visit[nx][ny] || board[nx][ny] == 1) continue;

                        visit[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
                list.add(area);
            }
        }
//        Collections.sort(list);
        list.sort(Comparator.naturalOrder());
        System.out.println(list.size());
        for (int n : list) {
            System.out.print(n + " ");
        }
    }
}
