package dataStructure.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4344 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (c-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] numArr = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
                sum += numArr[i];
            }
            double avg = (double) sum / n;

            int cnt = 0;
            for (int score : numArr) {
                if (score > avg) {
                    cnt++;
                }
            }

            double avg2 = (double) cnt / n * 100;
            System.out.printf("%.3f%%\n", avg2);
        }
    }

}
