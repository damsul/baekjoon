package algorithm.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2667 {
    public static char[][] board = new char[101][101];
    public static boolean[][] visited = new boolean[101][101];
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) { // 지도 그리기
            board[i] = br.readLine().toCharArray();
        }

        List<Integer> list = new ArrayList<>(); // 단지 담을 리스트
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || board[i][j] == '0') continue;

                visited[i][j] = true;
                Queue<Point> q = new LinkedList<>();
                q.add(new Point(i, j));
                int area = 0;
                while (!q.isEmpty()) {
                    Point cur = q.poll();
                    area++;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (visited[nx][ny] || board[nx][ny] != '1') continue;

                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
                list.add(area);
            }
        }
        list.sort(Comparator.naturalOrder()); // 오른차순 정렬
        System.out.println(list.size());
        for (int n : list) {
            System.out.println(n);
        }
    }

}
