package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579_1 {

    public static int N, sum;
    public static int[] dp = new int[305];
    public static int[] s = new int[305];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 계단 개수

        for (int i = 1; i <= N; i++) { // 계단 점수 입력
            s[i] = Integer.parseInt(br.readLine());
            sum += s[i];
        }
        if (N <= 2) {
            System.out.println(sum);
            return;
        }

        dp[1] = s[1];
        dp[2] = s[2];
        dp[3] = s[3];
        for (int i = 4; i < N; i++) {
            // i번째 계단까지 올라섰을 때 밟지 않을 계단의 합 최소값
            // , 단 i번째 계단은 반드시 밟지 않을 계단이여야 한다.
            dp[i] = Math.min(dp[i - 2], dp[i - 3]) + s[i];
        }
        System.out.println(sum - Math.min(dp[N - 1], dp[N - 2]));
    }

}
