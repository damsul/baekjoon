package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2447 {

    public static int N;
    public static char[][] board = new char[2200][2200];

    // 크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴
    // N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태
    public static void pattern(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (i == x + 1 && j == y + 1) { // 가운데 공백 처리
                    board[i][j] = ' ';
                    continue;
                }
                board[i][j] = '*';
            }
        }
    }

    public static void blank(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void solve(int x, int y, int z) {
//        if (z == 3) {
//            pattern(x, y, z);
//            return;
//        }
        if (z == 1) {
            board[x][y] = '*';
            return;
        }

        int n = z / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
//                    blank(x + i * n, y + j * n, n);
                    continue;
                }
                solve(x + i * n, y + j * n, n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], ' ');
        }

        solve(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
