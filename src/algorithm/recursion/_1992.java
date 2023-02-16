package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992 {
    public static int N;
    public static int[][] board = new int[65][65];
    public static StringBuilder sb = new StringBuilder();

    public static boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++)
            for (int j = y; j < y + n; j++)
                if (board[x][y] != board[i][j]) return false;

        return true;
    }
    public static void solve(int x, int y, int z) {
        if (check(x, y, z)) {
            sb.append(board[x][y]);
        } else {
            int n = z / 2;

            sb.append("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    solve(x + i * n, y + j * n, n);
                }
            }
            sb.append(")");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
//            String[] s = br.readLine().split("");
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
//                board[i][j] = Integer.parseInt(s[j]);
                board[i][j] = s.charAt(j) - '0';
            }
        }
        solve(0, 0, N);

        System.out.println(sb);
    }

}
