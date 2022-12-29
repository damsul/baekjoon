package algorithm.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11659 {
    // n개의 갯수
    // m번의 횟수 최소=1 최대=100000
    // x-y 구간합
    public static void main(String[] args) throws IOException {
        // n, m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 배열 a에 n개의 숫자 입력
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n + 1];
        int[] psum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            // 누적합
            psum[i] = psum[i - 1] + a[i];
        }

        // x, y 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 구간합 계산
            int sum = psum[y] - psum[x-1];
            System.out.println(sum);
        }
    }
}
