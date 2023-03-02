package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2240 {

    public static int t,w;
    public static int[][][] dp = new int[1003][33][3]; // d[i][j][k]: i:현재시간, j:이동횟수, k:나무번호
    public static int[] data = new int[1005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= t; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= t; i++) {
            // 이동하지 않는 경우
            dp[i][0][1] = dp[i - 1][0][1] + (data[i] == 1 ? 1 : 0);
            // 이동한 경우
            for (int j = 1; j <= w; j++) {
                if (i < j) break;
                if (data[i] == 1) { // i초에 1번 나우에서 떨어질 경우
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i - 1][j][1]) + 1;
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]);
                } else { // i초에 2번 나우에서 떨어질 경우
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i - 1][j][1]);
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]) + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= w; i++) {
            max = Math.max(max, dp[t][w][1]);
            max = Math.max(max, dp[t][w][2]);
        }
        System.out.println(max);
    }
}
