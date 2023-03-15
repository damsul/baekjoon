package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11054 {

    public static int n;
    public static int[] data = new int[1005];
    public static int[] r_dp = new int[1005];
    public static int[] l_dp = new int[1005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) { // 수열 입력
            data[i] = Integer.parseInt(st.nextToken());
            r_dp[i] = 1;
            l_dp[i] = 1;
        }

        for (int i = 1; i <= n; i++) { // 증가수열 길이 측정
            for (int j = 1; j < i; j++) {
                if (data[i] > data[j]) {
                    r_dp[i] = Math.max(r_dp[i], r_dp[j] + 1);
                }
            }
        }

        for (int i = n; i > 0; i--) { // 감소수열 길이 측정
            for (int j = n; j > i; j--) {
                if (data[i] > data[j]) {
                    l_dp[i] = Math.max(l_dp[i], l_dp[j] + 1);
                }
            }
        }

        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) { // 증가 + 감소 = 바이토닉 수열
            result[i] = r_dp[i] + l_dp[i] - 1; // -1 해주는 이유: 수열을 합칠 때 기준 값이 중복되기 때문이다.
        }
        Arrays.sort(result);

        System.out.println(result[n]);
    }
}
