package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11724 {

    public static int[][] board = new int[1005][1005];
    public static boolean[] visited = new boolean[1005];
    public static int n, m, u, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점 개수
        m = Integer.parseInt(st.nextToken()); // 간선 개수

        // 간선 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            board[u][v] = board[v][u] = 1;
        }

        // bfs
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            cnt++;
//            bfs(i);
            dfs(i);
        }

        System.out.println(cnt);
    }

    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= n; i++) {
                if (visited[i] || board[cur][i] != 1) continue;

                visited[i] = true;
                q.add(i);
            }
        }
    }

    public static void dfs(int x) {
        visited[x] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && board[x][i] == 1)
                dfs(i);
        }
    }

}
