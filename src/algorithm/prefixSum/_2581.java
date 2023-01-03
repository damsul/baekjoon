package algorithm.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2581 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[11];
        int[] psum = new int[111];
        for (int i = 1; i <= 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            psum[i] = psum[i - 1] + arr[i];
        }

        int sum = 0;
        int dif = Integer.MAX_VALUE;
        for (int i = 1; i <= 10; i++) {

            if (dif > Math.abs(psum[i] - 100)) {
                dif = Math.abs(psum[i] - 100);
                sum = psum[i];
            }
            if (dif == Math.abs(psum[i + 1] - 100)) {
                sum = psum[i + 1];
            }
            if (sum >= 100) {
                break;
            }
        }
        System.out.println(sum);
    }

}
