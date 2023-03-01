package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461 {

    public static int n, t;
    public static long[] dp = new long[105];
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;
            for (int i = 6; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 5];
            }
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
    }

}
