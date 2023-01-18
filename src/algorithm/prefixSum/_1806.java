package algorithm.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1806 {

    public static void main(String[] args) throws IOException {
        // n 짜리 수열, s : 연속된 수들의 부분합

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] a = new int[n + 1];
        int[] psum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            psum[i] = psum[i - 1] + a[i];
        }

        int minLength = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (psum[i] - psum[j] >= s && minLength > i - j) {
                    minLength = i - j;
                }
            }
        }

        System.out.println(minLength);

    }
}


