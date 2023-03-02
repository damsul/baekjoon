package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14501 {

    public static int n;
    public static int[] dp = new int[20]; // i번째 일에 상담을 시작헀을 때 얻을 수 있는 최대 이익
    public static int[] t = new int[20]; // 상담일 수
    public static int[] p = new int[20]; // 상담 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i >= 1; i--) {
            if (i + t[i] <= n + 1) {
                dp[i] = Math.max(dp[i + t[i]] + p[i], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
//        Arrays.sort(dp, 1, n + 1);
        System.out.println(dp[1]);
    }

}
