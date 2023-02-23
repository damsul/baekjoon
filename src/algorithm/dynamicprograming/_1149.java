package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149 {

    public static int N;
    public static int[][] data = new int[1005][3];
    public static int[][] dp = new int[1005][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 집 개수
        StringTokenizer st;
        for (int i = 1; i <= N; i++) { // 페인트 칠하는 비용 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) { // 0 : R, 1 : G, 2 : B
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][0] = data[1][0]; // 빨강
        dp[1][1] = data[1][1]; // 초록
        dp[1][2] = data[1][2]; // 파랑
        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + data[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + data[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + data[i][2];
        }

        int tmp = Math.min(dp[N][0], dp[N][1]);
        int ans = Math.min(tmp, dp[N][2]);
        System.out.println(ans);
    }

}
