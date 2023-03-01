package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11053 {

    public static int n;
    public static int[] dp = new int[1005];
    public static int[] data = new int[1005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        Arrays.sort(dp, 0, n);
        System.out.println(dp[n - 1]);
    }

}