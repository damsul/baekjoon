package algorithm.dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _14002 {

    public static int n, cnt;
    public static int[] data = new int[1003];
    public static int[] dp = new int[1003];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        cnt = dp[1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (data[i] > data[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            cnt = Math.max(cnt, dp[i]);
        }

        Stack<Integer> s = new Stack<>();
        for (int i = n; i >= 1; i--) {
            if (dp[i] != cnt) continue;
            s.push(data[i]);
            cnt--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.size()).append('\n');
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb);
    }

}
