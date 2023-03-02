package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844 {

    public static int n;
    public static long[][] dp = new long[103][10];
    public static long mod = 1000000000;
    public static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 첫 번째 자릿수는 오른쪽 맨 끝 자릿수이므로 경우의 수가 1개밖에 없음
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 두 번째 자릿수부터 n 까지 탐색
        for (int i = 2; i <= n; i++) {
            // i번째 자리수의 자리값들을 탐색(0~9)
            for (int k = 0; k < 10; k++) {
                // 자리수 0,9 -> +1, 나머지 +2
                if (k != 0) dp[i][k] += dp[i - 1][k - 1];
                if (k != 9) dp[i][k] += dp[i - 1][k + 1];
                dp[i][k] = dp[i][k] % mod;
            }
        }

        // n번째 자리수의 각 자리값마다 경우의 수를 더해준다.
        for (int k = 0; k < 10; k++) {
            ans = (ans + dp[n][k]) % mod;
        }
        System.out.println(ans);
    }

}
