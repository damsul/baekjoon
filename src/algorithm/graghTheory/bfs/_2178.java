package algorithm.graghTheory.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178 {
    public static int n, m;
    public static boolean[][] visited;
    public static int[][] mirror;
    public static int[] x = {1, -1, 0, 0}; // 동서남북
    public static int[] y = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mirror = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                mirror[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(0,0);
        System.out.println(mirror[n-1][m-1]);
    }

    public static void bfs(int px, int py) {
//        Queue<Integer> q = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[n][m];
//        q.add(px);
//        q.add(py);
        q.add(new Node(px, py));
        visited[py][px] = true;

        while (!q.isEmpty()) {
//            int newX = q.poll();
//            int newY = q.poll();
            Node nd = q.poll();

            for (int i = 0; i < 4; i++) {
//                int nx = newX + x[i];
//                int ny = newY + y[i];
                int nx = nd.nodeX + x[i];
                int ny = nd.nodeY + y[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {continue;}
                if (mirror[ny][nx] == 0) {continue;}
                if (visited[ny][nx]) {continue;}

//                q.add(nx);
//                q.add(ny);
                q.add(new Node(nx, ny));

//                mirror[ny][nx] = mirror[newY][newX] + 1;
                mirror[ny][nx] = mirror[nd.nodeY][nd.nodeX] + 1;
                visited[ny][nx] = true;
            }
        }

    }
}

class Node {
    int nodeX;
    int nodeY;

    Node(int x, int y) {
        this.nodeX = x;
        this.nodeY = y;
    }

}


