package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12852 {
    public static int n;
    public static int[] dp = new int[1000005];
    public static int[] pre = new int[1000005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            pre[i] = i - 1;
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] =  dp[i / 2] + 1;
                pre[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
                pre[i] = i / 3;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append('\n');

        int cur = n;
        while (cur >= 1) {
            sb.append(cur).append(' ');
            cur = pre[cur];
        }
        System.out.println(sb);
    }

}
