package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182 {

    public static int N, S;
    public static int[] arr = new int[22];
    public static int cnt;

    public static void solve(int cur, int sum) {
        if (cur == N) {
            if (sum == S) cnt++;
            return;
        }

        solve(cur + 1, sum);
        solve(cur + 1, sum + arr[cur]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);
        if (S == 0) cnt--;
        System.out.println(cnt);
    }

}
