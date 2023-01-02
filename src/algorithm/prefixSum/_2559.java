package algorithm.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n + 1];
        int[] psum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            psum[i] = psum[i - 1] + a[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            int temp = psum[i] - psum[i - k];
            if (max < temp) {
                max = temp;
            }
        }
        System.out.println(max);

    }

}
