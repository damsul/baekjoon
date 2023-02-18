package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663 {
    public static int N, cnt;
    public static boolean[] issued1 = new boolean[30]; // y
    public static boolean[] issued2 = new boolean[30]; // x+y
    public static boolean[] issued3 = new boolean[30]; // x-y+n-1

    public static void solve(int cur) {
        if (cur == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(issued1[i]) continue;
            if(issued2[cur + i]) continue;
            if(issued3[cur - i + N - 1]) continue;

            issued1[i] = true;
            issued2[cur + i] = true;
            issued3[cur - i + N - 1] = true;
            solve(cur + 1);

            issued1[i] = false;
            issued2[cur + i] = false;
            issued3[cur - i + N - 1] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        solve(0);
        System.out.println(cnt);
    }

}
