package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1912 {

    public static int n, idx, max;
    public static int[] dp = new int[100005];
    public static int[] data = new int[100005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            dp[i] = data[i];
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + data[i]);
        }
        Arrays.sort(dp, 1, n + 1); // 배열 idx 1 ~ n 까지 정렬
//        Arrays.sort(dp); // 배열 전체 정렬
//        int ans = Arrays.stream(dp).max().getAsInt(); // 배열 전체 정렬
        System.out.println(dp[n]);
//        System.out.println(ans);
    }

}
