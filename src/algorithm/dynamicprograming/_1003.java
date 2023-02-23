package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003 {

    public static int t,n;
    public static int[][] dp = new int[45][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            dp[0][0] = 1; // n = 0 일때 f(0) 출력 횟수
            dp[0][1] = 0; // n = 0 일때 f(1) 출력 횟수
            dp[1][0] = 0; // n = 1 일때 f(0) 출력 횟수
            dp[1][1] = 1; // n = 1 일때 f(1) 출력 횟수
            for (int i = 2; i <= n; i++) {
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
            }
            sb.append(dp[n][0]).append(' ').append(dp[n][1]).append('\n');
        }
        System.out.println(sb);
    }

}
