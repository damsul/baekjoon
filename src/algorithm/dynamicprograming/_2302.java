package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _2302 {

    public static int n, m;
    public static int[] dp = new int[45];
    public static int[] data = new int[45];
    public static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 전체 좌석 개수
        m = Integer.parseInt(br.readLine()); // vip 좌석 개수

        list.add(0);
        for (int i = 1; i <= m; i++) {
//            data[i] = Integer.parseInt(br.readLine()); // vip 좌석 입력
            list.add(Integer.parseInt(br.readLine())); // vip 좌석 입력
        }
        list.add(n + 1);

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int ans = 1;
//        for (int i = 1; i <= m; i++) {
//            ans *= dp[data[i] - data[i - 1] - 1];
//        }
//        ans *= dp[n - data[m]];
        for (int i = 1; i < list.size(); i++) {
            ans *= dp[list.get(i) - list.get(i - 1) - 1];
        }
        System.out.println(ans);
    }
// 0 4 7 10
}
