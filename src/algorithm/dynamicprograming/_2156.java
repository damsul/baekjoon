package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2156 {

    public static int n;
    public static int[] data = new int[10005];
    public static int[] dp = new int[10005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = data[1];
        dp[2] = data[1] + data[2];
        int max = -1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1],
                Math.max(dp[i - 2] + data[i], dp[i - 3] + data[i - 1] + data[i]));
        }
        System.out.println(dp[n]);
    }

}
