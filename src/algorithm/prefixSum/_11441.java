package algorithm.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11441 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n + 1];
        int[] psum = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int k = 1; k <= n; k++) {
            a[k] = Integer.parseInt(st.nextToken());
            psum[k] = psum[k - 1] + a[k];
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(psum[j] - psum[i - 1]);
        }

    }

}
