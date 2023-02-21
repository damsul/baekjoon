package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2448 {
    public static int N;
    public static char[][] board = new char[3100][3100 * 2 - 1]; // 1024 *3

    public static void func(int x, int y, int z) {
        if (z == 3) {
            board[x][y] = '*';
            board[x+1][y-1] = '*'; board[x+1][y+1] = '*';
            for (int i = y-2; i <= y+2; i++) {board[x + 2][i] = '*';}
            return;
        }

        int n = z / 2;
        func(x, y, n);
        func(x + n, y - n, n);
        func(x + n, y + n, n);
//        for (int i = 1; i <= 3; i++) {
//            for (int j = 1; j <= 3 - i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= 2 * i - 1; j++) {
//                System.out.print("*");
//            }
//            for (int j = 1; j <= 3 - i; j++) {
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], ' ');
        }

        func(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
        
    }

}
