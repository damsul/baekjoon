package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579 {

    public static int N;
    public static int[][] dp = new int[305][3];
    public static int[] s = new int[305];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 계단 개수

        for (int i = 1; i <= N; i++) { // 계단 점수 입력
            s[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(s[1]);
            return;
        }

        dp[1][1] = s[1];
        dp[1][2] = 0;
        dp[2][1] = s[2];
        dp[2][2] = s[1] + s[2];
        for (int i = 3; i <= N; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + s[i]; // 연속적으로 1번째로 밟은 계단
            dp[i][2] = dp[i - 1][1] + s[i]; // 연속적으로 2번째로 밟은 계단
        }
        System.out.println(Math.max(dp[N][1], dp[N][2]));

    }

}
