package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663 {

    public static int n, cnt;
    public static boolean[] visit1 = new boolean[30]; // 세로
    public static boolean[] visit2 = new boolean[30]; // 오른쪽 위 대각선
    public static boolean[] visit3 = new boolean[30]; // 오른쪽 아래 대각선

    public static void func(int cur) {
        if (cur == n){
            cnt++;
            return;
        }


        for (int i = 0; i < n; i++) {
            if (visit1[i] || visit2[cur + i] || visit3[cur - i + n - 1]) continue;
            visit1[i] = true;
            visit2[cur + i] = true;
            visit3[cur - i + n - 1] = true;

            func(cur + 1);

            visit1[i] = false;
            visit2[cur + i] = false;
            visit3[cur - i + n - 1] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        func(0);

        System.out.println(cnt);
    }
}