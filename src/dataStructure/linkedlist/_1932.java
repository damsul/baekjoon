package dataStructure.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932 {

    public static int n;
    public static int[][] dp = new int[505][505];
    public static int[][] board = new int[505][505];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        // 삼각형 입력
        // dp
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = board[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i - 1][j]) + board[i][j];
            }
        }

        int max = -1;
        for (int i = 1; i <= n; i++) {
            if (max < dp[n][i]) max = dp[n][i];
        }

        System.out.println(max);

    }
}
