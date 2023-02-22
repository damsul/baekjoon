package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _1463 {

    public static int N;
    public static int[] dist = new int[1000005];
    public static int[] dp = new int[1000005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

//        Arrays.fill(dist, -1);
//        Arrays.fill(dp, -1);

       /* Queue<Integer> q = new LinkedList<>();
        dist[N] = 0;
        q.add(N);
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur < 1) continue;
            if (dist[cur / 3] == -1 && cur % 3 == 0) {
                dist[cur / 3] = dist[cur] + 1;
                q.add(cur / 3);
            }
            if (dist[cur / 2] == -1 && cur % 2 == 0) {
                dist[cur / 2] = dist[cur] + 1;
                q.add(cur / 2);
            }
            if (dist[cur - 1] == -1) {
                dist[cur - 1] = dist[cur] + 1;
                q.add(cur - 1);
            }
        }
        System.out.println(dist[1]);*/

        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        System.out.println(dp[N]);

    }

}
