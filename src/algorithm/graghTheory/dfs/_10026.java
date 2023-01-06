package algorithm.graghTheory.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10026 {
    public static int n;
    public static String[][] arr;
    public static boolean[][] visited;
    public static int[] mx = {0, 0, 1, -1};
    public static int[] my = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().toUpperCase().split("");
            for (int j = 0; j < n; j++) {
                String s = strings[j];
                arr[i][j] = s;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int a = cnt;

        cnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!arr[i][j].equals("B")) {
                    arr[i][j] = "R";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int b = cnt;

        System.out.println(a + " " + b);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        String str = arr[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (!arr[nx][ny].equals(str)) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }

            dfs(nx, ny);
        }

    }



}
